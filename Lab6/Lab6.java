// CS 272 
// Program Name: Lab6.java
// Author: Jose Franco Baquera
// Date: November 8, 2017
// Purpose: The purpose of the program is to
// serve as both an applet and application.
// The program will have three recursive methods.
// The first recursive method will print the 
// binary equivalent of an integer, the second 
// recursive method will print all the objects in 
// a bag, and the last recursive method will 
// use an applet to print a "Fractal."

// Import statements.

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Lab6 extends JApplet {

   // Main method that will test the recursive methods.
   
   public static void main ( String args [ ] ) {
   
      // Declare several IntArrayBags and integers to test the method.
      
      int integerOne = -1, integerTwo = 0, integerThree = 4, integerFour = 27, integerFive = 108;
      
      IntArrayBag bagOne = new IntArrayBag ( );
      
      IntArrayBag bagTwo = new IntArrayBag ( );
      
      IntArrayBag bagEmpty = new IntArrayBag ( );
   
      // Testing the binaryPrint method.
   
      System.out.println( "\n----TESTING BINARYPRINT METHOD----" );
      
      System.out.println( "Here is the binary equivalent of integer -1." );
      
      System.out.println( "(Note: This violates the pre-condition of the binaryPrintMethod, so nothing should print)." );
      
      System.out.print( "n = -1 Output: " );
      
      binaryPrint( integerOne );
      
      System.out.println( "\nHere is the binary equivalent of integer 0." );
      
      System.out.print( "n = 0 Output: " );
      
      binaryPrint( integerTwo );
      
      System.out.println( "\nHere is the binary equivalent of integer 4." );
      
      System.out.print( "n = 4 Output: " );
      
      binaryPrint( integerThree );
      
      System.out.println( "\nHere is the binary equivalent of integer 27." );
      
      System.out.print( "n = 27 Output: " );
      
      binaryPrint( integerFour );
      
      System.out.println( "\nHere is the binary equivalent of integer 108." );
      
      System.out.print( "n = 108 Output: " );
      
      binaryPrint( integerFive );
      
      // Testing the printBag method.
      
      System.out.println( "\n\n----TESTING PRINTBAG METHOD----" );
      
      System.out.println( "Adding the integers -3, -2, -1, 0, 1, and 2 to bagOne." );
      
      bagOne.addMany( -3, -2, -1, 0, 1, 2 );
      
      System.out.println( "Here are all the integers in bagOne in random order: " );
      
      printBag( bagOne );
      
      System.out.println( "The total number of integers in bagOne should still be 6 since we added back the integers." );
      
      System.out.println( "bagOne has " + bagOne.size( ) + " items." );
      
      System.out.println( "\nAdding the integers -19, 1, 0, 666, and -666 to bagTwo." );
      
      bagTwo.addMany( -19, 1, 0, 666, -666 );
      
      System.out.println( "Here are all the integers in bagTwo in random order: " );
      
      printBag( bagTwo );
      
      System.out.println( "The total number of integers in bagTwo should still be 5 since we added back the integers." );
      
      System.out.println( "bagTwo has " + bagTwo.size( ) + " items.\n" );
      
      System.out.println( "Testing the printBag method with an empty bag. Since the bag is empty, nothing should print." );
            
      printBag( bagEmpty );
         
   } // end main.

   // Implementation of the binaryPrint method.
   
   public static void binaryPrint ( int number ) {
   
      // Error case/Precondition: n cannot be a negative integer.
      
      if ( number < 0 )
      
         // Use a return to stop the method.
      
         return;
         
      // Base cases: There will be TWO base cases.
      
      // First base case.
     
      if ( number == 0 ) {
      
         // Print the '0' and return to stop the 
         // recursive method. This case will take
         // care of all even, positive integers.
      
         System.out.print( "0" );
         
         return;
      
      } // end if.
      
      // Second base case.
      
      if ( number == 1 ) {
      
         // Print the '1' and return to stop the 
         // recursive method. This case will take
         // care of all odd, positive integers.

         System.out.print( "1" );
      
         return;
         
      } // end if.
      
      // Recursive Step: Call the method again
      // with integer division, then print the 
      // number with modulus 2 (i.e. either one or 
      // zero).
      
      binaryPrint( number / 2 );
      
      System.out.print( number % 2 );
      
   } // end binaryPrint. 
   
   // Implementation of the printBag method.
   
   public static void printBag ( IntArrayBag bag ) {
   
      // Error case: None. The base case will take 
      // care of the error case.
      
      // Base case: The base case will take care 
      // of the empty bag.
      
      if ( bag.size( ) == 0 )
      
         // If the bag is empty, the method has no
         // work to do. Therefore, use a return.
      
         return;
      
      // First, take a random integer out of the bag and store 
      // it in a variable called oneItem.
      
      int oneItem = bag.findRandomItem( );
      
      // Secondly, print oneItem.
      
      System.out.println( oneItem );
      
      // Recursive Step: Print any items remaining in the bag.
      
      printBag( bag );
      
      // The last step is to put oneItem back into the bag.
      
      bag.add( oneItem );
   
   } // end printBag method.
   
   // Instance variables for the applet portion of the assignment.

   private Image display;
   
   private Graphics drawingArea;
   
   // Implementation of the init method.

   public void init( ) { 
   
      // Get the height and width, then call the createImage method
      // to store the Image object into the display variable.
      
      int height = getSize( ).height;
      
      int width = getSize( ).width;
      
      display = createImage( width, height );
      
      // Call the getGraphics method with display variable 
      // being the calling object.
      
      drawingArea = display.getGraphics( );
      
      // Create a new color to send it to the randomFractal method.
      
      Color trivialColor = new Color ( 250, 119, 10 );
      
      // Call the randomFractal method.
      
      randomFractal( 0, height/2, width, height/2, drawingArea, trivialColor );
      
   } // end init method.
   
   // Implementation of the paint method.
      
   public void paint( Graphics g ){
      
      g.drawImage( display, 0, 0, null );
      
   } // end paint method.
   
   // Implementation of the randomFractal method.
      
   public static void randomFractal( int leftX, int leftY, int rightX, int rightY, Graphics drawingArea, Color c ){
      
      // When length < EPSILON, draw a line segment.
      
      final int STOP = 4; 
      
      // Midpoints in the x and y dimensions. 
            
      int midX, midY;
      
      // Amount to shift the line's midpoint up or down      
      
      int delta; 
      
      // Set the color.          
      
      drawingArea.setColor( c );
      
      // Use and if-else statement to serve as stopping/recusive bases.
      
      if ( ( rightX - leftX ) <= STOP )
      
         // This is the base case.
      
         drawingArea.drawLine( leftX, leftY, rightX, rightY );
         
      else {
      
         midX = ( leftX + rightX ) / 2;
         
         midY = ( leftY + rightY ) / 2;
         
         delta = (int)( ( Math.random( ) - 0.5) * ( rightX - leftX ) );
         
         midY += delta;
         
         // These are the recursive steps.
         
         randomFractal(leftX, leftY, midX,   midY,   drawingArea, c );
         
         randomFractal(midX,  midY,  rightX, rightY, drawingArea, c );
      
      } // end else. 
      
   } // end randomFractal method.

} // end class.