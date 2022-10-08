package project;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PayrollTester {

	public static void main(String[] args) throws InvalidSINException {
		
		// Declaring variables to be used ahead
		DecimalFormat df = new DecimalFormat("0.00");
		double highestEarnings = 0;
		String highestPaid = "";
		double lowestEarnings = Double.MAX_VALUE;
		String lowestPaid = "";
		int salariedEmpCount=0;
		int hourlyEmpCount=0;
		int commissionEmpCount=0;
		double totalPayPeriod=0;
		
		// List of Employees
		ArrayList<Employee> empList = new ArrayList<Employee>();
		// Adding employees to list
		empList.add(new SalariedEmployee("Joe","Francis","046454286",2500));
		empList.add(new SalariedEmployee("Samantha","Hughes","046454286",1400));
		
		// Setting the manager of employee at 1st index to employee at 0th index
		empList.get(1).setManager(empList.get(0));
		
		empList.add(new HourlyEmployee("Kim", "Adams", "046454286", 42, 18.50));
		empList.get(2).setManager(empList.get(0));
		
		empList.add(new CommissionEmployee("Ryan", "Goodall", "046454286", 15, 9000));
		// Setting the manager of employee at 3rd index to employee at 1st index
		empList.get(3).setManager(empList.get(1));
		
		// Looping thorugh the employee list
		for(Employee e:empList) {
			// Printing each employee using tostring
			System.out.println(e);
			// printing earnings
			System.out.println("TOTAL: $"+df.format(e.earnings()));
			
			// Finding highest earning employee
			if(e.earnings() > highestEarnings) {
				highestEarnings = e.earnings();
				highestPaid = e.getLastName() + ", "+e.getFirstName();
			}
			
			// Finding lowest earning employee
			if(e.earnings() < lowestEarnings) {
				lowestEarnings = e.earnings();
				lowestPaid = e.getLastName() + ", "+e.getFirstName();
			}
			
			// Counting each employee type
			if(e instanceof SalariedEmployee) {
				salariedEmpCount++;
			}
			if(e instanceof HourlyEmployee) {
				hourlyEmpCount++;
			}
			if(e instanceof CommissionEmployee) {
				commissionEmpCount++;
			}
			
			// Calculating sum pay of all employees earnings
			totalPayPeriod += e.earnings();
			System.out.println("---------------------");
		}
		
		System.out.println("SUMMARY STATISTICS");
		System.out.println("Highest Paid Employee: "+highestPaid);
		System.out.println("Lowest Paid Employee: "+lowestPaid);
		System.out.println("Number of salaried employees: "+salariedEmpCount);
		System.out.println("Number of hourly employees: "+hourlyEmpCount);
		System.out.println("Number of Commission employees: "+commissionEmpCount);
		System.out.println("Total for Pay Period: $"+df.format(totalPayPeriod));
		
	}

}
