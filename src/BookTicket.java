
public class BookTicket extends Thread {
	
	//Dont give the provision to access these instance variable directly, if someone wants to access these instance variables then they have to go for calling getter and setter methods. 
	private Train train;//every class in java can act as a separate data type
	private Compartment comp;
	
	BookTicket(Train train, Compartment comp)//to initialize both train and compartment objects, we need to pass the two parameters (parameterized constructor)
	{
		this.train = train;
		this.comp = comp;
	}
	
	//now whatever we r doing either extending thread class or implementing runnable interface we need to use @Override run method.
	@Override		
	public void run()
	{
		System.out.println("BookTicket is trying to lock train object");
		
		synchronized(train)//this means here this class object BookTicket object but since we have to lock train method object. so we need to use "train" instead of this
		{
			System.out.println("BookTicket is locked train");
			try{
			Thread.sleep(1000);//1000 milli seconds = 1 sec
			} catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
			System.out.println("BookTicket is trying to lock compartment object");
			synchronized(comp)
			{
				System.out.println("BookTicket is trying to lock comp");
				
			}
			System.out.println("BookTicket is released compartment");
		}
		System.out.println("BookTicket released train object also");
		
	}
	
	
	
	
	
}
