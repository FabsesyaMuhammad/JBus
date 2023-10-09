package FabsesyaMuhammadJBusAF;

import java.sql.Timestamp;

public class Invoice extends Serializable
{
    public Timestamp time;
    public int buyerId; 
    public int renterId;
    public BusRating rating;
    public PaymentStatus status;
    
    protected Invoice( int buyerId, int renterId){
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = new Timestamp(System.currentTimeMillis());
        this.rating = BusRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    public Invoice( Account buyer, Renter renter){
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = new Timestamp(System.currentTimeMillis());
        this.rating = BusRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    public String toString(){
        String println = "\nInvoice" + "\nId  : " + id + "\nBuyer Id : " + buyerId + "\nRenter Id : " + renterId + "\nTime : " + time.getTime() + "Bus Rating : " + rating + "Payment Status : " + status;
        return println;
    }
    public enum BusRating{
        NONE, NEUTRAL, GOOD, BAD;
    }
    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS;
    }
    
}
