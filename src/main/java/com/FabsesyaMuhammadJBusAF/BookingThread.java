package com.FabsesyaMuhammadJBusAF;

import java.sql.Timestamp;
public class BookingThread extends Thread{
    private Bus bus;
    private Timestamp timestamp ;
    public BookingThread(String name, Bus bus, Timestamp timestamp){
        super(name);
        this.bus = bus;
        this.timestamp = timestamp;
        this.start();
    }
    public void run(){
        for(Schedule sch :bus.schedules){
            if(sch.departureSchedule.equals(timestamp)){
                System.out.println(super.getName() + " ID : " + super.getId() +" is running");

            }
        }
        for(Schedule sch :bus.schedules){
            if(sch.departureSchedule.equals(timestamp)){

                String hasil = Payment.makeBooking(timestamp, "AF01", bus) ? "Berhasil" : "Gagal";
                System.out.println(super.getName() + " ID : " + super.getId() + " " + hasil);
            }
        }

    }
}
