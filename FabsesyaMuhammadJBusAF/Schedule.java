package FabsesyaMuhammadJBusAF;

import java.util.Calendar;
import java.util.Map;
import java.util.LinkedHashMap;

public class Schedule
{
    public Calendar departureSchedule;
    public Map<String, Boolean> seatAvailability;
    
    public Schedule(Calendar departureSchedule, int numberOfSeats){
        this.departureSchedule = Calendar.getInstance();
        initializeSeatAvailability(numberOfSeats);
    }
    
    private void initializeSeatAvailability(int numberOfSeats){
        seatAvailability = new LinkedHashMap<>();
        for(int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++){
            seatAvailability.put("AF" + seatNumber, true);
        }
    }   
}
