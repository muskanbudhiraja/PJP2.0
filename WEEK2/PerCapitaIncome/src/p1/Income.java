package p1;


public class Income {
	
	private String City;
	private String Country;
	private String Gender;
	private String Currency;
	private double AverageIncome;
	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	
	public double getAverageIncome() {
		return AverageIncome;
	}
	public void setAverageIncome(double averageIncome) {
		AverageIncome = averageIncome;
	}
	public Income(String[] s) {
		
			this.City = s[0];
			if(s[1]!=null)
				this.Country = s[1];
			this.Gender = s[2];
			this.Currency = s[3];
			this.AverageIncome=Double.valueOf(s[4]);
		
	}
	@Override
	public String toString() {
		return "Income [City=" + City + ", Country=" + Country + ", Gender=" + Gender + ", Currency=" + Currency
				+ ", AverageIncome=" + AverageIncome + "]";
	}

	
	
	

}
