// CS 272 
// Program Name: WordPalindrome.java
// Author: Jose Franco Baquera
// Date: October 25, 2017
// Purpose: The purpose of this program 
// is to allow the user to input a string.
// The program can then check if the string 
// is a word palindrome. We can also check if 
// the string is a palindrome by calling the 
// is_palindrome method.

// Import statements.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;  

public class WordPalindrome {

   public static void main ( String[ ] args ) {
   
      // Declare a scanner and a String for user input.
   
	   Scanner scan = new Scanner( System.in );        
	
      String line;
      
      // Declare a new String that will be used for removing all the characters
      // that are not spaces, apostrophes, and letters.
      
      String modifiedLine;
   
      // Use a do-while loop that will input Strings from the user. The loop 
      // automatically stops when the user just presses Enter.                      
   
      do {
   
         // Prompt the user to input a sentence.
      
         System.out.println( "Type a sentence OR press Enter to quit." );
      
         // Get the user's input.
        
         line = scan.nextLine( ); 
      
            // Check that the user did not enter a newline.  
        
            if ( line.length( ) != 0 ) {
            
               // Create a second string that has only the letters, apostrophers, and spaces 
               // from the input string. (Note: All other characters are removed).
               
               modifiedLine = new String ( "" );
               
               // Case should not matter in the user's input.
               
               line = line.toUpperCase( );
                                        
               for ( int i = 0; i < line.length( ); i++ ) {
               
                  // Use if statements that will check if the character is
                  // a letter, apostrophe, or a space, then concatinate 
                  // to the modified String.
               
                  if ( line.charAt( i ) >= 'A' && line.charAt( i ) <= 'Z' )
                  
                     modifiedLine = modifiedLine + line.charAt( i );
                     
                  if ( line.charAt( i ) == '\'' || line.charAt( i ) == ' ' ) 
                    
                     modifiedLine = modifiedLine + line.charAt( i );
               
               } // end for.
               
               // Call the isWordPalindrome in order to check if the user's input is a 
               // word palindrome.   
                               
              if ( isWordPalindrome( modifiedLine ) )
              
	              System.out.println( "The sentence you entered is a word palindrome. Congrats!" );
                 
	           else
              
	              System.out.println( "The sentence you entered is NOT a word palindrome." );
                 
           } // end if
           
      } // end do.
   
      while ( line.length( ) != 0 );
      
   } // end main method.
 
   // Implementation of the is_palindrome method.
   
   public static boolean is_palindrome ( String input ) { 
     
      Queue<Character> q = new LinkedList<Character>( );
      
      Stack<Character> s = new Stack<Character>( );
      
      // One character from the input string. 
      
      Character letter;
      
      // Number of spots that mismatched

      int mismatches = 0;  
      
      // Index for the input string     
      
      int i;              
      
      for ( i = 0; i < input.length( ); i++) {
      
	      letter = input.charAt( i );
         
         if ( Character.isLetter( letter ) ) {
         
            letter = Character.toUpperCase( letter );
            
            q.add( letter );
            
            s.push(letter);
            
         } // end if.
         
      } // end for.
      
      while ( !q.isEmpty( ) ) {
      
         if ( q.remove( ) != s.pop( ) )
         
            mismatches++;
            
      } // end while.
      
      // If there were no mismatches, then the string was a palindrome.
      
      return (mismatches == 0); 
      
   } // end is_palindrome method.
   
   // Implementation of the isWordPalindrome method.
   
   public static boolean isWordPalindrome ( String input ) {
   
      // isWordPolindrome must use the Java Queue interface and the Java
      // LinkedList class. We must evaluate words at a time, so make
      // the queue and stack a String type. 
  
      Queue < String > queue = new LinkedList < String > ( );
      
      Stack < String > stack = new Stack < String > ( );
      
      // Use a Scanner object in order to make it easier to read
      // words one step at a time.
           
      Scanner sentence = new Scanner( input );
      
      // Declare and inizialize an integer variable that will
      // keep track of the mismatches. If mismatches increments anywhere
      // in this method, the parameter string is not a word polindrome.

      int mismatches = 0; 
      
      String tempWord = new String ( "" );
      
      // Use a while loop that will go trough the entire string.
            
      while ( sentence.hasNext( ) ){
      
         // Store the word inside a temporary String.
      
         tempWord = sentence.next( );
         
         // Add/Push that temporary String into both the queue
         // and stack.
         
         queue.add( tempWord );
         
         stack.push( tempWord );
         
         tempWord = new String ( "" );

      } // end while.
      
      // Use a for loop that will run until the all the items
      // in the queue are removed     
   
      while ( !queue.isEmpty( ) ) {
      
         // Check if the words are the same by using the equals method.
      
         if ( !( queue.remove( ).equals( stack.pop( ) ) ) )
         
            mismatches++;
            
      } // end while.
    
      // If there were no mismatches, then the string was a word palindrome.
      
      return (mismatches == 0);
       
   } // end isWordPalindrome method.
     
} // end class.