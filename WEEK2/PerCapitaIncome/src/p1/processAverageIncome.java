package p1;

import java.util.List;

public class processAverageIncome {
	
	public static double CURRENCY_INR=66;
	public static double CURRENCY_GBP=0.67;
	public static double CURRENCY_SGD=1.5;
	public static double CURRENCY_HKD=8;
	
	public static void newAverageIncome(List<Income> data) {
		
		for(Income inc:data)
		{
			double amt=inc.getAverageIncome();
			switch(inc.getCurrency()) {
			
			case "INR":
				inc.setAverageIncome(amt/CURRENCY_INR);
				break;

			case "GBP":
				inc.setAverageIncome(amt/CURRENCY_GBP);
				break;

			case "SGD":
				inc.setAverageIncome(amt/CURRENCY_SGD);
				break;

			case "HKD":
				inc.setAverageIncome(amt/CURRENCY_HKD);
				break;
				
			default:
				inc.setAverageIncome(amt);
				break;
			}
		}
		
	}

}
