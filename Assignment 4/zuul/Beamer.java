
/**
 * Write a description of class Beamer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Beamer extends Item
{
    private boolean isCharged;
    
    private Room roomCharged;
    /**
     * Constructor for objects of class Beamer
     */
    public Beamer(String name, String description, double weight)
    {
        super(name, description, weight);
        isCharged = false;
        roomCharged = null;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getDescription()
    {
        return super.getDescription();
    }
    
    public String getName()
    {
        return super.getName();
    }
    
    public boolean isCharged(){
        return isCharged;
    }
    
    public void charge(Room currentRoom){
        if(!isCharged){
            roomCharged = currentRoom;
            isCharged = true;
            System.out.println("Beamer has been charged");
        }else{
            System.out.println("Beamer is already Charged");
        }
    }
    
    public Room fire(){
        if(isCharged){
            System.out.println("Beamer has been fired");
            isCharged = false;
            return roomCharged;
        }else{
            System.out.println("Beamer is not charged");
            return null;
        }
    }
}
