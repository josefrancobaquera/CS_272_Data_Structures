// CS 272 
// Program Name: ArrayStack.java
// Author: Jose Franco Baquera
// Date: October 18, 2017
// Purpose: The purpose of the program is 
// to serve as a generic stack class.
// The following methods will allow a 
// programer to modify and create a stack
// of objects of any type. 

// Import statements. 

import java.util.EmptyStackException;

public class ArrayStack < E > implements Cloneable {

   // Private instance variables.
   
   private E [ ] data;
   
   private int manyItems; 
   
   // Implementation of the default constructor.
      
   @SuppressWarnings( "unchecked" )
   
   public ArrayStack ( ) {
   
      // The default contructor will instantiate an array capable 
      // of holding 10 items, meaning that the stack can hold
      // 10 items before calling the ensure capacity method.
      
      // Each stack will start with zero items. 
      
      final int INITIAL_CAPACITY = 10;
      
      manyItems = 0;
      
      data = ( E[ ] ) new Object[ INITIAL_CAPACITY ];
      
   } // end default constructor.
   
   // Implementation of the second constructor.

   @SuppressWarnings( "unchecked" )
   
   public ArrayStack( int initialCapacity ) {
      
      // Check if the parameter is negative. If so 
      // throw an exception.
      
      if (initialCapacity < 0)
      
         throw new IllegalArgumentException ( "InitialCapacity too small " + initialCapacity );
         
      // If the parameter is valid, instantiate the array to the size passed 
      // as the parameter.
      
      // Each stack will start with zero items.
         
      manyItems = 0;
      
      data = ( E[ ] ) new Object[ initialCapacity ];
      
   } // end second constructor.
   
   // Implementation of the clone method.
      
   @SuppressWarnings( "unchecked" )
   
   public ArrayStack < E > clone( ) {  
   
      // This method will clone an ArrayStack object, so it
      // must return a generic ArrayStack.
      
      ArrayStack < E > answer;
      
      // Use a try and catch when using super.clone( ).
      // Make sure to cast since super.clone( ) returns
      // type Object.
      
      try {
      
         answer = ( ArrayStack < E > ) super.clone( );
         
      } // end try.
      
      catch ( CloneNotSupportedException e ) {
       
         // This exception should not occur. But if it does, it would probably indicate a
         // programming error that made super.clone( ) unavailable. 
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         
         throw new RuntimeException ( "This class does not implement Cloneable" );
         
      } // end catch.
     
      // Clone the array since its an object and we need to do deep cloning.
      
      answer.data = data.clone( );
      
      return answer;
   
   } // end clone method.
   
   // Implementation of the ensureCapacity method.
   
   @SuppressWarnings( "unchecked" ) 
   
   public void ensureCapacity( int minimumCapacity ) {
   
      // Declare a new bigger array of type E.
      
      E biggerArray[ ];
      
      // If the length of the data array is smaller than 
      // the minimum capacity needed, instantiate the bigger 
      // array and copy the elements of the data array into
      // the bigger array. Then make data reference the 
      // bigger array. 
      
      if ( data.length < minimumCapacity ) {
         
         biggerArray = ( E[ ]) new Object[ minimumCapacity ];
         
         System.arraycopy( data, 0, biggerArray, 0, manyItems );
         
         data = biggerArray;
         
      } // end if.
      
   } // end ensureCapacity method.
   
   // Implementation of the getCapacity method.
   
   public int getCapacity ( ) {
   
      // Return the length of the data array.
      
      return data.length;
      
   } // end getCapacity method.
   
   // Implementation of the isEmpty method.  
 
   public boolean isEmpty ( ) {
   
      // If the stack is empty return true, else false.
      
      return (manyItems == 0);
      
   } // end isEmpty method.
   
   // Implementation of the peek method.
     
   @SuppressWarnings( "unchecked" )
   
   public E peek( ) {
   
      // Throw an exception if there are no items in the stack.
      
      if ( manyItems == 0 )
      
         // EmptyStackException is from java.util and its constructor has no argument.
         
         throw new EmptyStackException( );
         
      // Return the object at the top of the stack. Tis method should not change the 
      // stack at all.
         
      return data[ manyItems - 1 ];
      
   } // end peek method.
   
   // Implementation of the pop method. 
      
   @SuppressWarnings( "unchecked" )
   
   public E pop ( ) {
   
      // Throw an exception if there are no items in the stack.
      
      if ( manyItems == 0 )
      
         // EmptyStackException is from java.util and its constructor has no argument.
         
         throw new EmptyStackException( );
         
      // Return the object at the TOP of the list. This method, unlike peek, should
      // change the data array.
      
      return data[ --manyItems ];
      
   } // end pop method.
   
   // Implementation of the push method.
  
   public void push( E item ) {
   
      // Make sure that the stack has enough length to store the new item. 
   
      if ( manyItems == data.length ) {
      
         // Double the capacity and add 1; this works even if manyItems is 0. However, in
         // case that manyItems*2 + 1 is beyond Integer.MAX_VALUE, there will be an 
         // arithmetic overflow and the stack will fail.
         
         ensureCapacity(manyItems*2 + 1);
         
      } // end if.
      
      // Push the item at the top of the stack. Then increase how many items you have on 
      // the stack.
      
      data[ manyItems ] = item;
      
      manyItems++;
      
   } // end push method.

   // Implementation of the size method.
   
   public int size ( ) {
   
      // Return how many items you have in the stack.
      
      return manyItems;
      
   } // end size method.
   
   // Implementation of the trimToSize method.
       
   @SuppressWarnings( "unchecked" )
   
   public void trimToSize ( ) {
   
      // Declare a new array of type E.
      
      E trimmedArray [ ];
      
      // If the length of the stack is not equal to manyItems,
      // copy the references of the data array into the new array.
      // Then make data reference the new trimmed array.
      
      if ( data.length != manyItems ) {
      
         // Make sure to cast the new array to type E [ ]
         // when we are instantiating it.
      
         trimmedArray = ( E[ ] ) new Object[ manyItems ];
         
         System.arraycopy( data, 0, trimmedArray, 0, manyItems );
         
         data = trimmedArray;
         
      } // end if.
      
   } // end trimToSize method.
   
   // Implementation of the toString method.
   
   @SuppressWarnings( "unchecked" )
   
   public String toString ( ) {
   
      // Declare a new string that will allow us to concatinate the answer.
   
      String answer = "Top:\n";
   
      // If there are no objects in the stack, return an error message.
   
      if ( manyItems == 0 )
      
         return "Oooops. There are no elements in the stack. Try again.\n";
         
      // Use a for loop that will go trough the entire stack and print the last one first since
      // a stack is a "First in, Last Out" data structure.    
   
      for ( int i = ( manyItems - 1 ); i >= 0; i-- ) {
      
         // Concatinate answer.

         answer = answer + data[ i ].toString( ) + "\n";
   
      } // end for.
      
      // Return answer.
      
      return answer;
  
   } // end toString method.
    
} // end class.