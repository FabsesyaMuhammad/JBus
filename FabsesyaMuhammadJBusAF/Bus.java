package FabsesyaMuhammadJBusAF;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.*;

public class Bus extends Serializable implements FileParser{
    public int capacity;
    public Facility facility;
    public String name;
    public Price price;
    public BusType busType;
    public City city;
    public Station departure;
    public Station arrival;
    public List<Schedule> schedules;
    
    public Bus(int id, String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival){
        super(id);
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
    public void addSchedule(Calendar calendar){
        Schedule schedule = new Schedule(calendar, capacity);
        schedules.add(schedule);
    }
    public void printSchedule(Schedule schedule){
        SimpleDateFormat format
            = new SimpleDateFormat ("'Tanggal keberangkatan: 'MMMM dd, yyyy HH:mm:ss");
        
        System.out.println(format.format(schedule.departureSchedule.getTime()));
        System.out.println(schedule.seatAvailability);
        
    }
    public String toString(){
        String println = "\nBus" + "\nId  : " + id + "\nName : " + name + "\nFacility : " + facility + "" + price + "\nCapacity : " + capacity + "\nBus Type : " + busType + "\nCity : " + city + "\nDeparture : " + departure + "\nArrival : " + arrival;
        return println;
    }
    public boolean read(String obj){
        return false;        
    }
    public Object write(){
        return null;
    }
}

