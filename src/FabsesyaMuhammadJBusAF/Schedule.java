package FabsesyaMuhammadJBusAF;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.text.*;

public class Schedule
{
    public Timestamp departureSchedule;
    public Map<String, Boolean> seatAvailability;
    
    public Schedule(Timestamp departureSchedule, int numberOfSeats){
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }
    
    private void initializeSeatAvailability(int numberOfSeats){
        seatAvailability = new LinkedHashMap<>();
        for(int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++){
            String sn = seatNumber < 10 ? "0"+seatNumber : ""+seatNumber;
            seatAvailability.put("AF" + sn, true);
        }
    }   
    public void printSchedule(){
        SimpleDateFormat dateFormat
            = new SimpleDateFormat ("MMMM d, yyyy HH:mm:ss");
            
        String formattedDepartureSchedule =
            dateFormat.format(this.departureSchedule.getTime());
        System.out.println("Tanggal keberangkatan: " + formattedDepartureSchedule);
        System.out.println("Daftar Kursi dan Ketersediaan Kursi : ");
         
        int maxSeatsPerRow = 4;
        int currentSeat = 1;
        
        for (String seat : this.seatAvailability.keySet()) {
            String symbol = this.seatAvailability.get(seat)? "O" : "X";
            System.out.print(seat + " : " + symbol + "\t");
            if (currentSeat % maxSeatsPerRow == 0) {
                System.out.println();
            }
            currentSeat++;
        }
        System.out.println("\n");
        
    }
    public boolean isSeatAvailable(String seat){
        if(seatAvailability.containsKey(seat)){
            return seatAvailability.get(seat);  
        }
        return false;   
    }
    public boolean isSeatAvailable(List<String> seat){
        for(int i = 0; i< seat.size(); i++){
            if(seatAvailability.containsKey(seat.get(i))){
                return seatAvailability.get(seat.get(i));
            }
        }
        return false;
    }
    public void bookSeat(String seat){
        seatAvailability.put(seat, false);
    }
    public void bookSeat(List<String> seat){
        for(String i : seat) {
            seatAvailability.put(i, false);
        }
    }

    @Override
    public String toString(){

        int occupy = Algorithm.count(seatAvailability.values().iterator(), true);
        return "Schedule\t: " + departureSchedule + "\nOccupied\t: " + occupy + "/" + seatAvailability.size();
    }
}
