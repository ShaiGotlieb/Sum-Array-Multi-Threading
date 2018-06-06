import java.util.ArrayList;

//class ThreadSum represent a thread that will add 2 integers from a storage
public class ThreadSum extends Thread{

	//variables cont (controller) and storage (data structure)
	private Controller cont;
	private ArrayList<Integer> storage;

	//constructor to initialize controller and ArrayList
	public ThreadSum(ArrayList<Integer> storage, Controller c)
	{
		this.storage = storage;
		cont = c;
	}

	//method run to activate thread
	@Override
	public void run()
	{
		//let the variable from class Controller to increase the number of active threads by 1
		cont.setActiveThreads();

		//while container have more than 1 element - add them
		while(storage.size() != 1)
		{
			//call synchronized method to remove, sum and add 2 numbers from the storage
			cont.syncSum(storage);			
		}	

		//tell the controller that the specific thread is finished and decrease the amount of active thread by 1
		cont.done();
	}
}//end of class ThreadSum
