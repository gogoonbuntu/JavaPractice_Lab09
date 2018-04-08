package edu.handong.csee.java.Salesman;

public class SalesAsso {
	private double sales; //to save the sales of the salesman.
	private String name;//to save the name of the salesman.
	public SalesAsso() //make it a construct.
	{
		sales = 0;
		name = "";
	}
	public void setSales(double s) // a normal setter for sales.
	{
		sales = s;
	}
	public void setmName(String n) // a normal setter for name.
	{
		name = n;
	}
	public double getSales() // a normal getter for sales.
	{
		return sales;
	}
	public String getmName()// a normal getter for name.
	{
		return name;
	}
}
