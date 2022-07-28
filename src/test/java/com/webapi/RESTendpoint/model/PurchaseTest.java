/**
 * 
 */
package com.webapi.RESTendpoint.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author chanzhu
 *
 */
class PurchaseTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/*
	A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.	 
	A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
	(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
	 
	Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.	 
	 */
	@Test
	void calculatePointsTest() throws ParseException {
		Purchase p = new Purchase("07-20-2022", "John",120.00); 
		assertEquals(p.getPoints(),90);
		
		Purchase p1 = new Purchase("07-20-2022", "John",40.00); 
		assertEquals(p1.getPoints(),0);
		
		Purchase p2 = new Purchase("07-20-2022", "John",50.00); 
		assertEquals(p2.getPoints(),0);
		
		Purchase p3 = new Purchase("07-20-2022", "John",77.00); 
		assertEquals(p3.getPoints(),27);
		
		Purchase p4 = new Purchase("07-20-2022", "John",105.00); 
		assertEquals(p4.getPoints(),60);
	}

}
