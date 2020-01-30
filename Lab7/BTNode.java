// CS 272 
// Program Name: BTNode.java
// Author: Jose Franco Baquera
// Date: November 20, 2017
// Purpose: The purpose of the program is 
// serve as a generic class capable of 
// creating binary trees.

public class BTNode <E> {

   // Instance variables.
   
   private E data;
   
   private BTNode <E> left, right;   
   
   private int height;
   
   // Implementation of the contructor.
   
   public BTNode( E initialData, BTNode <E> initialLeft, BTNode <E> initialRight, int newHeight ) {
   
      // Inizialize the first three variables.
      
      data = initialData;
      
      left = initialLeft;
      
      right = initialRight;
      
      // To inizialize the variable height, use the following rules:
      // 1) A leaf has a height 1.
      // 2) A non-leaf has height equal to one more than the maximum of the heights of its left 
      // and right subtrees.
      
      height = newHeight;
     
      if ( left == null && right == null )
      
         height = 1;
         
      else 
      
         height = Math.max( left.height, right.height ) + 1;
      
   } // end constructor.  
   
   // Implementation of the data accessor. 
  
   public E getData( ) {
   
      return data;
      
   } // end getData method.
   
   // Implementation of the left accessor.   
   
   public BTNode <E> getLeft( ) {
   
      return left;  
                                                   
   } // end getLeft method.
   
   // Implementation of the getLeftmostData method.   
   
   public E getLeftmostData( ) {
   
      if ( left == null )
      
         return data;
         
      else
      
         return left.getLeftmostData( );
         
   } // end getLeftmostData method.
   
   // Implementation of the getRight method.      
   
   public BTNode <E> getRight( ) {
   
      return right;  
                                                   
   } // end getRight method.
   
   // Implementation of the getRightmostData method.
   
   public E getRightmostData( ) {
      
      if ( right == null )
         
         return data;
         
      else
      
         return right.getRightmostData( );
         
   } // end getRightmostData method.
   
   // Implementation of the isLeaf method.
   
   public boolean isLeaf( ){ 
   
      return ( left == null ) && ( right == null );
                                                     
   } // end isLeaf method.
   
   // Implementation of the inorderPrint method.
   
   public void inorderPrint( ) {
   
      if ( left != null )
      
         left.inorderPrint( );
         
      System.out.println( data );
      
      if ( right != null )
      
         right.inorderPrint( );
         
   } // end inorderPrint method. 
   
   // Implementation of the preorderPrint method.
   
   public void preorderPrint( ) {
   
      System.out.println(data);
      
      if ( left != null )
      
         left.preorderPrint( );
         
      if ( right != null )
      
         right.preorderPrint( );
         
   } // end preorderPrint method.
   
   // Implementation of the postorderPrint method.
      
   public void postorderPrint( ) {
      
      if (left != null)
      
         left.postorderPrint( );
         
      if ( right != null )
      
         right.postorderPrint( );
         
      System.out.println( data );
      
   } // end postorderPrint method.  
   
   // Implementation of the print method.
   
   public void print( int depth ) {
      
      int i;
   
      // Print the indentation and the data from the current node.
      
      for ( i = 1; i <= depth; i++ )
      
         System.out.print( "    " );
         
      System.out.println( data );

      // Print the left subtree (or a dash if there is a right child and no left child).  
      
      if ( left != null )
      
         left.print(depth+1);
         
      else if ( right != null ) {
         
         for (i = 1; i <= depth + 1; i++)
            
            System.out.print( "    " );
         
         System.out.println( "--" );
         
      } // end else if.

      // Print the right subtree (or a dash if there is a left child and no left child).  
      
      if ( right != null )
      
         right.print( depth + 1 );
         
      else if ( left != null ) {
         
         for (i = 1; i <= depth + 1; i++ )
            
            System.out.print( "    " );
         
         System.out.println( "--" );
         
      } // end else if.
      
   } // end print method. 
   
   // Implementation of the removeLeftmost method. 

   public BTNode <E> removeLeftmost( ) {
   
      if (left == null)
      
         return right;
         
      else {
      
         left = left.removeLeftmost( );
         
         return this;
         
      } // end else.
      
   } // end removeLeftmost method.
   
   // Implementation of the removeRightmost method.
   
   public BTNode <E> removeRightmost( ) {
      
      if ( right == null )
      
         return left;
         
      else {
      
         right = right.removeRightmost( );
         
         return this;
         
      } // end else.
      
   } // end removeRightmost method.
   
   // Implementation of the setData method.    
   
   public void setData( E newData ) {
   
      data = newData;
      
   } // end setData method.
   
   // Implementation of the setLeft method.                                                     
   
