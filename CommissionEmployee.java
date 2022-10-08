package project;
import java.text.DecimalFormat;

public class CommissionEmployee extends Employee {
	
	private double commissionRate;
	private double grossSales;
	DecimalFormat df = new DecimalFormat("0.00");
	
	// 5 argument constructor
	public CommissionEmployee(String firstName, String lastName, String sin, double rate, double sales) throws InvalidSINException {
		super(firstName, lastName, sin);
		setCommissionRate(rate);
		setGrossSales(sales);
	}
	
	// Copy Constructor
	public CommissionEmployee(CommissionEmployee empToCopy) throws InvalidSINException {
		super(empToCopy.getFirstName(), empToCopy.getLastName(), empToCopy.getSin());
		setCommissionRate(empToCopy.getCommissionRate());
		setGrossSales(empToCopy.getGrossSales());
	}
	
	// Implementing earnings method
	@Override
	public double earnings() {
		return (commissionRate/100) * grossSales;
	}
	
	@Override
	public String toString() {
		return "Type: Commission\nName: "+getLastName()+", "+getFirstName()+
				"\nSIN: "+getSin()+"\nGross Sales: $"+getGrossSales()+
				"\nCommission Rate: "+df.format(getCommissionRate()/100);
	}
	
	// Getters and Setters
	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		
		if(commissionRate < 0 || commissionRate > 100) {
			throw new IllegalArgumentException("Error: commission rate should be between 0% and 100%");
		} else {
			this.commissionRate = commissionRate;
		}
		
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		
		if(grossSales < 0) {
			throw new IllegalArgumentException("Gross sales must be a value of 0 or greater");
		}
		
		this.grossSales = grossSales;
	}
	
	
	
}
