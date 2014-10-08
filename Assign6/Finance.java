
public class Finance {
	

			public static double computeApy(double annualRate, int compoundingOption)
			{
				if(annualRate > 100 || annualRate < 0){
					return -1;
				}  
				annualRate = annualRate/100;
				if(compoundingOption > 3 || compoundingOption < 1){
					return -1;
				}
				if(compoundingOption == 1){
					compoundingOption = 365;
				}
				if(compoundingOption == 2){
					compoundingOption = 12;
				}
				if(compoundingOption == 3){
					compoundingOption = 1;
				}
				double APY = ((Math.pow((1 + (annualRate/compoundingOption)),compoundingOption)) - 1); //apr
				APY = APY * 100;
				APY = (Math.round(100*APY))/((double)100);
				return APY; 
			}
			
			public static double computeLoanPayment(
				double principal,
				double annualRate,
				double yearsDuration,
				int paymentOption)
			{  	// p * (r(1+r)^n) / ((1+r)^n)-1
				if(annualRate > 100 || annualRate < 0){
					return -1;
				}
				annualRate = annualRate/100;
				if(principal < 0 || yearsDuration < 1){
					return -1;
				}
				if(paymentOption > 3 || paymentOption < 1){
					return -1;
				}else if(paymentOption == 1){
					paymentOption = 26; //52 weeks (bi-weekly)
				}else if(paymentOption == 2){
					paymentOption = 12; //monthly
				}else if(paymentOption == 3){
					paymentOption = 4; //quarterly
				}
				annualRate = annualRate/paymentOption;
				double totalPayments = yearsDuration * paymentOption;
				double loanPayment = (principal * (annualRate*(Math.pow(1+annualRate, totalPayments)))/((Math.pow(1+annualRate, totalPayments)-1)));
				loanPayment = (Math.round(100*loanPayment))/((double)100);
				return loanPayment; 
			}
}

