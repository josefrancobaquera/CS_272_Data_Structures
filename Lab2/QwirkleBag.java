// CS 272 
// Program Name: QwirkleBag.java
// Author: Jose Franco Baquera
// Date: September 14, 2017
// Purpose: The purpose of the program is
// to implement a Qwirkle Bag object. Each 
// Qwirkle Bag object will have two instance variables.
// NOTE: Each element in the array will have a Tile object.  

import java.util.Scanner;

public class QwirkleBag implements Cloneable { 

   // Declare two instance variables.
   
   private Tile data [ ];
   
   private int manyItems;
   
   // The Default Constructor.
   
   public QwirkleBag ( ) {
   
      // The Qwirkle Bag will start with 108 tiles,
      // three copies of each tile.
   
      final int INITIAL_CAPACITY = 108;
      
      manyItems = 108;
      
      data = new Tile [ INITIAL_CAPACITY ];
      
      Tile qwirkleTile; 
      
      // Use nested for loops to instantiate 108 Tile objects.
      
      int tempInitialCapacity = INITIAL_CAPACITY;
      
      for (  int numSet = 1; numSet <= 3; numSet = numSet + 1 ) {
      
         for ( int tileColor = 1; tileColor <= 6; tileColor = tileColor + 1 ) {
         
            for ( int tileShape = 1; tileShape <= 6; tileShape = tileShape + 1 ) {
            
               qwirkleTile = new Tile ( tileColor, tileShape );
            
               data [ 108 - tempInitialCapacity ] = qwirkleTile;
               
               tempInitialCapacity = tempInitialCapacity - 1;
            
            } // end for loop         
         
         } // end for loop     
      
      } // end for loop
      
   } // end default constructor method.
     
   // The toString Method.
   
   public String toString ( ) {
   
      String answer = "";
   
      // Use a for loop that will go trough each element
      // in the data array until manyItems.
   
      for ( int i = 0; i < manyItems; i = i + 1 ) {
      
         answer = answer + data [ i ] + "\n";      
      
      } // end for loop
      
      return answer;
     
   } // end toString method.
   
   // The add Method.
   
   public void add ( Tile element ) {
   
      // First ensure that there is enough space 
      // to add a Tile
   
      if ( manyItems == data.length ) 
      
         ensureCapacity ( ( manyItems + 1 ) * 2 );
         
      // Clone the parameter and store the reference in the array.
            
      data [ manyItems ] = element.clone( );
      
      manyItems++;  
   
   } // end add method.
   
   // The clone Method.
   
   public QwirkleBag clone ( ) {
   
      // Clone an Qwirkle object.
      
      QwirkleBag answer;
      
      try { 
      
         answer = ( QwirkleBag ) super.clone ( );
         
      } // end try 
      
      catch ( CloneNotSupportedException e ) {
      
         throw new RuntimeException ( "This class does not implement Cloneable." );      
      
      } // end catch.
      
      answer.data = data.clone ( );
      
      for ( int i = 0; i < manyItems; i++ ) {
      
         answer.data[ i ] = data[ i ].clone( );
   
      } // end for
      
      // Jose Franco Baquera 
      // September 20, 2017.
      // Deep cloning is necessary because the data array is a reference 
      // that references Tile objects. This is why we need answer.data = data.clone ( )
      // because data is a reference variable and we need to clone it. 
      // In addition, we need a for loop that will clone all the tile objects since they 
      // are also reference variables. When the line of code in line 117 executes, then the 
      // data array ( length, etc. )is cloned, but the Tile objects are not cloned since they 
      // still reference Tile objects. Therefore, we need to use a for loop that will clone 
      // the Tile objects themselves and store them in the new cloned array. The manyItems
      // does not need this deep cloning since it is just an integer and not an object like 
      // the data array and the Tiles. 
      
      // Basically, ANYTHING that invloves objects of some sort needs deep cloning. 
 
      return answer;
         
   } // end clone method.
   
   // The countOccurences Method.
   
   public int countOccurrences ( Tile target ) {
   
      // Declare an integer count variable and 
      // inizialize it to 0. Use for loop and equals
      // method to compare to objects. If equal, increment
      // count, return count after for loop. 
   
      int count = 0;
      
      for ( int index = 0; index < manyItems; index++ ) {
      
         if ( target.equals( data[ index ] ) )
         
            count++;     
      
      } // end for loop.
      
      return count;
   
   } // end countOccurences method.

   // The ensureCapacity method.
      
   public void ensureCapacity ( int minimumCapacity ) {
   
      // Create a new bigger array with Object 
      // references. If data lenegth is smaller than the 
      // mininum capacity, nothing will be changed.
      // Else, copy the references to the bigger array.
   
      Tile [ ] biggerArray;
      
      if ( data.length < minimumCapacity ) {
      
         biggerArray = new Tile [ minimumCapacity ];
         
         for ( int i = 0; i < manyItems; i = i + 1 ) {
         
            biggerArray [ i ] = data [ i ];         
         
         } // end for loop
                  
         data = biggerArray;     
      
      } // end if statement  
   
   } // end ensureCapacity
   
   // The getCapacity method.
   
   public int getCapacity ( ) {
   
      return data.length;   
   
   } // end getCapacity method.
     
   // The Remove the method.
   
   public boolean remove ( Tile target ) {
   
      // Use a for loop that will search for
      // a Tile object and remove it from the 
      // array of objects. 
      
      int index;
      
      for ( index = 0; ( index < manyItems ) && ( !( target.equals( data[ index ] ) ) ); index++ ); 
      
      // If index equals manyItems, target was not found. Return false.
      
      if ( index == manyItems ) 
      
         return false;
         
      // If a target was found, remove it by copying the last array element
      // into it.
         
      else {
      
         manyItems--;
         
         data [ index ] = data [ manyItems ];
         
         return true;
         
      } // end else.  
   
   } // end remove method.
   
   // The size method.
   // This is an accessor and should
   // be named getManyItems, but we will keep
   // it named as size since that's how the book has it. 
   
   public int size ( ) {
   
      return manyItems;
      
   } // end get
     
   // The trimToSize method.
   
   public void trimToSize ( ) {
   
      // Make a new array that will store the trimmed array.
      
      Tile trimmedArray [ ];
      
      // If the length of the data array is equal to manyItems, 
      // no trimming necessary. If it is larger, create a new array
      // that will store only copy the references of the Qwirkle tiles
      // and the data array.
      
      if ( data.length != manyItems ) { 
      
         trimmedArray = new Tile [ manyItems ];
         
         for ( int i = 0; i < manyItems; i = i + 1 ) {
         
            trimmedArray [ i ] = data [ i ];         
         
         } // end for loop
         
         data = trimmedArray;
             
      } // end if
   
   } // end trimToSize method.
   
   public Tile draw ( ) {
   
      Tile answer;
      
      // If the bad is not empty, randomly choose a Tile from
      // the bag, remove it, modify the data array, then return the reference.
      
      // NOTE: We can use the remove method, so manyItems will be modified once 
      // we call the method.

      if ( manyItems != 0 ) {
      
         answer = data [  ( int ) ( Math.random ( ) * ( ( manyItems - 1) - 0 + 1 ) + 0 ) ];
         
         remove ( answer ); 
         
         // Trim the data array.
         
         trimToSize ( );
                  
         return answer;  
              
      } // end for.
         
      // If the bag is empty, return null.
         
      return null;
      
   } // end draw method.
       
} // end class.