/*
 * Author: Shai Gotlieb
 * Date: 06/06/2018
 * Q1 MMN 15
 * */
import java.util.ArrayList;
import javax.swing.JOptionPane;

//class MMN15 represent main
public class Mmn15
{
	public static void main(String[] args)
	{
		//getting input from user
		int n = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Size Of Array:"));
		int m = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Number Of Threads:"));

		int threadIndex = 0;

		//array of random numbers from 1-100
		int[] arr = new int[n];

		//ArrayList storage represent the storage of the elements from the array arr
		ArrayList<Integer> storage = new ArrayList<>();

		//initialize object Controller that control and handling all threads methods
		Controller c = new Controller();

		//initialize random numbers into array arr with size of n
		for (int i = 0; i < n; i++)
		{
			arr[i] = 1 + (int) (Math.random() * 100);
			//uncomment line below to print numbers in array
			//System.out.println(arr[i]);
		}

		//adding elements from original array to storage
		for (int i = 0; i < arr.length; i++)
		{
			storage.add(arr[i]);
		}

		//creating m threads and start them (calling run() method)
		while(storage.size()>1 && threadIndex < m) {
			(new ThreadSum(storage, c)).start();
		}    

		//wait for all threads to finish their work
		c.waitForAll();   

		//print last element in storage which is the sum
		System.out.println("Sum is: " + storage.get(0));

	}//end of main
}//end of Class MMN15
