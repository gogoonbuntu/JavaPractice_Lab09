package edu.handong.csee.java.Salesman;

import java.util.Scanner;

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
	private SalesAsso[] team; //to save team members as an array
	private int numSalesman; //to save members of the salesman
	
	public SalesReporter() { 
		//to make a construct. the whole class is a program that reports the sales result.
		System.out.println("Enter number of salesman :");
		Scanner MS = new Scanner(System.in);
		numSalesman = MS.nextInt(); //saved the number of salesmain in the variable.
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
		team = new SalesAsso[numSalesman]; // declare an array, which has the size of the numSalesman variable.
		for(int i=0; i < numSalesman; i++)
		{
			Scanner mySC = new Scanner(System.in);
			
			System.out.println("Get data for asociate number"+(i+1));
			
			System.out.println("Enter name");
			String name = mySC.nextLine();//get a String for name.
			
			System.out.println("Enter Sales:");
			double sales = mySC.nextDouble();//get a double for sales.
			
			SalesAsso mySA = new SalesAsso();//declare a new SalesAsso class.
			mySA.setmName(name);//save name in the object.
			mySA.setSales(sales);//save sales in the object.
			team[i]=mySA;//put the object into the array.
		}
	}
	
	public void Aver() {
		double sum = 0;
		for(int i=0;i<team.length; i++)
		{
			double sales = team[i].getSales(); //read the sales from the array.
			sum += sales;//sequentially accumulate the value in the sum. 
		}
		aver=sum/team.length;//divide it into average value.
	}
	
	public void High() {

		for(int i=0;i<team.length-1; i++)//because we keep compare to the next one, the last sequence should be omitted.
		{
			high = team[i].getSales();
			//originally let high equals to the first one. 
			//without this comment, if the first salesman has the highest value, computer wouldn't know it.
			if(team[i].getSales()<team[i+1].getSales())//compare to the next salesman.
			{
				high = team[i+1].getSales();//let the next one be the highest salesman.
			}
		}
	}
	
	public void printRes() {
		System.out.println("");//to make the result look clear.
		System.out.println("Average sales: $" + aver);//shows the average value.
		System.out.println("Highest sales: $" + high);//shows the highest value.
		System.out.println("");//to make the result look clear.
		System.out.println("The following had the highest sales, ");
		
		for(int i=0;i<team.length; i++)
		{
			if(team[i].getSales()==high)//find out the highest salesman.
			{
				System.out.println("Name:" + team[i].getmName());//shows the name.
				System.out.println("Sales: $" + team[i].getSales());//shows the sales.
				System.out.println((team[i].getSales()-aver)+" above the average.");//shows the differences between the sales and the average.
			}
		}System.out.println("");//to make the result look clear.
		System.out.println("The rest performed as follows");
		for(int i=0;i<team.length; i++)
		{
			if(team[i].getSales()!=high)
			{
				System.out.println("Name:" + team[i].getmName());//shows the name.
				System.out.println("Sales: $" + team[i].getSales());//shows the sales.
				if(aver>team[i].getSales()) System.out.println("$"+(aver-team[i].getSales())+" below the average");
				else System.out.println("$"+(team[i].getSales()-aver)+" above the average");
				//compare the sales to average, shows out the differences.
			}
		}
	}
}
