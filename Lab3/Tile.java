// Tile.java - represents a Qwirkle Tile
// Written by Esther Steiner
// CS 272
// 09-24-2017

public class Tile implements Cloneable {

   // instance variables
   private int color;
   private int shape;
   
   // Behavior #1: constructor
   public Tile ( int c, int s ) {

      // if invalid parameter values, default to 1
        
      if (c >= 1 && c <= 6)
         color = c;
      else
         color = 1;

      if (s >= 1 && s <= 6)
         shape = s;
      else 
         shape = 1;
   } // end constructor
   
   // Behavior #2 : accessor for color
   public int getColor( ) {
      return color;
   }
   
   // Behavior #3 : accessor for shape
   public int getShape( ) {
      return shape;
   }
   
   // Behavior #4 : mutator for color
   public void setColor( int c ) {

      // doesn't change color if c is invalid
      if ( c >= 1 && c <= 6 )
         color = c;
   }
   
   // Behavior #5 : mutator for shape
   public void setShape( int s ) {

      // doesn't change shape if s is invalid
      if ( s >= 1 && s <= 6 )
         shape = s;
   }

   // Behavior #6 : String representation of a Tile
   public String toString( ) {
   
      String colorNames[] = {"orange", "green", "yellow", "red", "blue", "purple"};
      String shapeNames[] = {"four-pointed star", "clover", "eight-pointed star",
                              "diamond", "square", "circle"};
      if (color < 1 || color > 6 || shape < 1 || shape > 6)
         return "unknown";
      
      return colorNames[color-1] + " " + shapeNames[shape-1];
   }
   
   // Behavior # 7 : compare two tiles
   public boolean equals (Tile other) {
    
      return shape == other.shape && color == other.color;
   }
   
   // Behavior #8 : clone a tile
   public Tile clone( ) {
      Tile answer;
      try {
         answer = (Tile) super.clone();
      }
      catch (CloneNotSupportedException e) {
         throw new RuntimeException
         ("This class doesn't support Cloneable.");
      }
      return answer;
   }
} // end Tile Class
   
   
      
    