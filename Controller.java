import java.util.ArrayList;

//class controller handling all threads methods, some of them are synchronized
public class Controller {

	//variable - number of active threads
	private int activeThreads;

	//constructor - initialize active threads to 0
	public Controller() {
		activeThreads  = 0;
	}

	//method to increase the number of running threads by 1
	public void setActiveThreads() {
		this.activeThreads++;
	}

	//method to decrease the number of active threads by 1 and notify other threads that a specific thread is finished
	public synchronized void done()
	{
		activeThreads--;
		notifyAll();
	}

	//method that will allow the program to wait until all threads are finished
	public synchronized void waitForAll()
	{
		while(activeThreads > 0)
			try {
				wait();
			}
		catch(InterruptedException e){}
	}

	//synchronized method to remove 2 numbers from storage, sum the numbers and add the result back to the storage
	public synchronized void syncSum(ArrayList<Integer> s)
	{
		int num1 = 0;
		int num2 = 0;

		//take element from storage if it has at least one element
		if(s.size() >0) {
			num1 = s.remove(0);

			//uncomment line below to print the element to be removed
			//System.out.println("num1: " + num1 + " is removed");

			if(!s.isEmpty()) {
				num2 = s.remove(0);

				//uncomment line below to print the element to be removed
				//System.out.println("num2: " + num2 + " is removed");
			}

		}
		//sum 2 elements
		num1 += num2;

		//add the result to the storage
		s.add(num1);

		//uncomment line below to print the result to be added to the storage
		//System.out.println("number: " + num1 + " was added to storage");

		//remove un-relevant element from storage
		if(s.get(0)==0)
			s.remove(0);

		//let other threads to know this thread is finished
		notifyAll();
	}

}//end of class Controller
