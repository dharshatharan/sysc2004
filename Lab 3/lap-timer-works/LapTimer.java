/**
 * The main class of a lap timer application. Create one of these and you'll
 * get the lap timer on screen.
 * 
 * @author Michael Kolling
 * @version 20 Spetember 2004
 */
public class LapTimer
{
    private TimingEngine engine;
    private UserInterface gui;

    /**
     * Create a new lap timer and show it.
     */
    public LapTimer()
    {
        engine = new TimingEngine();
        gui = new UserInterface(engine);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }
}
