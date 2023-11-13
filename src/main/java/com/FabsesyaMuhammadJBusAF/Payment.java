package com.FabsesyaMuhammadJBusAF;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Payment extends Invoice
{
    private int busId;
    public Timestamp departureDate;
    public List<String> busSeats;
    
    public Payment( int buyerId, int renterId, int busId, String busSeat, Timestamp departureDate){
        super(buyerId,renterId);
        this.busId = busId;
        this.departureDate = new Timestamp(System.currentTimeMillis());
        this.busSeats = new ArrayList<>();
        /*departureDate.add(Calendar.DATE, 2);*/
    }
    public Payment( Account buyer, Renter renter, int busId, String busSeat,Timestamp departureDate ){
        super( buyer, renter);
        this.busId = busId;
        this.departureDate = new Timestamp(System.currentTimeMillis());
        this.busSeats = new ArrayList<>();
        /*departureDate.add(Calendar.DATE, 2);*/
    }
    /*public String toString(){
        String println = "\nPayment" + "\nId  : " + id + "\nBuyer ID : " + buyerId + "Renter ID : " + renterId + "\nBus ID : "+ String.valueOf(busId) + "\nDeparture Date : " + departureDate + "\nBus Seat : " +busSeat;
        return println;
    }*/
    /*public static boolean isAvailable(Timestamp departureSchedule, String seat, Bus bus){
        for(Schedule x : bus.schedules){
            if (x.departureSchedule.equals(departureSchedule) && x.isSeatAvailable(seat)){
                return true;
            }
        }
        return false;
    }*/
    public static Schedule availableSchedule(Timestamp departureSchedule, String seat, Bus bus){
        for(Schedule x : bus.schedules){
            if (x.departureSchedule.equals(departureSchedule)){
                if(x.isSeatAvailable(seat)) {
                    return x;
                }
            }
        }
        return null;
    }
    public static Schedule availableSchedule(Timestamp departureSchedule, List<String> seat, Bus bus){
        int cnt = 0;
        for(Schedule x : bus.schedules){
            for(int i=0; i<seat.size(); i++){
                if (x.departureSchedule.equals(departureSchedule) && x.isSeatAvailable(seat.get(i))){
                    cnt++;
                }

            }
            if(cnt==seat.size()){
                return x;
            }

        }
        return null;
    }

    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus){
        for(Schedule x : bus.schedules){
            if (x.departureSchedule.equals(departureSchedule) && x.isSeatAvailable(seat)){

                x.bookSeat(seat);
                return true;
            }
        }
        return false;
    }

    public static boolean makeBooking(Timestamp departureSchedule, List<String> seat, Bus bus){
        for(Schedule x : bus.schedules){
            if (x.departureSchedule.equals(departureSchedule)){
                for(int i=0; i<seat.size(); i++){
                    x.bookSeat(seat.get(i));
                }
                return true;
            }

        }
        return false;
    }
    public int getBusId(){
        return busId;
    }
    public String getDepartureInfo(){
        SimpleDateFormat format
            = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        String println = "\nPayment Id: " + id + " Buyer Id: " + buyerId + " Renter Id: " + renterId + " bus ID : "+ String.valueOf(busId) + " Departure Date : " + format.format(this.departureDate.getTime()) + " Bus Seat : " +busSeats;
        return println;     
    }
    
    public String getTime(){
        SimpleDateFormat format
            = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss'\n'");
        
        return format.format(super.time.getTime());
    }

}
