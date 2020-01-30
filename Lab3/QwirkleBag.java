
// QwirkleBag.java - represents a Qwirkle Bag
// Adapted from IntNode.java by Esther Steiner
// CS 272
// 09-24-2017

public class QwirkleBag extends Object implements Cloneable
{

   // instance variables

   private Tile[ ] data;
   private int manyItems; 
   

   // constructor : behavior #1

   public QwirkleBag( )
   {
      final int INITIAL_CAPACITY = 108;

      manyItems = 108;

      data = new Tile[INITIAL_CAPACITY];
      for (int i = 0; i < INITIAL_CAPACITY; i++)
         data[i] = new Tile( i % 6 + 1, i % 36 / 6 + 1 );
   }
  
   public String toString() {
      
      String answer = "";
      for (int i = 0; i < manyItems; i++)
        answer = answer + String.format("%3d",i+1) + ":  " + data[i].toString() + "\n";
      return answer;
   }

   // This method was added so that the entire contents of the
   // data array could be displayed.
   //
   // The behavior is different from toString because toString
   // only includes tiles up to manyItems
   
   public void printAll(int numPerLine, boolean printCompleteArray)
   {
      int lastIndex = (printCompleteArray ? data.length : manyItems);
      for (int index = 0; index < lastIndex; index++)
         System.out.print( data[index] + " "
                           + ((index+1)%numPerLine == 0 ? "\n" : ""));
            
   } // end method
 
  // add one item : behavior #2

   public void add(Tile element)
   {
      if (manyItems == data.length)
      {  // Ensure twice as much space as we need.
         ensureCapacity((manyItems + 1)*2);
      }

      data[manyItems] = element.clone();
      manyItems++;
   }

   // Clone an QwirkleBag object.
   public QwirkleBag clone( ) {
      QwirkleBag answer;
      
      try
      {
         answer = (QwirkleBag) super.clone( );
      }
      catch (CloneNotSupportedException e) {
          throw new RuntimeException
           ("This class does not implement Cloneable");
      }  
      answer.data = data.clone( );
    
      return answer;
   }

   public int countOccurrences(Tile target) {
      int count = 0;
  
      for (int index = 0; index < manyItems; index++)
         if (target.equals(data[index]))
            count++;

      return count;
   }
   
   public void ensureCapacity(int minimumCapacity) {
      Tile biggerArray[ ]; // declaration
      
      if (data.length < minimumCapacity)
      {
         biggerArray = new Tile[minimumCapacity]; // allocate space

         for (int index = 0; index < manyItems; index++ )
            biggerArray[index] = data[index];
            
         data = biggerArray;  
      }
   }

   public int getCapacity( ) {
      return data.length;
   }
   
   // This method was added so that a Tile at a specific position
   // (index) in the data array can be retrieved from the bag.
   
   public Tile tileAt( int pos ) {
   
      if (pos >= manyItems)
         return null;
      
      return data[pos];
   }

   public boolean remove(Tile target)
   {
      int index;  // must declare before the loop

      for (index = 0; (index < manyItems) && (!target.equals(data[index])); index++)
         ;
         
      if (index == manyItems)  // target was not found
         return false;
      else
      {  
         manyItems--;
         data[index] = data[manyItems];
         return true;
      }
   } 
                 
   public int size( ) {
      return manyItems;
   } // end size
   
   
   public void trimToSize( ) {
      Tile trimmedArray[ ];
      
      if (data.length != manyItems)
      {
         trimmedArray = new Tile[manyItems];
         for (int index = 0; index < manyItems; index++)
             trimmedArray[index] = data[index];
         data = trimmedArray;
      }
   } // end trimToSize
   
   public Tile draw( ) {
   
      if (manyItems == 0)
         return null;
      
      int pick = (int) (Math.random() * manyItems);
      Tile chosen = data[pick];
      data[pick] = data[manyItems-1];
      manyItems--;
   
      return chosen;
   }// end draw
      
} // end class
