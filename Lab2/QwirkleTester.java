// CS 272 
// Program Name: QwirkleTester.java
// Author: Jose Franco Baquera
// Date: September 14, 2017
// Purpose: The purpose of this program is
// to test all the methods of both the Tile class
// and QwirkleBag class.

import java.util.Scanner;

public class QwirkleTester { 

   public static void main ( String args [ ] ) {
   
      // Create a new QwirkleBag object. Print it.
   
      QwirkleBag game1 = new QwirkleBag ( );
      
      System.out.println ( "**********I created a new QwirkleBag. Here's what's in it.********** \n" );
      
      System.out.println( game1 );
      
      // First, lets check that the Tile class works correctly.
      
      System.out.println( "**********Testing the Tile Class.**********" );
      
      Tile tileTest1 = new Tile ( 1, 1 );
      
      Tile tileTest2 = new Tile ( 6, 3 );
      
      Tile tileTest3 = new Tile ( 1, 1 );
      
      System.out.println( "# The color (integer form) of testTile1 is: " +
      
         tileTest1.getColor( ) + "." );
         
      System.out.println( "# The shape (integer form) of the testTile2 is: " +
      
         tileTest2.getShape( ) + "." );
         
      System.out.println( "# tileTest1 and tileTest2 are equal: " + tileTest1.equals( tileTest2 ) );
      
      System.out.println( "# tileTest1 and tileTest3 are equal: " + tileTest3.equals( tileTest1 ) );
      
      tileTest1.setColor( 5 );
      
      tileTest1.setShape( 4 );
      
      System.out.println( "# testTile1's shape and color are updated. They are (in updated form): " +
      
         tileTest1.getColor( ) + " and " + tileTest1.getShape( ) + "." );
      
      System.out.println( "# tileTest2 is a " + tileTest2 );
      
      Tile cloneTileOne = tileTest1.clone ( );
      
      tileTest1.setColor( 2 );
      
      System.out.println( "# cloneTileOne is a completetly different tile (not a reference to" + 
      
         " tileTest1) so changing \nthe color of tileTest1 does not change the clone: " + 
         
         !tileTest1.equals( cloneTileOne ) );      
      
      // Now let's check all methods in the QwirkleBag class.
      
      System.out.println( "\n**********Testing the QwirkleBag Class.**********" );
      
      // Test the clone, add, countOccurrences, and remove methods.
                  
      System.out.println( "# Lets create a clone of game1 called QwirkleBag." );
      
      QwirkleBag game1Clone = game1.clone( );
      
      System.out.println( "# Now lets remove a orange circle from bag1." );
      
      Tile orangeCircle = new Tile ( 1, 6 );
      
      game1.remove( orangeCircle );
      
      System.out.println( "# game1 should have 107 total tiles." );
      
      System.out.println( "----game1 has " + game1.size ( ) + " tiles.----" );
      
      System.out.println( "# If clone method worked, game1 should have two orange circle tiles \n" + 
      
         "while game1Clone should still have three orange circle tiles." );
         
      System.out.println( "----game1 has " + game1.countOccurrences( orangeCircle ) + " orange circle tiles " + 
      
         "while game1Clone has " + game1Clone.countOccurrences( orangeCircle ) + " orange circle tiles." );
         
      // Test that we can remove all of a certain Tile from the bag as well as the size method.
      
      System.out.println( "# Testing if we can remove all orange circle tiles from game1Clone." );
      
      while ( game1Clone.remove( orangeCircle ) ) {
      
         // Remove method returns a boolean, but also removes the targeted Tile.
         // No more code is needed.
      
      } // end while
               
      System.out.println( "# If all orange circle tiles were removed, there should be 105 total " +
      
         "tiles left in the bag \nand the total occurances of orange circle tiles should be 0." ); 
         
      System.out.println( "----There are " + game1Clone.size( ) + " tiles in the bag and the " +
      
         "total occurances of orange circles is " + game1Clone.countOccurrences( orangeCircle ) + "." );
         
      // Test the getCpacity, draw, ensureCapacity, and trimToSize methods. 
      
      System.out.println( "# Even though we removed 3 tiles from the game1Clone bag, the getCapacity of the bag " +
      
         "should still be 108." );
         
      System.out.println( "----The capacity of game1Clone is " + game1Clone.getCapacity( ) + "." );
      
      System.out.println( "# Make the game1Clone have a 200 capacity." );
      
      game1Clone.ensureCapacity( 200 );
      
      System.out.println( "----game1Clone's new capacity is " + game1Clone.getCapacity( ) + "." );
      
      System.out.println( "# Draw a random tile from the bag. There should be 104 items left in the bag." );
      
      System.out.println( "----Here is a random tile: " + game1Clone.draw( ) + "." );
      
      System.out.println( "----There are " + game1Clone.size( ) + " tiles left in the game1Clone bag." );
      
      System.out.println( "# Trim the game1Clone to its current size." );
      
      game1Clone.trimToSize( );
      
      System.out.println( "----game1Clone's new capacity is " + game1Clone.getCapacity( ) + "." );
      
      // Test that the clone method worked again. 
      
      System.out.println( "# Since we deep cloned, game1 should still have 107 total tiles and 2 orange " + 
      
         "circles while the \ngame1Clone bag should have 104 total tiles and 0 orange circles." ); 
         
      System.out.println( "----game1 has " + game1.size( ) + " tiles left and " + 
      
         game1.countOccurrences( orangeCircle ) + " orange circles." );
         
      System.out.println( "----game1Clone has " + game1Clone.size( ) + " tiles left and " + 
      
         game1Clone.countOccurrences( orangeCircle ) + " orange circles." );
         
      // Testing unwanted Tile shape and color values.
      
      System.out.println( "# Make a new tile with color 0 and shape 6. Try to print it out with a try and catch." ); 
         
      try {
      
         Tile invalid = new Tile ( 0, 6 );
         
         System.out.println( invalid );
         
      } // end try.
      
      catch ( IllegalArgumentException e ) { 
      
         System.out.println( "----Invalid number and/or color.----" );
        
      } // end catch.
      
      // Lastly, print all the remaining cards with draw.
      
      System.out.println( "\n# Printing all tiles left in game1Clone randomly" );
      
      while ( game1Clone.size( ) != 0 )
      
         System.out.println( "Random Card: " + game1Clone.draw( ) );
                   
   } // end main

} // end clas