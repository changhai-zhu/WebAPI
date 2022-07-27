package com.webapi.RESTendpoint.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;
import com.webapi.RESTendpoint.model.IPurchaseService;
import com.webapi.RESTendpoint.model.Purchase; 

@Service  
public class PurchaseService implements IPurchaseService {

	@Override  
	public List<Purchase> findAll( String inputfile ) { 
		// TODO Auto-generated method stub
		
		ArrayList<Purchase> Purchases = new ArrayList<Purchase>();  
		//Purchases.add(new Purchase("07-20-2022", "John",120.00));  

		//readInputfile("input.txt");
        try ( Scanner input = new Scanner(new File(inputfile)) ) {

    		//Items = new ArrayList<Item>();
    		
	        while( input.hasNextLine()) {
	        	String line = input.nextLine();	
	        	System.out.println( line );
	        	String purchase_list[] = line.split("\\s*,\\s*");

	        	double purchase_amount = Double.parseDouble( purchase_list[2] );
	        	Purchases.add(new Purchase(purchase_list[0], purchase_list[1], purchase_amount));
	        }	        	        
        } catch (IOException e) {
			System.out.println("Got IOException. message=" + e.getMessage() );
        } catch (InputMismatchException e) {
			System.out.println("Got InputMismatchException message=" + e.getMessage() );
        } catch (Exception e) {
			System.out.println("Got Exception. message=" + e.getMessage() );
		} finally {
			//do something ?
		}
		
		//returns a list of Purchase  
		return Purchases;  
	}

	@Override
	public String printPurchases(List<Purchase> Purchases) {
		// TODO Auto-generated method stub
		HashSet<String> uniqueCustomers = new HashSet<String>(); 
		uniqueCustomers = geUniqueCustomers(Purchases);
		
		StringBuilder output = new StringBuilder("Purchase Points Summary:");
		output.append("<br>");
		output.append(System.getProperty("line.separator"));
		
	    Iterator<String> iterator = uniqueCustomers.iterator();
	    while(iterator.hasNext()) {
	         String uniqueCustomer = iterator.next();
	         //System.out.println(uniqueCustomer);
	         output.append("<br>");
	         output.append("Customer ").append(uniqueCustomer);
	 		 output.append("<br>");
	         output.append(System.getProperty("line.separator"));
	         
	         int totalCustomer = 0;
	         
	         HashSet<String> uniqueMonth = getUniqueMonthYear( Purchases, uniqueCustomer );
	         
	         Iterator<String> iterMonth = uniqueMonth.iterator();
	 	    	while(iterMonth.hasNext()) {
		         String uniqueMonthYear = iterMonth.next();
		         //System.out.println(uniqueMonthYear);
		         output.append("Month-Year: ").append(uniqueMonthYear).append(" --- ");
		         
		         int sumMonth = getSumMonthYear( Purchases, uniqueCustomer, uniqueMonthYear );
		         totalCustomer += sumMonth;
		         output.append(sumMonth);
		 		 output.append("<br>");
		    }			         
	         
	 	    output.append("Total:").append(" --- ").append(totalCustomer);
	 	    output.append("<br>");
	         
	    }		
		
	    System.out.println(output);
		return output.toString();
		//return "PurChase Summary";
	}  
	
	
	
	private HashSet<String> geUniqueCustomers( List<Purchase> Purchases) {
        HashSet<String> hset = new HashSet<String>();
  
        for(Purchase p : Purchases) {
            hset.add(p.getName());
        }
		return hset;
	}

	/* get Unique Month-Year per Customer */
	private HashSet<String> getUniqueMonthYear( List<Purchase> Purchases, String name ) {
        HashSet<String> hset = new HashSet<String>();
  
        for(Purchase p : Purchases) {
        	if( p.getName().equalsIgnoreCase( name ))
        		hset.add(p.getCal().get(Calendar.MONTH) + "_" + p.getCal().get(Calendar.YEAR));
        }
        System.out.println("getUniqueMonthYear Unique Values for Customer " + name + " is : " + hset);
		return hset;
	}	
	
	
	/* get Sum of Purchase per Month-Year per Customer */
	private int getSumMonthYear( List<Purchase> Purchases, String name, String Month_Year ) {
        int sum = 0;
  
        for(Purchase p : Purchases) {
        	String m_y = p.getCal().get(Calendar.MONTH) + "_" + p.getCal().get(Calendar.YEAR);
        	if( p.getName().equalsIgnoreCase( name ) && m_y.equalsIgnoreCase( Month_Year ) )
        		sum =+ p.getPoints();
        }
        System.out.println("getSumMonthYear for Customer " + name + Month_Year + " is : " + sum);
		return sum;
	}		
	
	

}  

