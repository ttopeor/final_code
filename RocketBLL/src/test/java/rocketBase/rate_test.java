package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {


	@Test
	public void test_getRate() throws RateException {
		
		double rate = RateBLL.getRate(600);

		assertTrue(rate == 7.0);
		
	}
	
	@Test
	public void test_RateException(){
		try{
			double rate = RateBLL.getRate(0);
			}
		catch(Exception e){
			
			boolean isRateException = e instanceof RateException;
			
			assertTrue(isRateException);
		}
	}
	
}

