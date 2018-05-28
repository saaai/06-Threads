
public class Application {

	public static void main(String[] args)
	{
		Train train = new Train();//
		Compartment comp = new Compartment();
		
		
		BookTicket bt = new BookTicket(train, comp);//CREATING BOOK TICKET object bt and passing train and compartment objects.
		
		CancelTicket ct = new CancelTicket(train, comp);//creating cancel ticket object ct and passing train and compartment object.
		
		bt.start();//starting the thread, using object.start()
		
		ct.start();//starting the thread and this will call the run method internally.
		
		
	}
}

/* dec4 th 
 * _________________________________
 * 
 * if it is a book ticket first we are trying to lock train object and 
 * 						then compartment object.
 * 
 * if it is a cancel ticket first we are trying to lock compartment object and 	
 * 						then trying to lock the train object.
 * 
 * both the resources and threads are occupied. so, one thread is locking resource 1 and it is waiting for resource 2. now, the thread two is locking resource 2 and waiting for resource 1.
 * both of them are not ready to release their resources, but of them are waiting for the other thread resources. so, now this wont terminate and this particular situation is known as "deadlock situation".
 * 
 * DeadLock:
 * means couple of threads are holding their resources, they are not releasing and waiting for the other threads resources, where the other thread are also doing the same.
 * 		both of them are not ready to release their own resources but waiting for other person to release the resources.
 * 
 * when executing this program, it is still running not terminated this is called deadlock situation.
 *
 * Solution to avoid deadlock situation:
 * to avoid we don't have any specific solution, the only thing is we are getting deadlock its due to developers logic.
 * so, whenever we write the logic we need to make sure that deadlock doesn't occur.
 * 
 *Now, instead of coming in two opposite directions. we need to use single direction like even while using CancelTicket we should try to lock train object first and then lock compartment object like TrainTicket, instead of compartment object first and then train object. 
 * 
 * when we access train object with CancelTicket in parallel to the train object with BookTicket, here only the program will try to make the CancelTicket wait for sometime until the BookTicket releases the train object because the BookTicket already locked the train object.
 * when BookTicket release train object it will now try to lock the compartment object, still CancelTicket is waiting for the train object which is ok.
 * 
 * Now, BookTicket will be locking the compartment object, as the compartment object is also free. Then, CancelTicket will be locking the train and then it will be locking the compartment object after this it will finish the execution.
 * 
 * 
 * 
 * 
 */