import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A graphical user interface for the lap timer. No calculation is being
 * done here. This class is responsible just for putting up the display on 
 * screen. It then refers to the "TimingEngine" to do all the real work.
 * 
 * @author Michael Kolling
 * @version 20 September 2004.
 * @author D.L. Bailey
 * @version edits by dlb - January 21, 2007
 */
public class UserInterface
{
    private TimingEngine timer;

    private JFrame frame;
    private JLabel status;
    private JLabel lapCountLabel;
    private JLabel lastTimeLabel;
    private JLabel avgTimeLabel;
    private JLabel totalTimeLabel;
    private JLabel avgSpeedLabel;
    private Font largeFont;
    private JButton startButton;
    private JLabel lengthLabel;
    private JTextField lengthField;

    /**
     * Create a user interface for a given calcEngine.
     */
    public UserInterface(TimingEngine engine)
    {
        timer = engine;
        makeFrame();
        updateDisplay();
        frame.setVisible(true);
    }


    /**
     * Make this interface visible again. (Has no effect if it is already
     * visible.)
     */
    public void setVisible(boolean visible)
    {
        frame.setVisible(visible);
    }
    

    /**
     * The 'Start/Next' button has been pressed. Start a lap time.
     */
    private void startTiming()
    {
        timer.startLap();
        startButton.setText("Next lap");
        updateDisplay();
    }
    
    
    /**
     * The 'Stop' button has been pressed. Stop the lap timing.
     */
    private void stopTiming()
    {
        timer.stop();
        startButton.setText("Start");
        updateDisplay();
    }
    
    
    /**
     * The "Set length" button has been pressed. Read the text filed
     * and, if it contains a sensible value, set this as the new lap
     * length.
     */
    private void setLapLength()
    {
        String length = lengthField.getText();
        try {
            int newLength = Integer.parseInt(length);
            timer.setLapLength(newLength);
            updateDisplay();
        }
        catch(NumberFormatException exc) {
            lengthField.setText("");
        }
    }
    
    
    /**
     * Update the current display to correctly show all timer details.
     */
    private void updateDisplay()
    {
        status.setText(timer.getStatus());
        lapCountLabel.setText(Integer.toString(timer.getLapCount()));
        lastTimeLabel.setText(timer.getLastTime());
        avgTimeLabel.setText(timer.getAverageTime());
        totalTimeLabel.setText(timer.getTotalTime());
        avgSpeedLabel.setText(timer.getAverageSpeed());
        lengthLabel.setText(timer.getLapLength() + "m");
    }

    /**
     * Make the frame for the user interface.
     */
    private void makeFrame()
    {
        frame = new JFrame("SCE Lap Timer");
        
        // prepare the main content pane
        
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        status = new JLabel(timer.getStatus());
        contentPane.add(status, BorderLayout.NORTH);
        largeFont = status.getFont().deriveFont(24.0f);
        status.setFont(largeFont);
        status.setForeground(new Color(128, 16, 16));

        // create the main display in the center with all the data labels
        
        JPanel mainDisplay = new JPanel(new GridLayout(0,2, 10, 10));
        mainDisplay.setBackground(Color.WHITE);
        mainDisplay.setFont(largeFont);
        mainDisplay.setBorder(BorderFactory.createCompoundBorder(
                                new EtchedBorder(),
                                new EmptyBorder(10, 10, 10, 10)));
        
        addLabel(mainDisplay, "Number of laps:");
        lapCountLabel = addLabel(mainDisplay, "0");
        
        addLabel(mainDisplay, "Last lap time:");
        lastTimeLabel = addLabel(mainDisplay, "0");
        
        addLabel(mainDisplay, "Average lap time:");
        avgTimeLabel = addLabel(mainDisplay, "0");
        
        addLabel(mainDisplay, "Total time:");
        totalTimeLabel = addLabel(mainDisplay, "0");
        
        addLabel(mainDisplay, "Average speed:");
        avgSpeedLabel = addLabel(mainDisplay, "0");
        
        contentPane.add(mainDisplay, BorderLayout.CENTER);
        
        // create the panel with the lap length label and entry
        
        JPanel lengthPanel = new JPanel(new GridLayout(0, 1));
        lengthPanel.setBorder(BorderFactory.createCompoundBorder(
                                new EtchedBorder(),
                                new EmptyBorder(10, 10, 10, 10)));
        lengthPanel.add(new JLabel("Lap length:"));
        lengthLabel = new JLabel();
        lengthPanel.add(lengthLabel);
        lengthField = new JTextField(8);
        lengthPanel.add(lengthField);
        JButton setButton = new JButton("Set length");
        setButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            setLapLength();
                        }
                    });
        lengthPanel.add(setButton);

        JPanel flow = new JPanel();
        flow.add(lengthPanel);
        contentPane.add(flow, BorderLayout.EAST);

        // create the panel with the two buttons at the bottom
        
        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            startTiming();
                        }
                    });
        buttonPanel.add(startButton);

        JButton button = new JButton("Stop");
        button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            stopTiming();
                        }
                    });
        buttonPanel.add(button);
        
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.pack();
    }

    /**
     * Add a label to the main display panel.
     */
    private JLabel addLabel(Container panel, String text)
    {
        JLabel label = new JLabel(text);
        label.setFont(largeFont);
        panel.add(label);
        return label;
    }
}
