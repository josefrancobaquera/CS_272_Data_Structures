// Test Class for the Class Deck

public class DeckTest {

   public static void main ( String args [] ) {
   
      String card;
      Deck deck1;
      Deck deck2;
      deck1 = new Deck( );
      deck2 = new Deck( );
   
      deck1.printDeck( );
      System.out.println( );
      deck1.shuffleDeck( );
      deck1.printDeck( );
      System.out.println( );
      deck2.printDeck( );
      System.out.println( "\nDeck 1\n" + deck1 );
   
      System.out.println( "\nDealing cards from deck1:" );
      while( !deck1.emptyDeck( ) ){
         card = deck1.dealACard( );
         System.out.println( "Card:   " + card );
      
      } // end while  
   
   } // end main

} // end Deck Class