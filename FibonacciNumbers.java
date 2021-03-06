/**
 * Computes and displays the first 40 fibonacci numbers.
 * @author Melisa Tanr?kulu
 * @version 2
 * 18.06.2021
 */

public class FibonacciNumbers {
  public static void main( String[] args ) {
	  
	// Variables
    IntBag fibonacciNumbers = new IntBag();
    int number;
    
    // First two Fibonacci numbers
    fibonacciNumbers.addValue(0);
    fibonacciNumbers.addValue(1);
    
    // Adds the first 40 fibonacci numbers to IntBag
    for ( int i = 2; i < 40; i++ ) {
      // Each subsequent number is the sum of the previous two
      number = fibonacciNumbers.getValue(i - 1) + fibonacciNumbers.getValue(i - 2);
      
      // Adds the value to IntBag
      fibonacciNumbers.addValue( number );
    }
    
    // Displays the first 40 fibonacci numbers
    System.out.println("First 40 Fibonacci Numbers:");
    System.out.println(fibonacciNumbers);
  }
}