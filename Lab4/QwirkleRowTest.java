// CS 272 
// Program Name: QwirkleRowTest.java
// Author: Jose Franco Baquera
// Date: October 18, 2017
// Purpose: The purpose of the program is 
// to serve as a test driver for the
// ArrayStack class. This program also
// has a static method that will check if
// a particular qwirkle row is valid or not. 

public class QwirkleRowTest {

   // Implementation of the validRow method.
   
   public static boolean validRow ( ArrayStack < Tile >  originalStack ) {
   
      // If the parameter is null, its size is zero, or its size is greater than six,
      // this method should return false since this is not a valid row.
      
      if ( ( originalStack == null ) || ( originalStack.size( ) == 0 ) || ( originalStack.size( ) > 6 ) )
      
         return false;
         
      // If the row has one tile, then it is a valid "row," so return true,
      
      if ( originalStack.size( ) == 1 )
      
         return true;
         
      // A valid row is when the tiles in a line (row) must be either all the same color (and different shapes) 
      // or all the same shape (and different colors).  
      
      // Make an array of Tiles that will store the Tile references in the stack. 
      
      Tile tileArray [ ] = new Tile [ originalStack.size( ) ];
      
      // Assume that all the tiles have the same color, shape, and there are no duplicates.
      
      boolean sameColor = true, sameShape = true, duplicateTiles = false;
      
      // Lets create a new ArrayStack since we can modify the original stack, 
      // but at the end of this method it should return to its original state.
      
      ArrayStack < Tile > copyStack = new ArrayStack < Tile > ( originalStack.size( ) );
      
      // Use a for loop that will store all the Tile references in the stack inside the array.
      
      for ( int i = originalStack.size( ); i >= 1; i-- ) {
      
         copyStack.push( originalStack.pop( ) );
      
         tileArray [ i - 1 ] = copyStack.peek( );
         
      } // end for.
      
      // Use a for loop that will check if all the colors and shapes are the same.
      
      for ( int i = 1; i < tileArray.length; i++ ) {
      
         if ( tileArray[ 0 ].getColor( ) != tileArray[ i ].getColor() )
        
            sameColor = false;   
        
         if ( tileArray[ 0 ].getShape( ) != tileArray[ i ].getShape( ) )
        	
            sameShape = false;
      
      } // end for.
      
      // Use two nested for loops that will check for duplicated tiles. We can either use
      // colors.length or shapes.length since they are equal.
      
      for ( int i = 0; i < tileArray.length; i++ ) {
      
         for ( int j = i + 1; j < tileArray.length; j++ ) {
         
            if ( tileArray[ i ].equals( tileArray[ j ] ) )
            
               duplicateTiles = true;       
         
         } // end inner for     
      
      } // end outer for.
      
      // Push back all the Tiles popped out from the originalStack since it should
      // be in its original state once this method ends.
      
      for ( int i = copyStack.size( ); i >= 1; i-- ){
      
         originalStack.push( copyStack.pop( ) );      
      
      } // end for.
      
      // Check if there are tiles in a line (row) that are either all the same color (and different shapes) 
      // or all the same shape (and different colors). In both scenarios, there cannot be duplicates in the row.    
      
      if ( sameColor && !sameShape && !duplicateTiles )
      
         return true;
         
      if ( !sameColor && sameShape && !duplicateTiles )
      
         return true;    
         
      // If none of the statements before executed, then the tile stack is not 
      // a valid row.  
      
      return false;      
      
   } // end validRow method.

   // Main method.
   
