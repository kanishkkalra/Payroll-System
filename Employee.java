package project;

import java.util.regex.Pattern;

public abstract class Employee {
	
	protected String firstName;
	protected String lastName;
	protected String sin;
	protected Employee managedBy;
	protected static int numEmployee;
	
	// 3 argument constructor, sets managedBy to the employee itself by default
	// Can be changed by setManager function
	public Employee(String firstName, String lastName, String sin) throws InvalidSINException {
			setFirstName(firstName);
			setLastName(lastName);
			setSin(sin);
			setManager(this);
		
		// Num employee increases by 1 on each employee created
		numEmployee++;
	}
	
	// Equals method
	@Override
	public boolean equals(Object obj) {
		// Checks if object is not null and is an instanceof employee
		if(obj != null && obj instanceof Employee) {
			
			Employee emp1 = this;
			Employee emp2 = (Employee) obj;
			// Returns true if both employees are same
			return emp1.firstName.equals(emp2.firstName) && emp1.lastName.equals(emp2.lastName) && emp1.sin.equals(emp2.sin);
		}
		return false;
	}
	
	// returns number of employees
	public static int count() {
		return numEmployee;
	}
	
	// Abstract method earnings to be implemented by child classes
	public abstract double earnings();
	
	@Override
	public String toString() {
		return "Name: "+getLastName()+", "+getFirstName()+"\nSIN: "+getSin();
	}
	
	// Getters and Setters
	public Employee getManager() {
		return managedBy;
	}
	
	public void setManager(Employee mgr) {
		this.managedBy = mgr;
	}

	public String getFirstName() {
		return firstName;
	}

	// First nam eis set only if firstname is not null and not empty
	public void setFirstName(String firstName) {
		
		if(firstName == null || firstName == "") {
			throw new IllegalArgumentException("Error: Invalid first name provided");
		} else {
			this.firstName = firstName;
		}
		
	}

	public String getLastName() {
		return lastName;
	}
	
	// Last name is set only if lastname is not null and not empty
	public void setLastName(String lastName) {
		
		if(firstName == null || firstName == "") {
			throw new IllegalArgumentException("Error: Invalid last name provided");
		} else {
			this.lastName = lastName;
		}
		
		
	}

	public String getSin() {
		return sin;
	}

	public void setSin(String sin) throws InvalidSINException {
		// If sin is not null and all the letters are anumber
		if(sin == null || !(Pattern.matches("[0-9]+", sin)) || sin.length()<9) {
			throw new InvalidSINException(); // If nmot then exception is thrown
		} else {
			// Extracting the last digit only
			int lastDigit = Integer.parseInt(sin.substring(8, 9));
			
			String evenDigits = "";
			String evenDigitsDoubled = "";
			String oddDigit = "";
			int evenDigitsTotal = 0;
			int oddDigitsTotal = 0;
			
			// Going through all digits of the sin except teh last digit
			for(int i=0; i<sin.length()-1;i++) {
				// Taking even numbers and appending them to a string
				if(i%2!=0) {
					evenDigits += sin.charAt(i);
				} else {
					// taking odd number and appending to string
					oddDigit = Character.toString(sin.charAt(i));
					// Converting them to int and adding
					oddDigitsTotal += Integer.parseInt(oddDigit);
				}
			}
			
			// Going through each letter, converting them to integer and multiplying them by 2 and adding 
			// to a global variable
			for(int i=0; i<evenDigits.length();i++) {
				evenDigitsDoubled += 2*Integer.parseInt(Character.toString(evenDigits.charAt(i)));
				
			}
			
			for(int i=0; i<evenDigitsDoubled.length();i++) {
				evenDigitsTotal += Integer.parseInt(Character.toString(evenDigitsDoubled.charAt(i)));
			}
			
			int total = evenDigitsTotal + oddDigitsTotal;
			int roundedTotal = total+10-(total%10);
			total = roundedTotal - total;
			
			// if the calculated number and the last digit dont match then throw error else assign the sin
			if(total != lastDigit) {
				throw new InvalidSINException();
			} else {
				this.sin = sin;
			}
		}
		
		
	}
	
	
	
}
