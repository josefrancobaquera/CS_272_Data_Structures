public class QwirkleTester {

   public static void main (String args[]) {
   

      QwirkleBag game1 = new QwirkleBag();
      //System.out.println("I created a new QwirkleBag.  Here's what's in it:\n");
      //System.out.println(game1);
      
      for (int i = 1; i <= 100; i++)
         game1.draw();
         
      System.out.println("I drew 100 tiles from the bag. Here's what's left in it:\n");
      System.out.println(game1);
      
      System.out.println("The bag now contains " + game1.size() + " tiles.");
      
      System.out.println("Adding a red clover to the bag...");
      game1.add(new Tile(4, 2));
      System.out.println(game1);
      
      System.out.println("The bag now contains " + game1.size() + " tiles.");
      
            
   } // end main
} // end class