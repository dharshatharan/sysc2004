/**
 * Seat models a seat in a car in a passenger train.
 *
 * @author Lynn Marshall, SCE
 * @version 1.1 September 23, 2012
 */
public class Seat
{
    private int number;     // the seat's number
    private boolean booked; // has this seat been reserved?
    private double price;   // the cost of a ticket for this seat, in dollars

    /**
     * Constructs a new Seat with the specified seat number and
     * ticket price.
     * 
     * @param seatNo The number of the seat.
     * @param cost The cost of a ticket for this seat, in dollars.
     */
    public Seat(int seatNo, double cost)
    {
        booked = false;
        number = seatNo;
        price = cost;
    }

    /**
     * Returns the cost of purchasing a ticket for this Seat.
     * 
     * @return Cost of purchasing a ticket for this seat, in dollars.
     */
    public double price()
    {
        return price;
    }

    /**
     * Returns this seat's number.
     * 
     * @return The number of this seat.
     */
    public int number()
    {
        return number;
    }

    /**
     * Returns true if someone has purchased a ticket
     * for this this Seat.
     * 
     * @return True if the seat has been booked, false otherwise.
     */
    public boolean isBooked()
    {
        return booked;
    }

    /**
     * If this seat is available, books it and returns true.
     * If the seat is not available, returns false.
     * 
     * @return True if the seat was available and has been booked, 
     *         false otherwise.
     */
    public boolean book() 
    {
        if (!booked) {
            booked = true;
            return true;
        }
        return false;
    }

    /**
     * If this seat is booked, cancels the booking and returns true.
     * If the seat was not booked, returns false.
     * 
     * @return True if the booking has been cancelled, false otherwise
     *         (the seat was not booked).
     */
    public boolean cancelBooking() 
    {
        if (booked) {
            booked = false;
            return true;
        }
        return false;
    }
}
