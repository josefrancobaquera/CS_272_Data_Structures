// CS 272 

// Program Name: Deck.java

// Author: Jose Franco Baquera

// Date: August 23, 2017

// Purpose: The purpose of the program is to allow 
// DeckTest.java to create Deck objects through "OOP". 
// The first method will create a Deck object, the 
// second method will create a string version of 
// the object, the third method will shuffle the cards,
// the fourth method will print the array elements, the 
// fifth method deal a card, and the last method will 
// return true if there are no 
// cards in the deck, false otherwise.

public class Deck { 

   // Declare instance variables. Make them private.
   
   private int arrayDeck[ ];
   private int totalCardsLeft;
     
   // Constructor
   
   public Deck ( ) {
   
      // Initialize the array Deck, each deck starts with 
      // 60 cards.
      
      totalCardsLeft = 60;  
      
      arrayDeck = new int[ 60 ];
      
      // Use for loop to store integers 0 to 59 into the array.
      
      for ( int i = 0; i < arrayDeck.length; i++ ) {
      
         arrayDeck[ i ] = i;
      
      } // end for
      
   } // end default constructor
        
   // toString method
   
   public String toString( ) {
   
      // Top card begins at index zero. Declare
      // an empty string and two arrays
      // with the names of the suits and numbers.
      
      int indexOfTopCard = 60 - totalCardsLeft;
      
      String result = "";
      
      String deckNum[ ] = { "Ace", "Two", "Three", 
      
         "Four", "Five", "Six", "Seven", "Eight", "Nine", 
         
         "Ten", "Jack", "Queen", "King" };
         
      String deckSuit[ ] = { "Spades", "Hearts", "Clubs", 
      
         "Diamonds" };
      
      // First check if there are any cards left, else 
      // return an error message.

      if ( totalCardsLeft > 0 ) {
     
         // First, concatenate how many cards are left in 
         // the deck.
         
         result = result + totalCardsLeft + " cards left " +
         
            "in the deck.\n";
       
         // Use for loop to print all the remaining cards in the 
         // deck. Use modulus, integer division, and concatenation
         // to eliminate the need for multiple if statements. 
         // Only print the cards that are left.
         
         for ( int i = indexOfTopCard; i < arrayDeck.length; i++ ) {
         
            // If the card is between 0 and 51, it is a 
            // spade, heart, club, or diamond. If the card
            // is between 52 and 55, it is a jester.
            // Otherwise its a wizard.
            
            if ( arrayDeck[ i ] < 52 ) {
                  
                  result = result + deckNum[ arrayDeck[ i ] % 13 ] + 
                  
                  " of " + deckSuit[ arrayDeck[ i ] / 13 ] + "\n";
               
            } // end if                    
                        
            else if ( arrayDeck[ i ] < 56 ) {
            
               result = result + "Jester\n";
            
            } // end else if
            
            else {
            
               result = result + "Wizard\n";
               
            } // end else
      
         } // end for
         
         return result; 
         
      } // end if
      
      return "There are no more cards left. Shuffle and try again."; 
   
   } // end toString method
   
   // shuffleDeck method
   
   public void shuffleDeck ( ) {
   
      // Reset the total cards back to 60.
      
      totalCardsLeft = 60;
      
      // Use for loop to make random exchanges. We also need to 
      // initialize two variables: one that stores the random number
      // generated and another one to hold a temporary value.
      
      int tempShuffledCard, randomIndex;         
      
      for ( int i = 0; i < arrayDeck.length; i++ ) {
      
         // Use temporary variable to store number, generate a 
         // random index number between 0 and 59, copy the 
         // number from the random index to the applicable index 
         // from the for loop, then transport the number from
         // the temporary variable into the element of the random 
         // index. 
         
         tempShuffledCard = arrayDeck[ i ];
         
         randomIndex = (int) ( Math.random( ) * ( 59 - 0 + 1) + 0 );
         
         arrayDeck[ i ] = arrayDeck[ randomIndex ];
         
         arrayDeck[ randomIndex ] = tempShuffledCard;    
   
      } // end for loop
   
   } // end shuffleDeck method
   
   // printDeck method
   
   public void printDeck ( ) {
   
      // Inizialize counting variables that will keep track of the number 
      // of integers printed per line.
      
      int countNumbersPerLine =  0;
            
      System.out.println( "The Deck array contains these numbers." );
      
      // Use a for loop that will print all the elements. 
      // When ten numbers are printed in a line, go to the 
      // next line. Use a width of 4 spaces.
      
      for ( int i = 0; i < arrayDeck.length; i++ ) {
      
         System.out.printf( "%4d", arrayDeck[ i ] );
         
         countNumbersPerLine = countNumbersPerLine + 1;
         
         if ( countNumbersPerLine%10 == 0 )
         
            System.out.println( );
         
      } // end for
      
   } // end printDeck method

   // dealACard method
   
   public String dealACard ( ) {
   
      int indexOfTopCard = 60 - totalCardsLeft;
      
      String result = "";
      
      String deckNum [] = { "Ace", "Two", "Three", 
      
         "Four", "Five", "Six", "Seven", "Eight", "Nine", 
         
         "Ten", "Jack", "Queen", "King" };
         
      String deckSuit [] = { "Spades", "Hearts", "Clubs", 
      
         "Diamonds" };
      
      // First check if there are any cards left, else return 
      // an error message.

      if ( totalCardsLeft > 0 ) {
              
         // Use modulus, integer division, and concatenation
         // to eliminate the need for multiple if statements. 
         // Only print ONE card (ie. the top card) at a time, 
         // so no for loop is needed.
         
         // If the card is between 0 and 51, it is a 
         // spade, heart, club, or diamond. If the card
         // is between 52 and 55, it is a jester.
         // Otherwise its a wizard.
     
         if ( arrayDeck[ indexOfTopCard ] < 52 ) {
            
               result = result + 
               
               deckNum[ arrayDeck[ indexOfTopCard ]%13 ] + 
               
               " of " + deckSuit[ arrayDeck[ indexOfTopCard ] / 13 ];
               
         } // end if                    
                        
         else if ( arrayDeck[ indexOfTopCard ] < 56 ) {
            
            result = result + "Jester";
            
         } // end else if
            
         else {
            
            result = result + "Wizard";
               
         } // end else
         
         // Decrease the number of cards left by one.
         
         totalCardsLeft = totalCardsLeft - 1;
      
         return result; 
         
      } // end if
      
      return "There are no more cards left. Shuffle and try again."; 
         
   } // end dealACard method
      
   // emptyDeck method
   
   public boolean emptyDeck ( ) {
   
      // If there are more than zero cards in the deck, return true. 
      // Otherwise return false.
      
      if ( totalCardsLeft == 0 ) 
      
         return true;
         
      return false;
   
   } // end emptyDeck method
  
} // end class