//displaying the values from 1 to 10 
public class ThreadsDemoMethod2 implements Runnable {
	private String task;
	
	public ThreadsDemoMethod2(String task)//creating the constructor
	{
		this.task = task;
	}
	
	public static void main (String args[]){
		
		ThreadsDemo demo1 = new ThreadsDemo("task1");//creating object 
		//demo1.run();//calling run method using the object created 

		//ThreadsDemo demo2 = new ThreadsDemo("task2");
		//demo2.run();
		
		Thread t1 = new Thread(demo1);//in the pair of paranthesis we are passing demo1 
		Thread t2 = new Thread(demo1);//we can call the same thread naming it as thread t2
									//in the pair of paranthesis we are passing demo1 
		
		t1.start();//when we call this method thread t1 it accesses the run method 
		t2.start();
		//when we are calling this method thread t2, the t1 is already accessing the run method because we used synchronized it will lock the execution for t1 object so t2 will keep on waiting until thread 1 (t1) execution is completed. 
		//we can even set name for the thread
		 
		t1.setName("gopal");//we are setting the name for thread 
		t2.setName("_//\\\\_"); 
//		
//		demo1.start();//start() causes this thread to begin execution, the jvm calls the run method of this thread.
//		demo2.start();
	}

	@Override
	public void run()//run method
	
	{
		synchronized(this)
		{
		Thread t = Thread.currentThread();
		for (int i =1 ; i <10; i++)//loop inside this method which will iterate from 1 to 10
		{
			System.out.println("I value :" + i);
			//System.out.println(this.task);
			
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		System.out.println("thread Name:" + t.getName());
	}
	}
}



/*
Dec 3rd video:
	
	What is a thread? ans: a thread is a light weight process.
	
	Threading is nothing but a separate part of execution.
	
	Thread is a class which is in java.lang package which is a default package.
	
	jvm allows you to have multithread environment.
	
	Every thread will has a priority, if a thread is having high priority it will be executed first.
		if a thread is having low priority its be executed next to the high priority.
	 
	A thread may or may not be marked as a daemon, 
		daemon thread means a thread which is a never ending thread.
			if it is required we mark it as a daemon, 
				if it is not required we don't mark it is a daemon.
	
	If you are trying to  create a thread, from another thread so the parent thread who's having a priority,
		to execute the parent thread that same priority will be applied/copied to the new thread also. 
	
	There are two ways to create a thread and execute it:
	1) one is to declare a class to be a sub class of thread. 
			this subclass should override the run method of class thread.
				An instance(the Object of the subclass(create an object for the sub class)) of the sub class can be allocated and started.
				
	calling the run method directly is different from calling the start method. what's the difference?
		whenever we call the start method it will start the execution of the thread and it will also start the main method.
	answer:
		a)- when you execute run  method it will directly execute only the run method.
		
		b)- but when u call the start method internally it will start the execution of the thread, 
			now what will happen is we are executing the start() method internally we are triggering the run() method.    
			
		- The default running thread in java program is "main thread" it's not due to method main it's just a coincidence of the name.
			
			we can even set name for the thread 
			ex: demo1.setName("gopal");

		For each and every iteration we need to wait for one second, if we can make the thread wait for some time everything will be called in time.
			we need to use the sleep method here, sleep method is  an instance method so we can call directly by using the class name Thread.sleep(milliseconds)
				1000 milliseconds is one second
		
		In the thread class it's not throwing interrupted exception in the run method. 	
			in the java api documentation ther's no interface exception.
			if it is having interface exception we can use it as there's no throws interface exception thats the reason we have to use try catch block method.
			
		At one point of time, you may not be having any control over threads because the threads priority of execution or the threads order of execution.
		 	it will be depending on so many factors like the environment of execution it depends on running environment also, 
		 		sometimes it will be interrupted by eclispe environment also.
		 
		If we don't want to support parallel execution, we need to use synchronization.
		we can make the complete run method as the complete synchronized method. if u make any method as synchronized only one thread will be executing at a time.
			
		ex: put this in the run method 
		synchronized(this)
		{
			//remaining code 
		}
			
	2) The other way to create a thread is to declare a class that implements the runnable interface. that class then implements the run method. 
			An instance of the class can be allocated, passed as an argument when creating thread, and started.
			
			the way they are running it:
			
			ex: PrimeRun p = new PrimeRun(143);//creating an object for the subclass
					if we have to use this instance somewhere else thats the reason we are storing this in the variable and we will be using that variable
				new Thread(p).start();//the subclass object they are trying to pass it through the thread class object
			
			this is also one way to create multiple threads, earlier if u go for extends thread class if u want to create multiple threads you may want to create multiple sub class objects.
			But in this case if you want to create  multiple threads you can use single object.(by using single object you can create multiple threads)
			
			when the object is synchronized and it is already being accessed by first thread it will be locked and the next thread cannot access it until the first finished the execution.
			so, just because of synchronization the second thread is not able access the run method object.
			
			
			
			 
			
	*/