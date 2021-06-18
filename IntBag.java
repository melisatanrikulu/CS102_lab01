/**
 * Allows a variable-sized collection of non-negative integer values to be stored. The last value is followed by a negative value.
 * @author Melisa Tanrýkulu
 * @version 1
 * 15.06.2021
 */ 

import java.util.Arrays;

public class IntBag {
  // Instance Data Members
  private int[] bag;
  // Constructor
  
  /**
   * Creates an empty collection with room for up to 4 values.
   */
  public IntBag() {
    bag = new int[4];
  }

  /**
   * Adds a value to the end of the collection.
   */  
  public boolean addValue( int value ) {
	int size = this.size();
	
	if ( value >= 0) {
		// Doubles the size of the array if needed
		if ( size + 1 == bag.length )
			bag = Arrays.copyOf( bag, bag.length * 2 );
    
		// Adds the number and increments the size if the number is nonnegative
		bag[size] = value;
		bag[size + 1] = -1;
		return true;
	}
	else
		return false;
  }
  
  /**
   * Adds a value at a particular index location within it.
   */  
  public boolean addValue(int value, int index) {
	  int size = this.size();
	  
	  if ( value >= 0 ) { 
		  if ( 0 <= index && index <= size ) {
			  // Doubles the size of the array if needed
			  if ( size + 1 == bag.length )
				  bag = Arrays.copyOf( bag, bag.length * 2 );
		    
			  for ( int i = size ; i >= index; i--)
				  this.bag[i + 1] = this.bag[i];

			  this.bag[index] = value;
			  
		  
			  if ( size == 0 ) 
				  this.bag[1] = -1;
			  return true;
		  }
	  }
	  return false;
  }
  
  /**
   * Removes the value at a given index by placing the last element of the array into that index.
   */
  public boolean removeValue( int index ) {
	  int size = this.size();
	  
  	//Checks if index is within bounds
    if ( 0 <= index && index < size ) {
      this.bag[index] = this.bag[size - 1];
      this.bag[size - 1] = -1;
      this.bag[size] = 0;
      return true;
    }
    
    return false;
  }
  
  /**
   * Tests whether the collection contains a given value or not.
   * @return true if contains
   */
  public boolean contains( int value ) {
	  int size = this.size();
	  
    for ( int i = 0; i < size; i++ ) {
      if ( this.bag[i] == value )
        return true;
    }
    
    return false;
  }
  
  /**
   * Returns a String representation of the collection.
   * @return String representation
   */
  public String toString() {
    String repr;
    int size = this.size();
    
    repr = "[";
    
    if ( size > 0) {
    	for (int i = 0; i < size - 1; i++ )
    		repr += this.bag[i] + ", ";
      
    	repr += this.bag[ size - 1] + "]";
    }
    else
    	repr += "]";
    
    return repr;
  }
  
  /**
   * Returns the number of values currently in the collection.
   * @return the size
   */
  public int size() {
	  int size = 0;
	  
	  for ( int i = 0; i < this.bag.length; i++ ) {
		  if ( this.bag[i] < 0 )
			  return size;
		  size++;
	  }
	  
	  return 0;
  }
  
  /**
   * Allows you to get the value at location 'index' within the collection.
   */
  public int getValue( int index ) {
    // Returns -1 if there is no value at location 'index'
    int value = -1;
    int size = this.size();
    
    //Checks if index is within bounds
    if ( 0 <= index && index < size ) 
      value = this.bag[ index ];
    
    return value;
  }
  
  /**
   * Removes all instances of a given value in the collection.
   */
  public boolean removeAll( int value ) {
	  boolean contains;
	  int size = this.size();
	   
	  contains = false;
	   // Searches the array for the value
	   for ( int i = 0; i < size; i++ ) {
		   // If the value is found, moves other values down
		   if ( this.bag[i] == value ) {
			   contains = true;
			   for ( int j = i; j < size - 1; j++) {
				   this.bag[j] = this.bag[j + 1];   
			   }
		   }
	   }
	   
	   return contains;
  }
}