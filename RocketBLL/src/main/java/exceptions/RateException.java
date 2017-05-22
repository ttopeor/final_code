package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {


	private RateDomainModel RDM= null;

	public RateDomainModel getRatedomainmodel() {
		return RDM;
	}

	public RateException(){
		this.RDM = getRatedomainmodel();
}
}