   public static void main ( String args [ ] ) {
   
      // Instantiate several object tiles to test the methods in the ArrayStack
      // class and the validRow static method in this class. 
   
      Tile tileTestOne = new Tile ( 1, 1 );
      
      Tile tileTestTwo = new Tile ( 1, 1 );
      
      Tile tileTestThree = new Tile ( 3, 1 );
      
      Tile tileTestFour = new Tile ( 6, 1 );
      
      Tile tileTestFive = new Tile ( 1, 6 );   
 
      Tile tileTestSix = new Tile ( 1, 2 );
      
      Tile tileTestSeven = new Tile ( 1, 2 );
          
      // Instantiate several ArrayStack objects in order to test the methods.
      // Call both the default and second constructors to test if they work.
     
      ArrayStack < Tile > testStackOne = new ArrayStack < Tile > ( );
      
      ArrayStack < Tile > testStackTwo = new ArrayStack < Tile > ( 6 );
      
      ArrayStack < Tile > emptyStack = new ArrayStack < Tile > ( 5 );
      
      // Testing the push, toString, and validRow methods.
      
      // Pushing three tiles into testStackOne. ALl these tiles have 
      // the same shape, but different colors. 
      
      System.out.println( "\n----Testing the push, validRow, and toString methods.----\n" );
               
      testStackOne.push( tileTestFour );
      
      testStackOne.push( tileTestThree );
      
      testStackOne.push( tileTestTwo );
      
      System.out.println( "This is testStackOne:" );
            
      System.out.print( testStackOne.toString( ) );
      
      // Pushing three tiles into testStackTwo. All these tiles have the 
      // same color, but different shapes.
      
      testStackTwo.push( tileTestSix );
      
      testStackTwo.push( tileTestFive );
      
      testStackTwo.push( tileTestOne );
      
      System.out.println( "\nThis is testStackTwo:" );
      
      System.out.print( testStackTwo.toString( ) );
      
      if ( validRow( testStackOne ) ) 
      
         System.out.println( "\nThe tiles in testStackOne form a valid row." );
           
      else 
      
         System.out.println( "\nThe tiles in testStackOne do not form a valid row." );
         
      if ( validRow( testStackTwo ) ) 
      
         System.out.println( "\nThe tiles in testStackTwo form a valid row." );
           
      else 
      
         System.out.println( "\nThe tiles in testStackTwo do not form a valid row." );
         
      // Testing that validRow did not modify the stack after calling it.
      
      System.out.println( "\nWe just called the validRow method. Both testStackOne and testStackTwo should remain unchanged." );
      
      System.out.println( "\nHere is testStackOne: " );
      
      System.out.print( testStackOne.toString( ) );
      
      System.out.println( "\nHere is testStackTwo: " );
      
      System.out.print( testStackTwo.toString( ) );
         
      // Testing the size, isEmpty, peek, trimToSize, getCapacity, ensureCapacity, and pop methods. 
      
      System.out.println( "\n----Testing the size, isEmpty, peek, trimToSize, getCapacity, ensureCapacity, and pop methods.----\n" );
      
      System.out.println( "testStackOne has " + testStackOne.size( ) + " items." );
      
      System.out.println( "True or false. testStackOne is empty: " + testStackOne.isEmpty( ) );
      
      System.out.println( "True or false. emptyStack is empty: " + emptyStack.isEmpty( ) );
      
      System.out.println( "emptyStack has " + emptyStack.size( ) + " items." );
      
      System.out.println( "Popping the top Tile from testStackOne. Here is the new stack.\n" );
      
      testStackOne.pop( );
      
      System.out.println( testStackOne.toString( ) );
      
      System.out.println( "The top tile in testStackOne is a " + testStackOne.peek( ) );
      
      System.out.println( "The current capacity of testStackOne is " + testStackOne.getCapacity( ) + "." );
      
      System.out.println( "Lets trim the size of testStackOne." );
      
      testStackOne.trimToSize( );
      
      System.out.println( "testStackOne's new capacity is " + testStackOne.getCapacity( ) + "." );
      
      System.out.println( "Lets make sure that testStackOne's capacity is at least 20." );
      
      testStackOne.ensureCapacity( 20 );
      
      System.out.println( "testStackOne's new capacity is " + testStackOne.getCapacity( ) + "." );
      
      // Testing the clone method.
      
      System.out.println( "\n----Testing the clone method.----\n" );
      
      ArrayStack < Tile > cloneTestStackTwo = testStackTwo.clone( );
      
      System.out.println( "Cloning testStackTwo." );
      
      System.out.println( "\nHere is testStackTwo:" );
      
      System.out.println( testStackTwo.toString( ) );
      
      System.out.println( "Here is cloneTestStackTwo:" );
      
      System.out.println( cloneTestStackTwo.toString( ) );
      
      // Changing emptyStack in order to check if the validRow method
      // works correctly for non-valid rows.
      
      System.out.println( "----Further testing of the validRow method.----\n" );
      
      System.out.println( "Here is emptyRow:" );
      
      System.out.println( emptyStack.toString( ) );
      
      if ( validRow( emptyStack ) ) 
      
         System.out.println( "The tiles in emptyStack form a valid row." );
           
      else 
      
         System.out.println( "The tiles in emptyStack do not form a valid row." );
         
      System.out.println( "\nHere is emptyRow but changed:" );
      
      emptyStack.push( tileTestOne );
      
      System.out.println( emptyStack.toString( ) );
      
      if ( validRow( emptyStack ) ) 
      
         System.out.println( "The tiles in emptyStack form a valid row." );
           
      else 
      
         System.out.println( "The tiles in emptyStack do not form a valid row." );
         
      System.out.println( "\nHere is emptyRow but changed again:" );
            
      emptyStack.push( tileTestSeven );
      
      emptyStack.push( tileTestFive );
      
      emptyStack.push( tileTestTwo );
      
      emptyStack.push( tileTestSix );
           
      System.out.println( emptyStack.toString( ) );
      
      if ( validRow( emptyStack ) ) 
      
         System.out.println( "The tiles in emptyStack form a valid row." );
           
      else 
      
         System.out.println( "The tiles in emptyStack do not form a valid row." );
         
      System.out.println( "\nHere is emptyRow but changed once again: " );
            
      emptyStack.push( tileTestThree );
      
      emptyStack.push( tileTestFour );
      
      System.out.println( emptyStack.toString( ) );
      
      if ( validRow( emptyStack ) ) 
      
         System.out.println( "The tiles in emptyStack form a valid row." );
           
      else 
      
         System.out.println( "The tiles in emptyStack do not form a valid row." ); 
   
   } // end main.
   
} // end class.