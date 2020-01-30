// CS 272 
// Program Name: Tile.java
// Author: Jose Franco Baquera
// Date: September 14, 2017
// Purpose: The purpose of the program is to 
// make Tile objects. A single Tile object 
// will have two instance variables.

public class Tile implements Cloneable {

  // Declare instance variables.
  
  private int colorOfTile;
  
  private int shapeOfTile;
    
  // Implementation of the constructor.
  
  public Tile ( int color, int shape ) {
  
     // Make sure that both arguments are 
     // integers from 1 to 6 ( inclusive).
     
     if ( color < 1 || color > 6 || shape < 1 || shape > 6 ) 
     
        throw new IllegalArgumentException ( "Both arguments must be integers " 
        
           + "between 1 and 6 (inclusive)." );
  
     // Inizialize the instance variables 
     // with the given parameters of 
     // the constructor. 
     
     colorOfTile = color;
     
     shapeOfTile = shape;  
  
  } // end Tile method 
  
  // Implementation of first accesor.
  
  public int getColor ( ) {
  
     // Return the color of the tile.
  
     return colorOfTile;
      
  } // end getColor method.
  
  // Implementation of second accesor.
  
  public int getShape ( ) {
  
     // Return the shape of the tile.
     
     return shapeOfTile;  
  
  } // end getShape method.
  
  // Implementation of first mutator.
  
  public void setColor ( int color ) {
  
     // Check that argument is between 1 and 6 (inclusive).
  
     if ( color < 1 || color > 6 ) 
     
        throw new IllegalArgumentException ( "Invalid color. Argument must be between 1 and 6 (inclusive)." ); 
  
     // Set the color instance variable.
  
     colorOfTile = color;  
  
  } // end setColor method.
  
  // Implementation of second mutator.
  
  public void setShape ( int shape ) {
  
     // Check that argument is between 1 and 6 (inclusive).
     
     if ( shape < 1 || shape > 6 )
     
        throw new IllegalArgumentException ( "Invalid shape. Argument must be between 1 and 6 (inclusive)." );
  
     // Set the shape instance variable.
     
     shapeOfTile = shape; 
  
  } // end setShape method.
  
  // Implementation of toString method.
  
  public String toString ( ) {
  
     // Make a String result.
     
     String result = "";
     
     // Check if the Tile has an acceptable color and shape.
     
     if ( colorOfTile < 1 || colorOfTile > 6 || shapeOfTile < 1 || shapeOfTile > 6 ) {
     
        result = "unknown " + colorOfTile + " and " + shapeOfTile;
        
        return result;
    
     } // end if
  
     // Use two String arrays to make priting easier.
  
     String colorName [ ] = { "orange", "green", "yellow", "red", "blue", "purple" };
     
     String shapeName [ ] = { "four-pointed star", "clover", "eight-pointed star", "diamond", "square", "circle" };
     
     // Concatinate the result String.
     
     result = colorName [ colorOfTile - 1 ] + " " + shapeName [ shapeOfTile - 1 ];
     
     // Return a String.

     return result;  

  } // end toString method.
  
  // Implementation of compare one tile to  another for equality.
  
  public boolean equals ( Object obj ) {
  
     // Check if object is a Tile object. If not, return
     // false.
         
     if ( obj instanceof Tile ) {
     
        // Caste the object parameter into a Tile object
        // and inizialize a Tile object. 
     
        Tile candidate = ( Tile ) obj;
        
        // Check if both instance variables are equal. If they are,
        // return true, else false. 
        
        return ( candidate.colorOfTile == colorOfTile ) && ( candidate.shapeOfTile == shapeOfTile );
        
      } // end if statement.
              
      else {
      
         return false;
      
      } // end else statement.
        
  } // end equals method.
  
  // Implementation of cloneable method.
  
  public Tile clone ( ) {  
     
     Tile answer;
     
     // Try the super.clone ( ) method. Catch the exception.
     
     try { 
     
        answer = ( Tile ) super.clone ( );
        
      } // end try
      
      catch ( CloneNotSupportedException e ) {
      
         throw new RuntimeException ( "This class does not implement Cloneable." );      
      
      } // end catch
      
      // Return the new clone of the object.
      
      return answer;
  
  } // end clone method.
 
} // end Tile Class