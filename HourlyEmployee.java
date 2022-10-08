package project;
import java.text.DecimalFormat;

public class HourlyEmployee extends Employee {
	
	private double hours;
	private double hourlyRate;
	DecimalFormat df = new DecimalFormat("0.00");
	
	// 4 arguments constructor
	public HourlyEmployee(String firstName, String lastName, String sin, double hours, double rate) throws InvalidSINException {
		super(firstName, lastName, sin);
			setHours(hours);
			setHourlyRate(rate);
	}

	// Overriding earnings method
	@Override
	public double earnings() {
		double earning = 0;
		
		// if hours are more than 40 then each hour after 40 is paid 1.5 times
		if(hours > 40) {
			earning = hourlyRate * 40;
			earning += (hourlyRate*1.5) * (hours - 40);
		} else {
			earning = hourlyRate * hours;
		}
		
		return earning;
	}
	
	@Override
	public String toString() {
		return "Type: Hourly\nName: "+getLastName()+", "+getFirstName()
		+"\nSIN: "+getSin()+"\nHourly Rate: $"+df.format(getHourlyRate())+"\nHours Worked: "+getHours();
	}

	// Getters and Setters
	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		if(hours < 0) {
			throw new IllegalArgumentException("Error: hours worked cannot be a negative value");
		} else {
			this.hours = hours;
		}
		
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		if(hourlyRate < 14.10) {
			throw new IllegalArgumentException("Error: hourly rate of pay must be minimum wage or higher");
		} else {
			this.hourlyRate = hourlyRate;
		}
		
	}

}
