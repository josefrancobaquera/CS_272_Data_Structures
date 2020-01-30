// CS 272 
// Program Name: Lab7.java
// Author: Jose Franco Baquera
// Date: November 20, 2017
// Purpose: The purpose of the program is to
// read integers from a file and store them in an array,
// sort the array, then add it to a binary search tree. 

// Import statements.

import java.io.*;
import java.util.*;

public class Lab7 {

   // Main method.

   public static void main ( String args [ ] ) {
   
      // Create Scanner and File objects, as well as a String, to allow the user to 
      // input the filename.
      
      File inputFile;
            
      Scanner scan = new Scanner ( System.in );
      
      String fileName;
   
      // Create an empty balanced, binary search tree of integers.
      
      BTNode <Integer> testTree = null;
      
      // Declare and inizialize an array of 100 integers.
      
      int integerArray [ ] = new int [ 100 ];
      
      // Dclare an integer that will keep track of the number of elements
      // of the array that were filled.
      
      int numberOfElements;
      
      // Prompt the user for a filename.
      
      System.out.println( "Please enter the filename." );
      
      System.out.println( "NOTE: You MUST type the file extension (e.g. test.txt, filename.txt., etc.) and the file MUST be in the same folder as this Class." );
      
      fileName = scan.nextLine( );
      
      inputFile = new File ( fileName );
      
      // Read integers from the file and store them in the array using
      // the fillArrayFile method.
      
      numberOfElements = fillArrayFile( integerArray, inputFile );
      
      // Sort the array using the sortArray method.
      
      sortArray( integerArray, numberOfElements );
      
      // Use a loop to add the elements of the array to the search tree.
      
      for ( int i = 0; i < numberOfElements; i++ ) {
      
         testTree = BTNode.insert ( testTree, integerArray[ i ] );
         
      } // end for.
      
      // Print the tree in three different ways.
      
      // Use an if-else statement that will check if the file read was empty. 
      
      if( numberOfElements != 0 ) {
      
         System.out.println( "\nThis is the tree in pre-order style." );
      
         testTree.preorderPrint();
      
         System.out.println( "\nThis is the tree in in-order style." );
      
         testTree.inorderPrint( ); 
      
         System.out.println( "\nThis is the tree in post-order style." );
      
         testTree.postorderPrint( );
         
      } // end if.
      
      else {
      
         System.out.println( "The file did not have any integers to read." );     
      
      } // end else.
   
   } // end main method.
   
   // Implementation of the sortArray method.
   
   public static void sortArray ( int intArray [ ], int numElements ) {
   
      // The array is not necessarily full. Therefore, use numElements
      // to determine the number of elements that are occupied.
      
      // Sort the array in non decending order using insertion sort.
   
      // Use two for loops. The outer loop will check all the 
      // elements up to (but not including) numElements. The inner loop will 
      // check the element before i. Use an if statement that will check 
      // the elements and swap them if the element before is larger than the element 
      // after. The inner loop will only execute until k >= 0 in order to not 
      // go beyond the left most element.
      
      // Declare an integer variable that will serve as a temperary value holder.
      
      int tempValue;
      
      for ( int i = 0; i < numElements; i++ ) {
              
         for ( int k = i - 1; k >= 0; k-- ) {
          
            if ( intArray[ k + 1 ] < intArray[ k ] ) {
             
               tempValue = intArray[ k ];
               
               intArray[ k ] = intArray[ k + 1 ];
               
               intArray[ k + 1 ] = tempValue; 
        
            } // end if statement.
         
         } // end inner for loop.
       
      } // end outer for loop.
   
   } // end sortArray.
   
   // Implementation of the fillArrayFile method.
   
   public static int fillArrayFile ( int intArray [ ], File fileName ) {
   
      // The method will read integers from a file and store them in an array.
      
      // Declare a Scanner that will allow us to "scan" the file.
   
      Scanner fileScan = null;
      
      // Declare and inizialize a counting variable.
      
      int count = 0;
      
      // Use a try and catch that will catch if the file could not be opened.
      
      try {
      
         fileScan = new Scanner ( fileName );
         
      } // end try.
      
      catch ( FileNotFoundException e ) {
      
         System.out.println( "File could not be opened." );
         
         // End the main method.
         
         System.exit( 0 );
         
      } // end catch.
      
      // Use a while loop that will stop reading input if there is no
      // more data on the file or the array is full.
      
      while ( fileScan.hasNext( ) && ( intArray.length != count ) ) {
      
         // Read in the integer and store it in the array.
      
         intArray [ count ] = fileScan.nextInt( );
         
         // Increment count;
         
         count++;    
         
      } // end while
   
      return count;
   
   }// end fillArrayFile method. 
   
} // end class.