import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A class modelling a tic-tac-toe (noughts and crosses, Xs and Os) game in a very
 * simple GUI window.
 * 
 * @author Lynn Marshall
 * @version November 8, 2012
 */

public class TicTacToeFrame extends TicTacToe 
{ 
   private JTextArea status; // text area to print game status
   
   /** 
    * Constructs a new Tic-Tac-Toe board and sets up the basic
    * JFrame containing a JTextArea in a JScrollPane GUI.
    */
   public TicTacToeFrame()
   { 
       JFrame frame = new JFrame("TicTacToe");
       frame.setSize(250, 250);
       
       
       status = new JTextArea(20, 50);
       status.setEditable(false);
       
       JScrollPane scroll = new JScrollPane(status);
       
       frame.add(scroll);
       frame.setVisible(true);
       frame.pack();
   }
   
   /**
    * Prints the board to the GUI using toString().
    */
    public void print() 
    {  
        status.setText(toString());
    }

}