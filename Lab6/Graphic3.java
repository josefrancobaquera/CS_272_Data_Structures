import java.awt.*;
import javax.swing.*;

public class Graphic3 extends JApplet {

   public static void main (String args[]) {
   
     System.out.println("test");
   }
   
   public void paint(Graphics g) {
	 
	   double t;
		int radius = 50, x, y;

		setSize(600, 600);
		
	   g.setColor(Color.blue);
		
		
	   for (int i = 0; i <= 14200; i++) {
		      
		   t = i * Math.PI * 2 / 2000;
			x = (int) ((Math.cos(t) + 0.5 * Math.cos(7.0 * t) + 1.0 / 3.0 * Math.sin(17.0 * t)) * radius + 300);
			y = (int) ((Math.sin(t) + 0.5 * Math.sin(7.0 * t) + 1.0 / 3.0 * Math.cos(17.0 * t))* radius + 300);
			
			g.fillOval(x, y, 2, 2);
			
	   } // end for
	} // end paint
} // end applet
		