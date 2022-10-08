package project;
import java.text.DecimalFormat;

public class SalariedEmployee extends Employee {
	DecimalFormat df = new DecimalFormat("0.00");
	private double weeklySalary;
	
	// 4 argument constructor
	public SalariedEmployee(String firstName, String lastName, String sin, double weeklySalary) throws InvalidSINException {
		super(firstName, lastName, sin);
		setSalary(weeklySalary);
	}

	// Ovveriding earnings method
	@Override
	public double earnings() {
		return weeklySalary;
	}
	
	@Override
	public String toString() {
		return "Type: Salaried\nName: "+getLastName()+", "+getFirstName()
				+"\nSIN: "+getSin()+"\nWeekly Salary: $"+df.format(getSalary());
	}

	// Getters and Setters
	public double getSalary() {
		return weeklySalary;
	}

	public void setSalary(double salary) {
		
		if(salary < 0) {
			throw new IllegalArgumentException("Error: weekly salary cannot be a negative value");
		} else {
			this.weeklySalary = salary;
		}
		
		
	}
	
	

}
