package FabsesyaMuhammadJBusAF;

import java.util.Calendar;
import java.text.*;
public class Payment extends Invoice
{
    private int busId;
    public Calendar departureDate;
    public String busSeat;
    
    public Payment(int id, int buyerId, int renterId, int busId, String busSeat){
        super(id,buyerId,renterId);
        this.busId = busId;
        this.departureDate = Calendar.getInstance();
        this.busSeat = busSeat;
        departureDate.add(Calendar.DATE, 2);
    }
    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat){
        super(id, buyer, renter);
        this.busId = busId;
        this.departureDate = Calendar.getInstance();
        this.busSeat = busSeat;
        departureDate.add(Calendar.DATE, 2);
    }
    /*public String toString(){
        String println = "\nPayment" + "\nId  : " + id + "\nBuyer ID : " + buyerId + "Renter ID : " + renterId + "\nBus ID : "+ String.valueOf(busId) + "\nDeparture Date : " + departureDate + "\nBus Seat : " +busSeat;
        return println;
    }*/
    public int getBusId(){
        return busId;
    }
    public String getDepartureInfo(){
        SimpleDateFormat format
            = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        String println = "\nPayment Id: " + id + " Buyer Id: " + buyerId + " Renter Id: " + renterId + " bus ID : "+ String.valueOf(busId) + " Departure Date : " + format.format(this.departureDate.getTime()) + " Bus Seat : " +busSeat;
        return println;     
    }
    
    public String getTime(){
        SimpleDateFormat format
            = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss'\n'");
        
        return format.format(super.time.getTime());
    } 
}
