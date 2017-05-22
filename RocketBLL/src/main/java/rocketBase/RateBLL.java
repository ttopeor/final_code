package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
		for (RateDomainModel r : rates) {
			 if(GivenCreditScore > r.getiMinCreditScore()){
				 dInterestRate = r.getdInterestRate();
			 }
			else{
				 return dInterestRate;
			 	}
				if (dInterestRate == 0) {
					RateException noRate = new RateException();
					return 0;
					} 
			else {
					return dInterestRate;
					}
	      }
	
		return dInterestRate;
		
		
	}
	
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		//p: present value
		//f: future value
		//n: number of periods
		//y: payment (in each period)
		//r: rate
		//t: type
		// p(1+r)^n + y(1+rt)((1+r)^n-1)/r + f=0   ...{when r!=0}
		// ny + p + f=0                            ...{when r=0}
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
