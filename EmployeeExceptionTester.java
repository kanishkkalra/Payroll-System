package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeExceptionTester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int userChoice;
		String firstName;
		String lastName;
		String sin;
		double salary;
		double hours;
		double rate;
		double sales;
		Employee salariedEmployee = null;
		Employee hourlyEmployee = null;
		Employee commissionEmployee = null;
		
		System.out.println("Welcome to Employee Exception Tester!\n\n");
		
		// Loop to take the first input for which employee user wants to add
		while(true) {
			System.out.println("Which of the following types of employees would you like to create:");
			System.out.println("\t1. Salaried\n\t2. Hourly\n\t3. Commission\n");
			System.out.print("Please Enter your selection: ");
			try {
				// Taking user input
				userChoice = Integer.parseInt(sc.nextLine());
				// If user choice is a number not in menu then error is thrown else loop is ended
				if(userChoice < 1 || userChoice > 3) {
					throw new InputMismatchException("Error: Please enter a valid number from the menu");
				} else {
					break;
				}
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
		
		// Loop to take inputs of employee details
		while(true) {
			
			try {
				// Taking name and sin as user input
				System.out.print("\nPlease enter employee's first name: ");
				firstName = sc.nextLine();
				
				System.out.print("Please enter employee's last name: ");
				lastName = sc.nextLine();
				
				System.out.print("Please enter employee's SIN: ");
				sin = sc.nextLine();
				
				// Asking for other details based on the type of employee selected by user
				// if user entered 1 then only salary is asked
				// If user entered 2 then hours and rates are asked
				// If user enters 3 then sales and rates is asked
				// The the employee object of the appropriate employee type id created
				// If any of these is invalid detail then error is thrown
				if(userChoice == 1) {
					System.out.print("Please enter employee's weekly salary: $");
					salary = Double.parseDouble(sc.nextLine());
					salariedEmployee = new SalariedEmployee(firstName,lastName,sin,salary);
				}
				if(userChoice == 2) {
					System.out.print("Please enter employee's hours: ");
					hours = Double.parseDouble(sc.nextLine());
					
					System.out.print("Please enter employee's rate: $");
					rate = Double.parseDouble(sc.nextLine());
					
					hourlyEmployee = new HourlyEmployee(firstName, lastName, sin, hours, rate);
				}
				
				if(userChoice == 3) {
					
					System.out.print("Please enter employee's rate: $");
					rate = Double.parseDouble(sc.nextLine());
					
					System.out.print("Please enter employee's sales: $");
					sales = Double.parseDouble(sc.nextLine());
					
					commissionEmployee = new CommissionEmployee(firstName, lastName, sin, rate, sales);
				}
				System.out.println("***************************************************\n\n");
				
			} catch(InvalidSINException e) {
				System.out.println("***************************************************\n\n");
				System.out.println(e.getMessage());
				System.out.println("You have entered incorrect information. We will now re-prompt you for all inputs.");
				continue;
			} catch(IllegalArgumentException e) {
				System.out.println("***************************************************\n\n");
				System.out.println(e.getMessage());
				System.out.println("You have entered incorrect information. We will now re-prompt you for all inputs.");
				continue;
			} catch(InputMismatchException e) {
				System.out.println("***************************************************\n\n");
				System.out.println("Error: Inputs don't match. Please make a valid entry");
				System.out.println("You have entered incorrect information. We will now re-prompt you for all inputs.");
				continue;
			} 
			
			// Breaking the loop after employee has been created and all teh values are valid 
			System.out.println("Employee successfully created!\n");
			break;
			
		}
		
		// Calling appropriate tostring method based on the employee that has created
		if(userChoice == 1) {
			System.out.println(salariedEmployee);
		}
		if(userChoice == 2) {
			System.out.println(hourlyEmployee);
		}
		if(userChoice == 3) {
			System.out.println(commissionEmployee);
		}
	}
}
