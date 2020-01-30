// CS 272 
// Program Name: QwirkleHandTest.java
// Author: Jose Franco Baquera
// Date: October 9, 2017
// Purpose: The purpose of the program is 
// to serve as a test program for the 
// for the TileNode class. 

public class QwirkleHandTest {

   public static void main ( String args [ ] ) {
   
      // Create a new empty TileNode linked list, a new QwirkleBag,
      // several tiles, and many TileNode objects in order
      // to test the member methods.
      
      Tile test1 = new Tile ( 1, 3 );
      
      Tile test2 = new Tile ( 2, 6 );
   
      TileNode qwirkleHand = null;
      
      TileNode cursorHand = null;
      
      TileNode copyQwirkleHand = null;
      
      TileNode reverseQwirkleHand = null; 
      
      TileNode targetFound = null;     
      
      // Create a new QwirkleBag.
      
      QwirkleBag game1 = new QwirkleBag ( );
      
      // Use a for loop that will draw 6 tiles outinsert at head random Tiles that
      // are drawed out from the game1 QwirkleBag. 
      
      // This will test the constructor and insertAtHead method.
            
      for ( int t = 1; t <= 6; t++ )
      
         qwirkleHand = TileNode.insertAtHead( qwirkleHand, new TileNode ( game1.draw(), null ) );
        
      // Testing the printList method.         
            
      System.out.println( "\n*****These are the six tiles in the player's hands.*****" ); 
          
      TileNode.printList( qwirkleHand );
      
      // Testing the reverse method.
      
      System.out.println( "\n*****These are the six tiles in the player's hands but in REVERSED order.*****" );
      
      reverseQwirkleHand = TileNode.reverse( qwirkleHand );
      
      TileNode.printList( reverseQwirkleHand );
     
      // Testing the listCopy and listLength methods.
      
      System.out.println( "\n*****Lets copy the qwirkleHand linked list to another linked list. Here it is:*****" );
      
      copyQwirkleHand = TileNode.listCopy ( qwirkleHand );
      
      TileNode.printList( copyQwirkleHand );
      
      System.out.println( "copyQwirkleHand has " + TileNode.listLength( copyQwirkleHand ) + " nodes." );
      
      // Testing the addNodeAfter and getLink methods.
      
      System.out.println( "\n*****Lets add two Tiles in the middle of the copyQwirkleHand linked list. Here is the new linked list:*****" );
      
      // Assign a copyQwirkleHand reference to a cursor so copyQwikleHand remains unchanged 
      // when we test the methods.
         
      cursorHand = copyQwirkleHand;
      
      // NOTE: The getLink method will be tested in this for loop.
      
      for ( int i = 1; i < ( TileNode.listLength( copyQwirkleHand ) / 2 ); i++ )
      
         cursorHand = cursorHand.getLink( );
         
      cursorHand.addNodeAfter( test1 );
      
      cursorHand.addNodeAfter( test2 ); 
      
      TileNode.printList( copyQwirkleHand );
      
      // Assign cursorHand to the copyQwirkleHand TileNode object again.
      
      cursorHand = copyQwirkleHand; 
         
      // Testing the getData method. 
      
      System.out.println( "\n*****Here is the Tile of the first node of copyQwirkleHand.*****" );
      
      System.out.println( cursorHand.getData( ) );
      
      // Testing the listSearch method.
      
      System.out.println( "\n*****Searching for a green circle in copyQwirkleHand. There should be at least one since we added it to the linked list.*****" );
            
      targetFound = TileNode.listSearch( copyQwirkleHand, test2 );
      
      System.out.println( "Here is the green circlre tile: " + targetFound.getData( ) );
      
      // Testing the setData method.
      
      cursorHand = copyQwirkleHand;
      
      System.out.println( "\n*****Setting the tile in the first node of the copyQwirkleHand to a green circle. Here is the modified list:*****" );
      
      cursorHand.setData( test2 );
      
      TileNode.printList( copyQwirkleHand );
      
      // Testing the removeNodeAfter method.
      
      System.out.println( "\n*****Removing the SECOND node from copyQwirkleHand. Here is the modified list:*****" );
      
      copyQwirkleHand.removeNodeAfter(  );
      
      TileNode.printList( copyQwirkleHand ); 
      
      // Testing the setlink. Note: This method was also tested in the TileNode class.
      
      System.out.println( "\n*****Setting the link in cursorHand to reference to the head of the reversed original qwirkleHand.*****" );
      
      System.out.println( "*****Here is the list (ie. should print ONE green circle, then the reverseQwirkleHand linked list).*****" );
            
      cursorHand.setLink( reverseQwirkleHand );
      
      TileNode.printList( cursorHand );
      
      // The original linked list qwirkleHand should still be unchanged.
      
      System.out.println( "\n*****qwirkleHand should still be unchanged. Here it is:*****" );
      
      TileNode.printList( qwirkleHand );
      
   } // end main.
   
} // end class.