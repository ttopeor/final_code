package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	@Test
	public void testReturns() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		assertTrue(rates.size() == 10);
		
		assertEquals(rates.get(0).getiMinCreditScore(), 600);
		assertEquals(rates.get(2).getiMinCreditScore(), 650);
		assertEquals(rates.get(4).getiMinCreditScore(), 700);
		assertEquals(rates.get(6).getiMinCreditScore(), 750);
		assertEquals(rates.get(8).getiMinCreditScore(), 800);

		assertEquals(rates.get(0).getdInterestRate(), 7,  0.001);
		assertEquals(rates.get(2).getdInterestRate(), 6.5, 0.001);
		assertEquals(rates.get(4).getdInterestRate(), 6,  0.001);
		assertEquals(rates.get(6).getdInterestRate(), 5.75,  0.001);
		assertEquals(rates.get(8).getdInterestRate(), 5.5,  0.001);

		
	}	
	
}
