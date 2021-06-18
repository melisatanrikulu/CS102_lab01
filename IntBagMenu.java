
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
			// Display the menu
			System.out.println("1-Create a new empty collection");
			System.out.println("2-Read a set of positive values into the collection (0 to stop)");
			System.out.println("3-Print the collection of values");
			System.out.println("4-Add a value to the collection of values at a specified location");
			System.out.println("5-Remove the value at a specified location from the collection of values");
			System.out.println("6-Remove all instances of a value within the collection");
			System.out.println("7-Quit");
			System.out.print("Enter choice: ");
			
			// If input is an integer, assign it to choice
			if ( scan.hasNextInt() ) {
				choice = scan.nextInt();
	            scan.nextLine();
	            
	         // If choice is 1, 2, 3 or 4
	            if ( 1 <= choice && choice <= 7 ) {
	            	if ( choice == 1 ) {
	            		numbers = new IntBag();
	            		System.out.println("\nNew empty collection created");
	            	}
	            	else if ( choice == 2 ) {
	            		do {
	            			System.out.print("Enter a number (0 to stop): ");
	            			if ( scan.hasNextInt() ) {
	            				number = scan.nextInt();
	            				scan.nextLine();
	            				
	            				if ( number > 0 )
	            					numbers.addValue( number );
	            				
	            				else if ( number < 0 )
	            					System.out.println("\nPlease enter a positive number");
	            				
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
	            	else if ( choice == 3 ) {
	            		System.out.println("\n" + numbers);	
	            	}

	            	// 4-Add a value to the collection of values at a specified location
	            	else if ( choice == 4 ) {
	            		do {
	            			System.out.print("\nEnter the value: ");
	            			if ( scan.hasNextInt() ) {
	            				number = scan.nextInt();
	            				System.out.print("Enter the index: ");
	            				if ( scan.hasNextInt() ) {
	            					index = scan.nextInt();
	            					success = numbers.addValue(number, index);
	            					
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
	            	
	            	// 5-Remove the value at a specified location from the collection of values
	            	else if ( choice == 5 ) {
	            		if ( numbers.size() != 0 ) {
	            			do {
	            				System.out.print("\nEnter the index to be removed: ");
	            				if ( scan.hasNextInt() ) {
	            					index = scan.nextInt();
	            					scan.nextLine();
	            					success = numbers.removeValue(index);
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
	            		else
	            			System.out.println("\nThe collection does not contain any value");
	            	}
	            	
	            	// 6
	            	else if ( choice == 6 ) {
	            		do {
	            		System.out.print("\nEnter the number to be removed: ");
	            		
	            			if ( scan.hasNextInt() ) {
	            				number = scan.nextInt();
	            				scan.nextLine();
	            				success = numbers.removeAll(number);
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
	            // If choice is not in [1, 7],  print a corresponding message
	            else {
	            	System.out.println("\nInvalid Choice");
	            }
			}	
			// If choice is not an integer,  print a corresponding message
			else {
				System.out.println("\nInvalid Choice, Please enter an integer");
				scan.nextLine();
			}
		
		}
		// Do it while the choice is not 7
		while( choice != 7 );
		scan.close();
		
	}

}
