// CS 272 
// Program Name: TileNode.java
// Author: Jose Franco Baquera
// Date: October 4, 2017
// Purpose: The purpose of the program is 
// to define the TileNode class. 
// Each TileNode object will have two attributes: 
// a reference to a Tile object and a reference 
// to another TileNode object.

public class TileNode {

   // Declare instance variables.
    
   private Tile data;
   
   private TileNode link;   
   
   // Implementation of the constructor method. 

   public TileNode ( Tile initialData, TileNode initialLink ) {
   
      // Inizialize the instance variables with the given parameters.
      
      data = initialData;
      
      link = initialLink;
      
   } // end constructor.
   
   // Implementation of the addNodeAfter method. The calling object 
   // is a reference to the node before the location where  
   // I want to add a new Tile into the list.
  
   public void addNodeAfter ( Tile item ) {
      
      link = new TileNode ( item, link );
   
   } // end addNodeAfter method.          
   
   // Implementation of the getData method.
   
   public Tile getData ( ) {
   
      // Return the data object. 
         
      return data;
      
   } // end getData method.
   
   // Implementation of the getLink( ) method.
   
   public TileNode getLink ( ){
      
      return link;                                               
   
   } // end getLink method. 
   
   // Implementation of the listCopy method.
   // This is a static method, so we need to call it
   // as TileNode.listCopy ( reference to the head ).
   // This method will duplicate the list and return 
   // a reference which is the head of the new list.
    
   public static TileNode listCopy ( TileNode source ) {
   
      // Declare two TileNode references in order to 
      // make it possible to go trough all the list.
   
      TileNode copyHead;
      
      TileNode copyTail;
      
      // If the list is empty, return null. 
      
      if ( source == null )
      
         return null;
         
      // Make the first node for the newly created list.
      
      copyHead = new TileNode ( source.data, null );
      
      copyTail = copyHead;
      
      // Make the rest of the nodes for the newly created list.
       
      while ( source.link != null ) {
      
         source = source.link;
         
         copyTail.addNodeAfter ( source.data );
         
         copyTail = copyTail.link;
         
      } // end while.
 
      // Return the head reference for the new list.
      
      return copyHead;
      
   } // end listCopy method.
   
   // Implementation of the listLength method.
 
   public static int listLength ( TileNode head ) {
        
      // Declare and inizialize a counting variable
      // that will count all the nodes in the list.

      int answer = 0;
      
      // Use a for loop to go trough the entire list.
      
      for ( TileNode cursor = head; cursor != null; cursor = cursor.link )
      
         // Increment answer.
         
         answer++;
        
      return answer;
      
   } // end listLength method.
   
   // Implementation of the listSearch method. Search for
   // a particular data value in the list. Return a reference
   // to the node where the value was found. If the value isn't
   // in the list, return null.
   
   public static TileNode listSearch ( TileNode head, Tile target ) {
   
      // Create a new cursor that will allow us to go trough the list.
      
      TileNode cursor;
      
      // Use a for loop that will go trough the entire list. If 
      // the target is found, return a Tilenode that references to
      // it (i.e. only one at a time). If no target is found, return null.
      // We need to use the equals method since these are references to
      // Tile objects.
      
      for ( cursor = head; cursor != null; cursor = cursor.link )
      
         if ( target.equals( cursor.data ) )
         
            return cursor;
            
      return null;
      
   } // end listSearch method.
   
   // Implementation of the removeNode after method.
   // This method is called using the node that is 
   // before the one we want to remove.
      
   public void removeNodeAfter ( ) {
   
      link = link.link;
      
   } // end removeNodeAfter method.          
   
   // Implementation of the setData method
   // (i.e. the first mutator).
   
   public void setData ( Tile newData ) {
   
      data = newData;
      
   } // end setData method.                                                               
   
   // Implementation of the setLink method 
   // (i.e. the second mutator).
   
   public void setLink ( TileNode newLink ) { 
                      
      link = newLink;
      
   } // end setLink method.
   
   // Implementation of the printList method.
   
   public static void printList ( TileNode head ) {
   
      // Declare a cursor that will allow us to go trough the 
      // entire list.
      
      TileNode cursor = head;
      
      // If head is null, there are no nodes in the list.
      
      if ( cursor == null ) {
      
         System.out.print( "Ooops. There are no tiles in the list. Try again." );
              
      } // end if
      
      else { 
        
      // Use a for loop that will go trough the entire list and print 
      // the Tile objects.
      
      System.out.print( cursor.getData( ) );
      
      for ( cursor = cursor.getLink( ); cursor != null; cursor = cursor.getLink ( ) )
      
         System.out.print( " -- " + cursor.getData ( ) ); 
         
      } // end else .
      
      // Print a newline for easier read.
      
      System.out.println( "" ); 
   
   } // end printList method.
   
   // Implementation of the insertAtHead method.
   
   public static TileNode insertAtHead ( TileNode head, TileNode tile ) {
   
      // If list is empty, make the first TileNode, else change the
      // link of the tile parameter to the head. 
      
      if ( head == null ) {
      
         head = tile;
         
      } // end if.
      
      else { 
      
         tile.setLink ( head );
         
         head = tile;
      
      } // end else.
      
      // Return the head reference.
      
      return head;
     
   } // end insertAtHead method.
   
   // Implementation of the reverse method.
   
   public static TileNode reverse ( TileNode original ) {
   
      // Create several TileNode objects that will help
      // us reverse the linked list.
   
      TileNode cursor = original;
      
      TileNode newList = null;
      
      // If the original TileNode is empty (ie null), return 
      // null.
      
      if ( original == null )
      
         return null;
         
      // Use a while loop that will go through the entire original 
      // list and create a new list with the nodes of the original
      // list reversed.
      
      while ( cursor != null ) {
      
         // If the newList is null, then create the first TileNode.
      
         if ( newList == null ) {
         
            newList = new TileNode( cursor.getData( ), null );         
         
         } // end if
         
         // If the newList is not null, create new TileNodes
         // at the head of the list.
         
         else { 
         
            newList = new TileNode( cursor.getData( ), newList );   
            
         } // end else.
         
         // Update the cursor in order to go to the next node 
         // in the original linked list.
         
         cursor = cursor.getLink( );  
      
      } // end while.
      
      // Return the head of the new list.
      
      return newList;    
   
   } // end reverse method.
  
} // end class.