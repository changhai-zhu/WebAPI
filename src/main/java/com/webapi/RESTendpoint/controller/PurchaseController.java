package com.webapi.RESTendpoint.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.RESTendpoint.model.Purchase;
import com.webapi.RESTendpoint.service.PurchaseService;
	
@RestController
public class PurchaseController { 
 
	@Autowired  
	private PurchaseService purchaseService;  
		
	@GetMapping(value = "/Hello")
	public String hello() {
	    return "Hello - RESTful API";
	}
	
	//RESTful API endpoint for purchase points
	@GetMapping(value = "/purchase")
	public List<Purchase> getPurchase() {  
		//finds all the products  
		List<Purchase> purchases = purchaseService.findAll( "input.txt" ); 
		
		//returns the purchase list  
		return purchases;  	
	}

	//RESTful API endpoint for purchase points
	@GetMapping(value = "/points")
	public String getPoints() {  
		//finds all the products  
		List<Purchase> purchases = purchaseService.findAll( "input.txt" ); 
		
		//printout points for all the purchases
		String Summary = purchaseService.printPurchases(purchases);
		
		//returns the purchase list  
		return Summary;  	
	}
	
}