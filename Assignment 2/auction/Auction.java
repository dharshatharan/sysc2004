import java.util.*;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 *
 * @author (of AuctionSkeleton) Lynn Marshall
 * @version 2.0
 * 
 * @author Dharshatharan J. A.
 * @version 1.0
 * 
 */
public class Auction
{
    /** The list of Lots in this auction. */
    private ArrayList<Lot> lots;

    /** 
     * The number that will be given to the next lot entered
     * into this auction.  Every lot gets a new number, even if some lots have
     * been removed.  (For example, if lot number 3 has been deleted, we don't
     * reuse it.)
     */
    private int nextLotNumber;
    
    /**
     * Keeps track if the auction is open or closed
     */
    private boolean auctionOpen;
    
    /**
     * Create a new auction
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
        auctionOpen = true;
    }
    
    /**
     * Create an auction with the unsold items of a previously closed auction
     */
    public Auction(Auction auction){
        if(!auction.auctionOpen){
            lots = new ArrayList<Lot>();
            for(Lot lot : auction.lots){
                 if(lot.getHighestBid() == null){
                     lots.add(lot);
                    }
                    nextLotNumber = lot.getNumber()+1;
                }
                auctionOpen = true;
            }else{
                lots = new ArrayList<Lot>();
                nextLotNumber = 1;
                auctionOpen = true;
            }
        }
                
            
            


    /**
     * Enter a new lot into the auction.  Returns false if the
     * auction is not open or if the description is null.
     *
     * @param description A description of the lot.
     */
    public boolean enterLot(String description)
    {
        if(auctionOpen && description != null){
            lots.add(new Lot(nextLotNumber, description));
            nextLotNumber++;
            return true;
        }
        return false;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        System.out.println("_________________________________________");
        if(nextLotNumber == 1){
            System.out.println("There are no lots in this auction.");
        }else{
            for(Lot lot : lots) {
                System.out.println(lot.toString());
            }
        }
    }
    
    /**
     * Bid for a lot.
     * 
     * Returns false if the auction is closed, the lot doesn't
     * exist, the bidder is null, or the bid was not positive
     * and true otherwise (even if the bid was not high enough).
     *
     * @param lotNumber The lot number being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public boolean bidFor(int lotNumber, Person bidder, long value)
    {
          if(auctionOpen && bidder != null && value > 0){
              for(Lot lot : lots){
                  if(lot.getNumber() == lotNumber){  
                      System.out.print("Bid is successful");
                      return lot.bidFor(new Bid(bidder, value));
                  }
              }
          }
          return false;
    }


    /**
     * Return the lot with the given number. 
     *   
     * Returns null if the lot does not exist.
     *
     * @param lotNumber The number of the lot to return.
     *
     * @return the Lot with the given number
     */
    public Lot getLot(int lotNumber)
    {
        for(Lot lot : lots) {
            if(lot.getNumber() == lotNumber){
                return lot;
            }
        }
        return null; 
    }
    
    /**
     * Closes the auction and prints information on the lots.
     *
     * Returns false if the auction is already closed, true otherwise.
     */
    public boolean close()
    {
        if (auctionOpen){
            auctionOpen = false;
            showLots();
            return true;
        } 
        return false;
    }
    
    /**
     * Returns an ArrayList containing all the items that have no bids so far.
     * (or have not sold if the auction has ended).
     * @return an ArrayList of the Lots which currently have no bids
     */
    public ArrayList<Lot> getNoBids()
    {
        ArrayList<Lot> noBidLots = new ArrayList<Lot>();
        for(Lot lot : lots){
            if(lot.getHighestBid() == null){
                noBidLots.add(lot);
            }
        }
        return noBidLots;
    }
    
    /**
     * Remove the lot with the given lot number, as long as the lot has
     * no bids, and the auction is open.  
     *
     * Returns true if successful, false otherwise (auction closed,
     * lot does not exist, or lot has a bid).
     *
     * @param number The number of the lot to be removed.
     */
    public boolean removeLot(int number)
    {
        for(Lot lot : getNoBids()){
            if(lot.getNumber() == number && auctionOpen ){
                lots.remove(lot);
                return true;
            }
        }
        return false;
                
    }
          
}