   public void setLeft( BTNode <E> newLeft ) {  
                     
      left = newLeft;
      
   } // end setLeft method.
   
   // Implementation of the setRight method.  
    
   public void setRight( BTNode <E> newRight ) {       
                
      right = newRight;
      
   } // end setRight method.
   
   // Implementation of the treeCopy method.
       
   public static <E> BTNode <E> treeCopy( BTNode <E> source ) {
   
      BTNode <E> leftCopy, rightCopy;

      if ( source == null )
         
         return null;
         
      else {
      
         leftCopy = treeCopy( source.left );
         
         rightCopy = treeCopy( source.right );
         
         return new BTNode <E> ( source.data, leftCopy, rightCopy, source.height );
         
      } // end else.
      
   } // end treeCopy method.
   
   // Implementation of the treeSize method.
   // This method will return the number of nodes in the tree.
   
   public static <E> long treeSize( BTNode <E> root ) {
   
      if ( root == null )
      
         return 0;
         
      else
         
         return 1 + treeSize( root.left ) + treeSize( root.right );
         
   } // end treeSize method.
      
   // Accessor for the height variable.
   
   public int getHeight ( ) {
   
      // Return the variable height.
   
      return height; 
   
   } // end getHeight method.
   
   // Mutator for the height variable.
   
   public void setHeight ( int newHeight ) {
   
      height = newHeight;  
   
   } // end setHeight method.
   
   // Helper function for insertion method.
   
   public static <E> int height ( BTNode <E> node ) {
   
      // If the BTNode is null, then the height is zero (i.e. empty tree).
      // Else return its height.
   
      if ( node == null ) 
      
         return 0;
         
      else
      
         return node.height;
   
   } // end height method.
   
   // Implementation of the generic insert method.
   
   @SuppressWarnings( "unchecked" )
   
   public static <E> BTNode <E> insert ( BTNode <E> node, E newValue ) {
   
      // First deal with normal insertions.
      
      if ( node == null )
      
         return new BTNode <E> ( newValue, null, null, 1 );
         
      if ( ( ( Comparable ) newValue ).compareTo( node.data ) < 0 )
      
         node.left = insert( node.left, newValue );
         
      else if ( ( ( Comparable ) newValue ).compareTo( node.data ) > 0 )
      
         node.right = insert( node.right, newValue );
         
      else 
      
         // Duplicates are not allowed, so return the node.
      
         return node;
         
      // Update the height og this node.
      
      node.height = 1 + Math.max( height( node.left ), height( node.right ) );
      
      // Get the balance factor.
      
      int balance = height( node.left ) - height( node.right );
      
      // There are 4 possible "unbalanced" cases.
      
      // #1 Left Left case
      
      if ( balance > 1 && ( ( Comparable ) newValue ).compareTo( node.left.data ) < 0 )
      
         return rightRotate( node );
         
      // #2 Right Right Case
      
      if ( balance < -1 && ( ( Comparable ) newValue ).compareTo( node.right.data ) > 0 )
      
         return leftRotate( node );
         
      // #3 Left Right Case
      
      if ( balance > 1 && ( ( Comparable ) newValue ).compareTo( node.left.data ) > 0 ) {
      
         node.left = leftRotate( node.left );
         
         return rightRotate( node );     
      
      } // end if.
      
      // #4 Right Left Case
      
      if ( balance < -1 && ( ( Comparable ) newValue ).compareTo( node.right.data ) < 0 ) {
      
         node.right = rightRotate( node.right );
         
         return leftRotate( node );      
      
      } // end if.
      
      // Otherwise, the tree was already balanced, so return the node.
               
      return node;
   
   } // end insert method.
   
   // Implementation of the rightRotate method.
   
   public static <E> BTNode <E> rightRotate ( BTNode <E> y ) {
   
      BTNode <E> x = y.left;
      
      BTNode <E> T2 = x.right;
      
      x.right = y;
      
      y.left = T2;
      
      y.height = Math.max( height( y.left ), height( y.right ) ) + 1;
      
      x.height = Math.max( height( x.left ), height( x.right ) ) + 1;
      
      return x;  
   
   } // end rightRotate method.
   
   // Implementation of the leftRotate method.
   
   public static <E> BTNode <E> leftRotate ( BTNode <E> x ) {
   
      BTNode <E> y = x.right;
      
      BTNode <E> T2 = y.left;
      
      y.left = x;
      
      x.right = T2;
      
      x.height = Math.max( height( x.left ), height( x.right ) ) + 1;
      
      y.height = Math.max( height( y.left ), height( y.right ) ) + 1;
      
      return y;  
   
   } // end rightRotate method.

} // end class.