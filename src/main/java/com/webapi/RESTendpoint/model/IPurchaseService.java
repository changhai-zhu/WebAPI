package com.webapi.RESTendpoint.model;
import java.util.ArrayList;
import java.util.List;  

public interface IPurchaseService {
	List<Purchase> findAll( String inputfile ); 
	String printPurchases(List<Purchase> Purchases);
}