import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class TicTacToeGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicTacToeGUI extends TicTacToe
{
    // instance variables - replace the example below with your own
    private int x;
    private JButton buttons[][];

    /**
     * Constructor for objects of class TicTacToeGUI
     */
    public TicTacToeGUI()
    {
       JFrame frame = new JFrame("TicTacToe");
       frame.setSize(250, 250);
       
       JPanel panel = new JPanel();
       
       for(int i=0; i<3; i++){
           for(int j=0; j<3; j++){
               buttons[i][j] = new JButton();
               panel.add(buttons[i][j]);
               buttons[i][j].addActionListener(this);
            }
        }
        
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void print()
    {
        status.setText(toString());
    }
}
