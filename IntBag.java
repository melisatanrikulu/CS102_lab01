/**
 * Allows a variable-sized collection of non-negative integer values to be stored. The last value is followed by a negative value.
 * @author Melisa Tanrýkulu
 * @version 1
 * 15.06.2021
 */ 

import java.util.Arrays;

public class IntBag {
  // Instance Data Members
  int[] bag;
  int size;
   
  // Constructor
  
  /**
   * Creates an empty collection with room for up to 4 values.
   */
  public IntBag() {
    bag = new int[4];
    size = 0;
  }

  /**
   * Adds a value to the end of the collection.
   */  
  public void addValue( int value ) {
	  // Doubles the size of the array if needed
    if ( this.size + 1 == bag.length )
      bag = Arrays.copyOf( bag, bag.length * 2 );
    
    // Adds the number and increments the size if the number is nonnegative
    if ( value >= 0 ) {
      bag[size] = value;
      size++;
    }
    else
      bag[size] = value;
  }
  
  /**
   * Adds a value at a particular index location within it.
   */  
  public void addValue(int value, int index) {
	  
	// Checks if index is within bounds
	if ( 0 <= index && index < this.size) {
		// Doubles the size of the array if needed
		if ( this.size + 1 == bag.length )
			bag = Arrays.copyOf( bag, bag.length * 2 );
    
		// If the index is the last one, adds the value to the end of the collection 
		if ( index == this.size ) 
			this.addValue(value);

		else {
			// Moves other values up to make room
			for ( int i = size; i <= index; i--)
				this.bag[i + 1] = this.bag[i];
    
			this.bag[index] = value;
			size++;
		}
	}

  }
  
  /**
   * Removes the value at a given index by placing the last element of the array into that index.
   */
  public void removeValue( int index ) {
	  
  	//Checks if index is within bounds
    if ( 0 <= index && index < this.size ) {
      this.bag[index] = this.bag[this.size - 1];
      this.size--;
    }
  }
  
  /**
   * Tests whether the collection contains a given value or not.
   * @return true if contains
   */
  public boolean contains( int value ) {
    for ( int i = 0; i < this.size; i++ ) {
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
    
    repr = "[";
    
    for (int i = 0; i < this.size - 1; i++ )
      repr += this.bag[i] + ", ";
      
    repr += this.bag[ this.size - 1] + "]";
    
    return repr;
  }
  
  /**
   * Returns the number of values currently in the collection.
   * @return the size
   */
  public int size() {
    return this.size;
  }
  
  /**
   * Allows you to get the value at location 'index' within the collection.
   */
  public int getValue( int index ) {
    // Returns -1 if there is no value at location 'index'
    int value = -1;
    
    //Checks if index is within bounds
    if ( 0 <= index && index < this.size ) 
      value = this.bag[ index ];
    
    return value;
  }
}