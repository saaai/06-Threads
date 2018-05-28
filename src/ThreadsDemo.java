//displaying the values from 1 to 10 
public class ThreadsDemo extends Thread {
	private String task;
	
	public ThreadsDemo(String task)//creating the constructor
	{
		this.task = task;
	}
	
	public static void main (String args[]){
		
		ThreadsDemo demo1 = new ThreadsDemo("task1");//creating object 
		//demo1.run();//calling run method using the object created 

		ThreadsDemo demo2 = new ThreadsDemo("task2");
		//demo2.run();
		//we can even set name for the thread
		demo1.setName("gopal");//we are setting the name for thread 
		demo2.setName("_//\\\\_"); 
		
		demo1.start();//start() causes this thread to begin execution, the jvm calls the run method of this thread.
		demo2.start();
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
			
			
			continuation in ThreadsDemoMethod2.java file
			
			
			
			
	*/