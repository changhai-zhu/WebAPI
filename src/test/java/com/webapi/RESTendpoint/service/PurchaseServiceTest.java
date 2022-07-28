/**
 * 
 */
package com.webapi.RESTendpoint.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.webapi.RESTendpoint.model.Purchase;

/**
 * @author chanzhu
 *
 */
class PurchaseServiceTest {

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

	@Test
	void PurchaseServiceTest_findAll() {
		PurchaseService ps = new PurchaseService();
		List<Purchase> p = ps.findAll("input_junit.txt");
		System.out.println(p);
		assertThat(p).size().isEqualTo(2);
	}

	@Test
	void PurchaseServiceTest_printPurchases() {
		PurchaseService ps = new PurchaseService();
		String output = ps.printPurchases(ps.findAll("input_junit.txt"));
		System.out.println(output);
		assert (output) != null;
	}
	
}
