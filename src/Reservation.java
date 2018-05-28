
public class Reservation implements Runnable{

	int available = 10;
	int required;//we are not giving required number directly
	
	Reservation(int required)//by creating constructor we are giving required
	{
		this.required = required;
	}
	
	@Override
	public void run()
	{
		String name = Thread.currentThread().getName();
		synchronized(this)
		{

			if(required <= available)//if required number of tickets are less than the available no. of tickets then i will be booking the tickets.
			{
			System.out.println(required + " no of tickets booked for " + name);
			available = available - required;
			}else
			{
			System.out.println(required + " no of tickets not available for " + name);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Reservation reserv = new Reservation(6);//we are passing the required no. of tickets for the user
		Thread t1 = new Thread(reserv);
		Thread t2 = new Thread(reserv);
		
		t1.start();
		t2.start();
	}
	
	
}
