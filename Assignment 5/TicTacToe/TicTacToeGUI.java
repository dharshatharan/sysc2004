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
    private JButton buttons[][] = new JButton[3][3];
    private JTextArea status;

    /**
     * Constructor for objects of class TicTacToeGUI
     */
    public TicTacToeGUI()
    {
       JFrame frame = new JFrame("TicTacToe");
       frame.setSize(250, 250);
       
       JPanel panel = new JPanel(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
       c.fill = GridBagConstraints.HORIZONTAL;
       c.fill = GridBagConstraints.VERTICAL;
       c.weightx = 0.5;
       c.insets = new Insets(0,0,0,0);
       
       for(int i=0; i<3; i++){
           for(int j=0; j<3; j++){
               final int indexi = i;
               final int indexj = j;
               buttons[i][j] = new JButton();
               buttons[i][j].setMargin(new Insets(0,0,0,0));
               buttons[i][j].addActionListener(new ActionListener()
               {
                   public void actionPerformed(ActionEvent e){
                       performAction(indexi, indexj);
                    }
                });
                c.gridx = i;
                c.gridy = j;
                panel.add(buttons[i][j], c);
            }
        }
        
        status = new JTextArea(20, 50);
        status.setEditable(false);
        
        c.gridy = 3;
        c.gridx = 0;
        c.gridwidth = 3;
        c.ipady = 40;
        panel.add(status, c);
        
        clearBoard();
        
        
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
    
    public void performAction(int i, int j){
        if(winner != EMPTY){
            buttons[i][j].setText(board[i][j]);
            playGame(i, j);
        }else{
            
        }
        print();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void print()
    {
        StringBuilder s = new StringBuilder();
        s.append("\nIt is " + player + " chance to play\n");
        if(winner != EMPTY){
            s.append("\n" + winner + " is the winner");
        }
        status.setText(s.toString());
    }
}
