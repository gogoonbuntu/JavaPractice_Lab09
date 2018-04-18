package edu.handong.csee.java.Salesman;

import java.util.*;

/**
 * @author SeungYoung Jung
 * @version 1.0
 * First use of array in Java and it was successful and interesting. :D
 * JC is such a good teacher.
 * 
 */
public class SalesReporter {
	
	private double high; //to save highest sales.
	private double aver; //to save average value.
	private int numSalesman=0; //to save members of the salesman
	private ArrayList<SalesAsso> team = new ArrayList<SalesAsso>(); // declare an arraylist, which has the size of the numSalesman variable.
	public SalesReporter() { 
		//to make a construct. 
	}
	
	
	
	public static void main(String[] args) {
		//just initiate a SalesReporter, and call the functions in sequence.
		SalesReporter myRep = new SalesReporter();
		myRep.getData();
		myRep.Aver();
		myRep.High();
		myRep.printRes();
	}
	
	public void getData()
	{
		boolean done=false;
		while(!done)//loop starts, when the user type "N" to say no more salesman, it stops.
		{
			Scanner mySC = new Scanner(System.in);
			System.out.println("Get data for asociate number"+(team.size()+1));
			
			System.out.println("Enter name");
			String name = mySC.nextLine();//get a String for name.
			System.out.println("Enter Sales:");
			double sales = mySC.nextDouble();//get a double for sales.
			
			SalesAsso mySA = new SalesAsso();//declare a new SalesAsso class.
			mySA.setmName(name);//save name in the object.
			mySA.setSales(sales);//save sales in the object.
			team.add(mySA);//add mySA to arraylist.
			numSalesman++;//plus one count.
			
			System.out.println("-If you want to add more Salesman, type 'Y', if not type 'N'. current number : "+numSalesman);
			//decide whether to get more salesman or not.
			//mySC.next();//get input.
			String yn = "n";//get input.
			//yn = mySC.nextLine();
			mySC.nextLine();//clear the buffer before get the input.
			yn = mySC.nextLine();//get the input!
			if(yn.equalsIgnoreCase("n")) {mySC.close();done=true;};
			//equalsIgnoreCase gets input without considering it'c capital or not.
			//if it's N/n, the loop stops.
		}
		
	}
	
	public void Aver() {
		double sum = 0;
		for(int i=0;i<team.size(); i++)
		{
			double sales = team.get(i).getSales(); //read the sales from the array.
			sum += sales;//sequentially accumulate the value in the sum. 
		}
		aver=sum/team.size();//divide it into average value.
	}
	
	public void High() {

		for(int i=0;i<team.size()-1; i++)//because we keep compare to the next one, the last sequence should be omitted.
		{
			high = team.get(i).getSales();
			//originally let high equals to the first one. 
			//without this comment, if the first salesman has the highest value, computer wouldn't know it.
			if(team.get(i).getSales()<team.get(i+1).getSales())//compare to the next salesman.
			{
				high = team.get(i+1).getSales();//let the next one be the highest salesman.
			}
		}
	}
	
	public void printRes() {
		System.out.println("");//to make the result look clear.
		System.out.println("Average sales: $" + aver);//shows the average value.
		System.out.println("Highest sales: $" + high);//shows the highest value.
		System.out.println("");//to make the result look clear.
		System.out.println("The following had the highest sales, ");
		
		for(int i=0;i<team.size(); i++)
		{
			if(team.get(i).getSales()==high)//find out the highest salesman.
			{
				System.out.println("Name:" + team.get(i).getmName());//shows the name.
				System.out.println("Sales: $" + team.get(i).getSales());//shows the sales.
				System.out.println((team.get(i).getSales()-aver)+" above the average.");//shows the differences between the sales and the average.
			}
		}System.out.println("");//to make the result look clear.
		System.out.println("The rest performed as follows");
		for(int i=0;i<team.size(); i++)
		{
			if(team.get(i).getSales()!=high)
			{
				System.out.println("Name:" + team.get(i).getmName());//shows the name.
				System.out.println("Sales: $" + team.get(i).getSales());//shows the sales.
				if(aver>team.get(i).getSales()) System.out.println("$"+(aver-team.get(i).getSales())+" below the average");
				else System.out.println("$"+(team.get(i).getSales()-aver)+" above the average");
				//compare the sales to average, shows out the differences.
			}
		}
	}
}
