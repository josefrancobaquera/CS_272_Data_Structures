// CS 272 
// Program Name: IntArrayBag.java
// Author: Jose Franco Baquera
// Date: November 8, 2017
// Purpose: The purpose of the program is to
// serve as a "bag" that is capable of holding
// integers.

public class IntArrayBag implements Cloneable {

   // Instance variables.

   private int[ ] data;
   
   private int manyItems; 
   
   // Default Constructor.
   
   public IntArrayBag( ) {
   
      final int INITIAL_CAPACITY = 10;
      
      // Each bag starts with zero items.

      manyItems = 0;

      data = new int[ INITIAL_CAPACITY ];
      
   } // end dault constructor
   
   // Second constructor.
   
   public IntArrayBag( int initialCapacity ) {
   
      // First check if the parameter is zero or less. 
      // Throw an exception if true.
   
      if (initialCapacity < 0)

         throw new IllegalArgumentException( "The initialCapacity is negative: " +  initialCapacity );
         
      // Inizialize the instance variables.

      data = new int[initialCapacity];
      
      // Each bag starts with zero items.
      
      manyItems = 0;
      
   } // end second constructor.

   // Implementation of the add method.
   
   public void add( int element ) {
   
      if ( manyItems == data.length ) {  
      
         // Ensure twice as much space as we need.
         
         ensureCapacity( ( manyItems + 1 ) * 2 );
         
      } // end if.

      data[ manyItems ] = element;
      
      // Increment manyItems.
      
      manyItems++;
      
   } // end add method
   
   // Implementation of the addMany method.
   // (Note: This is a variable arity method. We can specify as many parameters
   // as needed).
   
   public void addMany( int... elements ) {
   
      // Use an if statement that will check that there
      // is enough space in the array.
   
      if ( manyItems + elements.length > data.length ) {  
      
         // Call the ensureCapacity method to 
         // ensure twice as much space as we need.
         
         ensureCapacity( ( manyItems + elements.length ) * 2 );
         
      } // end if.
      
      // Copy the data array into a new array.

      System.arraycopy( elements, 0, data, manyItems, elements.length );
      
      manyItems += elements.length;
   
   } // end addMany method.
   
   // Implementation of the addAll method.
   
   public void addAll( IntArrayBag addend ) {
   
      // Ensure that there is enough space on the array.
   
      ensureCapacity( manyItems + addend.manyItems );
      
      // Copy the data array into a new array.
         
      System.arraycopy( addend.data, 0, data, manyItems, addend.manyItems );
      
      manyItems += addend.manyItems;
      
   } // end addAll. 
   
   // Implementation of the clone method.  
   
   public IntArrayBag clone( ) {  
   
      // Clone an IntArrayBag object.
      
      IntArrayBag answer;
      
      // Use a try and catch if the super.clone method does not work.
      
      try {
      
         answer = ( IntArrayBag ) super.clone( );
         
      } // end try.
      
      catch ( CloneNotSupportedException e ) {
      
          throw new RuntimeException( "This class does not implement Cloneable" );
          
      } // end catch. 
      
      // Clone the data array.
      
      answer.data = data.clone( );
      
      // Return the new cloned bag.
    
      return answer;
      
   } // end clone.
   
   // Implementation of the countOccurrences method.
   
   public int countOccurrences( int target ) {
   
      // Declare and inizialize a counting variable to zero.
   
      int count = 0;
      
      // Use a for loop that will go through the entire array.
  
      for ( int index = 0; index < manyItems; index++ )
      
         // If the target was found in the bag, increment the counting variable.
         
         if ( target == data[ index ] )
            
            count++;
            
      // Return the number of occurences that were in the bag.
     
      return count;
      
   } // end countOccurences.
   
   // Implementation of the ensure capacity method.
   
   public void ensureCapacity( int minimumCapacity ) {
      
      // Declare a bigger array.
      
      int biggerArray[ ]; 
      
      // Check if we need a bigger array.
      
      if ( data.length < minimumCapacity ) {
      
         // Allocate space.
         
         biggerArray = new int[ minimumCapacity ]; 
         
         // Copy the array using arraycopy.
         
         System.arraycopy( data, 0, biggerArray, 0, manyItems );

         data = biggerArray; 
          
      } // end if.
   
   } // end ensureCapacity method.
   
   // Implementation of the getCapacity method.
   
   public int getCapacity( ) {
   
      // Return the size of the array.
      
      return data.length;
      
   } // end getCapacity.
   
   // Implementation of the remove method.
            
   public boolean remove( int target ) {
      
      // Declare a variable for the loop.
      
      int index;  
      
      // Use a for loop that check if there is such an element in the bag. 
      
      for (index = 0; ( index < manyItems ) && ( target != data[ index ] ); index++);
      
      // If the target was not found, return false. If it was found, remove it from the bag
      // and return true. 
         
      if ( index == manyItems ) 
       
         return false;
         
      else {  
         manyItems--;
         
         data[ index ] = data[ manyItems ];
         
         return true;
         
      } // end else.
      
   } // end remove method.
   
   // Implementation of the size method.
                 
   public int size( ) {
   
      // Return how many integers are inside the bag.
      
      return manyItems;
      
   } // end size method.
   
   // Implementation of the trimToSize method.
   
   public void trimToSize( ) {
   
      // Declare a new array.
      
      int trimmedArray[ ];
      
      if ( data.length != manyItems ) {
      
         trimmedArray = new int[ manyItems ];
         
         // Copy the items in data into the new trimmed array.
         
         System.arraycopy(data, 0, trimmedArray, 0, manyItems);
         
         data = trimmedArray;
         
      } // end if.
      
   } // end trimToSize method.
   
   // Implementation of the union method.      

   public static IntArrayBag union( IntArrayBag b1, IntArrayBag b2 ) {

      // A call to this method would look like
      // IntArrayBag.union( first IntArrayBag, second IntArrayBag )
         
      IntArrayBag answer = new IntArrayBag( b1.getCapacity( ) + b2.getCapacity( ) );
     
      // Use two simple loops to copy the array.

      for ( int i = 0; i < b1.manyItems; i++ )
      
         answer.data[ i ] = b1.data[ i ];

      for ( int j = 0; j < b2.manyItems; j++ )
         
         answer.data[ b1.manyItems + j ] = b2.data[ j ];

      answer.manyItems = b1.manyItems + b2.manyItems;
      
      return answer;
      
   } // end union method.
   
   // Implementation of the findRandomItem method.
   
   public int findRandomItem( ) {
   
      // Throw a new exception if the bag is empty.
      
      if ( manyItems == 0 )
      
         throw new IllegalArgumentException( "The bag is empty." );
         
      // Generate a random index between 0 and manyItems - 1 and store 
      // the value at that location in the array into a temp variable.
      
      int answer = data[ ( int ) ( ( Math.random( ) * ( ( manyItems - 1 ) - 0 + 1 ) ) + 0 ) ];
      
      // Remove the integer from the bag.
   
      remove ( answer );
      
      // Return the random integer.
      
      return answer;
   
   } // end findRandomItem method.
      
} // end class.