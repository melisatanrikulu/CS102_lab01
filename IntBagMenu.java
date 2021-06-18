/**
 * Demonstrates and tests the method IntBag.
 * @author Melisa Tanrýkulu
 * @version 2
 * 18.06.2021
 */

import java.util.Scanner;

public class IntBagMenu {
	public static void main(String[] args) {
		// Variables
		IntBag numbers = new IntBag();
		Scanner scan = new Scanner( System.in );
		int number;
		int choice;
		int index;
		boolean success;
		
		// Initialization
		number = -1;
		choice = 0;
		index = 0;
		success = false;
		
		do {			
			success = false;
			// Displays the menu
			System.out.println("1-Create a new empty collection");
			System.out.println("2-Read a set of positive values into the collection (0 to stop)");
			System.out.println("3-Print the collection of values");
			System.out.println("4-Add a value to the collection of values at a specified location");
			System.out.println("5-Remove the value at a specified location from the collection of values");
			System.out.println("6-Remove all instances of a value within the collection");
			System.out.println("7-Quit");
			System.out.print("Enter choice: ");
			
			// If input is an integer, assigns it to choice
			if ( scan.hasNextInt() ) {
				choice = scan.nextInt();
	            scan.nextLine();
	            
	         // If choice is in [1, 7]
	            if ( 1 <= choice && choice <= 7 ) {
	            	
	            	// Choice 1
	            	if ( choice == 1 ) {
	            		// Creates a new empty collection
	            		numbers = new IntBag();
	            		System.out.println("\nNew empty collection created");
	            	}
	            	
	            	// Choice 2
	            	else if ( choice == 2 ) {
	            		// Read a set of positive values into the collection until 0 entered
	            		do {
	            			System.out.print("Enter a number (0 to stop): ");
	            			// Checks if an integer is entered
	            			if ( scan.hasNextInt() ) {
	            				number = scan.nextInt();
	            				scan.nextLine();
	            				
	            				// If number is positive adds the value
	            				if ( number > 0 )
	            					numbers.addValue( number );
	            				
	            				else if ( number < 0 )
	            					System.out.println("\nPlease enter a positive number");
	            				
	            				// If 0 is entered, quits the option
	            				else
	            					success = true;
	            			}
	            			else {
	            				System.out.println("\nInvalid Choice, please enter a number");
	            				scan.nextLine();
	            			}
	            		}
	            		while( !success );
	            		System.out.println();
	            	}
	            	
	            	// Choice 3
	            	else if ( choice == 3 ) {
	            		// Prints the collection of values
	            		System.out.println("\n" + numbers);	
	            	}

	            	// Choice 4
	            	else if ( choice == 4 ) {
	            		// Adds a value to the collection of values at a specified location
	            		do {
	            			System.out.print("\nEnter the value: ");
	            			// Checks if an integer is entered
	            			if ( scan.hasNextInt() ) {
	            				number = scan.nextInt();
	            				System.out.print("Enter the index: ");
	            				// Checks if an integer is entered
	            				if ( scan.hasNextInt() ) {
	            					index = scan.nextInt();
	            					success = numbers.addValue(number, index);
	            					
	            					// Informs the user if value is added
	            					if ( success )
	            						System.out.println("\nValue added successfully");
	            							
	            					else {
	            						System.out.println("\nInvalid choice(s). Please make sure to enter a valid index and a valid value");
	            						System.out.println("Valid value interval: [0, (infinity))");
	            						if ( numbers.size() != 0 )
	            							System.out.println("Valid index interval: [0, " + numbers.size() + ")");
	            						else
	            							System.out.println("Valid index interval: [0,0]");
	            					}
	            				}
	            				else {
	            					System.out.println("\nInvalid choice. Please enter an integer");
	            					scan.nextLine();
	            					scan.nextLine();
	            				}
	            			}
	            			else {
	            				System.out.println("\nInvalid choice. Please enter an integer");
	            				scan.nextLine();
	            				scan.nextLine();
	            			}
	            			
	            		}
	            		while ( !success );
	            	}
	            	
	            	// Choice 5
	            	else if ( choice == 5 ) {
	            		// Removes the value at a specified location from the collection of values
	            		
	            		// If the size is not 0
	            		if ( numbers.size() != 0 ) {
	            			do {
	            				System.out.print("\nEnter the index to be removed: ");
	            				// Checks if an integer is entered
	            				if ( scan.hasNextInt() ) {
	            					index = scan.nextInt();
	            					scan.nextLine();
	            					
	            					// Removes the value
	            					success = numbers.removeValue(index);
	            					
	            					// If removal was successful, informs the user
	            					if ( success )
	            						System.out.println("\nRemoved successfully");
	            					else 
	            						System.out.println("\nInvalid choice. Please enter a valid index" );
	            				}
	            				else {
	            					System.out.println("\nInvalid choice. Please enter an integer");
	            					scan.nextLine();
	            				}
	            			}
	            			while( !success );
	            		}
	            		// If the size is 0, informs the user and does nothing
	            		else
	            			System.out.println("\nThe collection does not contain any value");
	            	}
	            	
	            	// Choice 6
	            	else if ( choice == 6 ) {
	            		// Removes all instances of a value within the collection
	            		do {
	            		System.out.print("\nEnter the number to be removed: ");
	            		// Checks if an integer is entered
	            			if ( scan.hasNextInt() ) {
	            				number = scan.nextInt();
	            				scan.nextLine();
	            				
	            				// Removes the values
	            				success = numbers.removeAll(number);
	            				
	            				// If removal was successful, informs the user
	            				if ( success )
	            					System.out.println("\nRemoved successfully");
	            				else {
	            					System.out.println("\nCollection does not include " + number);
	            					success = true;
	            				}
	            			}
	            			else {
	            				System.out.println("\nInvalid choice");
	            				scan.nextLine();
	            			}
	            		}
	            		while( !success );
	            	}
	            	
	            }
	            // If choice is not in [1, 7],  prints a corresponding message
	            else {
	            	System.out.println("\nInvalid Choice");
	            }
			}	
			// If choice is not an integer, prints a corresponding message
			else {
				System.out.println("\nInvalid Choice, Please enter an integer");
				scan.nextLine();
			}
		
		}
		// Displays the menu while the choice is not 7
		while( choice != 7 );
		scan.close();
		
		// Informs the user that the menu is terminated
		System.out.println("\nGoodbye!");
	}

}
