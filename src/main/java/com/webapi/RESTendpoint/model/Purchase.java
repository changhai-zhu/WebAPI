package com.webapi.RESTendpoint.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Purchase {
	private String strDate;  //String pattern = "MM-dd-yyyy"; 
	private String name;  
	private double amount; 
	private Date simpleDate;
	private int points;
	private Calendar cal;

	public Purchase() {}  
	
	public Purchase(String strDate, String name, double amount) throws ParseException {  
		super(); 
		this.strDate = strDate;
		this.name = name;  
		this.amount = amount;  
		this.points = calculatePoints(amount);
		this.simpleDate =  calculateSimpleDate(strDate);
		this.cal =  calculateCal(this.simpleDate);
	} 
	
	public Purchase(String strDate, Date simpleDate, Calendar cal, String name, double amount, int points) {  
		super(); 
		this.strDate = strDate;
		this.simpleDate =  simpleDate;
		this.cal =  cal;
		this.name = name;  
		this.amount = amount;  
		this.points = points;  
	} 	

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public String getName() {  
		return name;  
	}  
	
	public void setName(String name) {  
		this.name = name;   
	}  
	
	public double getAmount() {  
		return amount;  
	}  
	
	public void setAmount(int amount) {  
		this.amount = amount;  
	} 
	
	public int getPoints() {  
		return points;  
	}  
	
	public void setPoints(int points) {  
		this.points = points;  
	}  
	
	public Date getSimpleDate() {
		return simpleDate;
	}

	public void setSimpleDate(Date simpleDate) {
		this.simpleDate = simpleDate;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}
/*
	A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.	 
	A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
	(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
	 
	Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.	 
*/
	private int calculatePoints(double amount) { 
		int pts;
		int amt_over_50, amt_over_100;
		amt_over_50 = (int)(amount-50);
		amt_over_100 = (int)(amount-100);
		
		if( amount <= 50 ) return 0;
		if( amount > 50 && amount <= 100 ) return amt_over_50;
		pts = 50 + amt_over_100*2; 	
		this.points = pts;
		
		return pts;
	}
	

	private Date calculateSimpleDate(String strDate) throws ParseException { 
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = simpleDateFormat.parse(strDate);
		System.out.println(date);
		this.simpleDate = date;
		
		return simpleDate;
	} 
	

	private Calendar calculateCal( Date date ) { 
		cal = Calendar.getInstance();
		cal.setTime(date);
		//if(cal.get(Calendar.YEAR) == cal.get(Calendar.YEAR))
		System.out.println("Year: " + cal.get(Calendar.YEAR) + " Month: " + cal.get(Calendar.MONTH));
		
		return cal;
	} 
	
    @Override
    public String toString() {
    	//this.points = calculatePoints(this.amount);
        return "Purchases: strDate=" + strDate +" Name=" + name + " Amount" + amount + " Points=" + points;
    }
    
}
