package com.FabsesyaMuhammadJBusAF;

import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import com.FabsesyaMuhammadJBusAF.dbjson.*;
import java.text.*;

public class Bus extends Serializable
{
    public int capacity;
    public Facility facility;
    public String name;
    public Price price;
    public BusType busType;
    public City city;
    public Station departure;
    public Station arrival;
    public List<Schedule> schedules;
    
    public Bus(/*int id,*/ String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival){
        super();
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.capacity = capacity;
        this.busType = busType;
        this.city = city;
        this.departure = departure;
        this.arrival = arrival;
        this.schedules = new ArrayList<>();
    }   
    public void addSchedule(Timestamp calendar){
        boolean duplicate = false;
        Schedule schedule = new Schedule(calendar, capacity);
        for (Schedule exist : schedules) {
            if (exist.departureSchedule.equals(schedule.departureSchedule)) {
                duplicate = true;
            }
        }

        if (!duplicate) {
            schedules.add(schedule);
        }
    }
    /*public void printSchedule(Schedule schedule){
        SimpleDateFormat format
            = new SimpleDateFormat ("'Tanggal keberangkatan: 'MMMM dd, yyyy HH:mm:ss");
        
        System.out.println(format.format(schedule.departureSchedule.getTime()));
        System.out.println("Daftar Kursi dan Ketersediaan Kursi : ");
         
        int maxSeatsPerRow = 4;
        int currentSeat = 1;
        
        for(String seat : schedule.seatAvailability.keySet()){
            System.out.print(seat + " : " + schedule.seatAvailability.get(seat) + "\t");
            
            if(currentSeat % maxSeatsPerRow == 0){
                System.out.println();
            }
            currentSeat++;
        }
        
    }*/
    public String toString(){
        String println = "Id  : " + id + "\tName : " + name + "\tFacility : " + facility + "\t" + price + "\tCapacity : " + capacity + "\tBus Type : " + busType + "\tCity : " + city + "\tDeparture : " + departure + "\tArrival : " + arrival;
        return println;
    }
    public boolean read(String obj){
        return false;        
    }
    public Object write(){
        return null;
    }
}

