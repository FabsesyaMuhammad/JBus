package FabsesyaMuhammadJBusAF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
public class JBus{
    public static void main(String[] args){

        //TP Modul 6

        String filepath = "C:\\Users\\asus\\Downloads\\OOP\\JBus\\data\\station.json";
        Gson gson = new Gson();

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(filepath));
            List<Station> stationjson = gson.fromJson(buffer, new TypeToken<List<Station>>() {}.getType());
            stationjson.forEach(e -> System.out.println(e.toString()));
            System.out.println();
            buffer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
/*
import java.util.*;
import java.text.*;
import java.sql.Timestamp;
public class JBus {
    public static void main(String[] args) {
        // PT Modul 5
        // Tes Pagination
        Bus b = createBus();
        List<Timestamp> listOfSchedules = new ArrayList<>();
        listOfSchedules.add(Timestamp.valueOf("2023-7-18 15:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-20 12:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-22 10:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-26 12:00:00"));

        listOfSchedules.forEach(b::addSchedule);
        System.out.println("Page 1");
        Algorithm.paginate(b.schedules, 0, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");
        System.out.println("Page 2");
        Algorithm.paginate(b.schedules, 1, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");

        // Tes Booking
        String msgSuccess = "Booking Success!";
        String msgFailed = "Booking Failed";
        // valid date, invalid seat = Booking Failed
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("\nMake booking at July 19, 2023 15:00:00 Seats: AF17 AF18");
        System.out.println(Payment.makeBooking(t1, List.of("AF17", "AF18"), b)? msgSuccess : msgFailed);
        // valid date, invalid seat = Booking Failed
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("Make booking at July 18, 2023 15:00:00 Seat AF26");
        System.out.println(Payment.makeBooking(t2, "AF26", b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        System.out.println("Make booking at July 18, 2023 15:00:00 Seats: S7 S8");
        System.out.println(Payment.makeBooking(t2, List.of("AF7", "AF8"), b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("Make booking at July 20, 2023 12:00:00 Seats: AF1 AF2");
        System.out.println(Payment.makeBooking(t3, List.of("AF1", "AF2"), b)? msgSuccess : msgFailed);
        // valid date, book the same seat = Booking Failed
        System.out.println("Make booking at July 20, 2023 12:00:00 Seat S1");
        System.out.println(Payment.makeBooking(t3, "AF1", b)? msgSuccess : msgFailed);
        // check if the data changed
        System.out.println("\nUpdated Schedule");
        Algorithm.paginate(b.schedules, 0, 4, t-> true).forEach(System.out::println);
    }

    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus("Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station("Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station("Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
}*/
/*public class JBus
{   /*
    public static void main(String[] args){
        Bus testBus = createBus();
        System.out.println(testBus.name);
        System.out.println(testBus.facility);
        System.out.println(testBus.price.price);
        System.out.println(testBus.capacity);
    } */
    /*public static void main(String[] args){
        Review testReview = new Review(1, "23 August 2023", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Station testDeparture = new Station(2, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya");
        Station testArrival = new Station(3, "Halte UI", City.JAKARTA, "Universitas Indonesia");
        Bus testBus = new Bus(1, "Busway", Facility.AC, testPrice, 50, BusType.REGULER, City.DEPOK, testDeparture, testArrival);
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "Bob");
        Rating testRating = new Rating();
        
        System.out.println(testReview);   
        System.out.println(testBus);
        System.out.println(testAccount);   
        System.out.println(testPrice);
        System.out.println(testRating);
    }*/
    /*public static void main(String[] args){
        Integer[] numbers = {18, 10, 22, 43, 18, 67, 12, 11, 88, 22, 18};
        System.out.println("Number "+Arrays.toString(numbers));

        // Tes Algorithm
        System.out.print("1. ");
        testCount(numbers);
        System.out.print("2. ");
        testFind(numbers);
        System.out.print("3. ");
        testExist(numbers);
        System.out.println("4. Filtering");
        testCollect(numbers);*/
        /*Integer[] numbers = {10, 20, 30, 40, 50};
        int valueToCheck = 30;

        boolean result = Algorithm.exists(numbers, valueToCheck);
        if(result){
            System.out.println(valueToCheck + " terdapat dalam array");
        } else System.out.println(valueToCheck + " tidak terdapat dalam array");*/
        /*Price price = new Price(1000);
        Station station = new Station(1, "Stasiun UI", City.DEPOK, "Jl. UI");
        Station Cawang = new Station(1, "Stasiun Cawang", City.JAKARTA, "Jl. Cawang");
        Bus bus1 = new Bus( "UI", Facility.LUNCH, price, 1000, BusType.DOUBLE_DECKER, City.DEPOK, station, Cawang);
        Serializable.setLastAssignedId(Bus.class, 10);
        Bus bus2 = new Bus("UI", Facility.LUNCH, price, 1000, BusType.DOUBLE_DECKER, City.DEPOK, station, Cawang);
        Bus bus3 = new Bus("UI", Facility.LUNCH, price, 1000, BusType.DOUBLE_DECKER, City.DEPOK, station, Cawang);

        System.out.println(station);
        System.out.println(Cawang);
        System.out.println(bus1);
        System.out.println(bus2);
        System.out.println(bus3);*/

        //System.out.println("Hello from IntelliJ!");
        /*Bus b = createBus();
        Timestamp schedule1 = Timestamp.valueOf("2023-7-18 15:00:00");
        Timestamp schedule2 = Timestamp.valueOf("2023-7-20 12:00:00");
        b.addSchedule(schedule1, 12);
        b.addSchedule(schedule2, 12);
        b.schedules.forEach(Schedule::printSchedule);
        // Invalid date
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("Make booking at July 19, 2023 15:00:00 Seat AF12");
        System.out.println(Payment.makeBooking(t1, "AF12", b));
        // Valid date, invalid seat
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("\nMake booking at July 18, 2023 15:00:00 Seat AF20");
        System.out.println(Payment.makeBooking(t2, "AF20", b));
        // Valid date, valid seat
        System.out.println("\nMake booking at July 18, 2023 15:00:00 Seat AF07");
        System.out.println(Payment.makeBooking(t2, "AF07", b));
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat AF01");
        System.out.println(Payment.makeBooking(t3, "AF01", b));
        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat AF01 again");
        System.out.println(Payment.makeBooking(t3, "AF01", b));
        // Check if the data changed
        System.out.println("\nUpdated Schedule\n");
        b.schedules.forEach(Schedule::printSchedule);*/
                
            
            
        /*
      Price[] unfilteredArray = new Price[5];
      for(int i = 0 ; i < unfilteredArray.length ; i++) {
          int j = 5000;
          unfilteredArray[i] = new Price((i  + 1) * j);
      }
      
      System.out.println("Price list");
      for(Price price : unfilteredArray){
          System.out.println(price.price);
      }
      
      System.out.println("Below 12000");
      System.out.println(Validate.filter(unfilteredArray, 12000, true));
      System.out.println("Above 10000");
      System.out.println(Validate.filter(unfilteredArray, 10000, false));
    Bus testBus = createBus();
    // Payment
    Payment testPayment = new Payment(1, 1, 1, testBus.id, "S1");
    System.out.println(testPayment.getDepartureInfo());
    System.out.println(testPayment.getTime());  
    // Tes Schedule
    Calendar schedule1 = Calendar.getInstance();
    testBus.addSchedule(schedule1);
    Calendar schedule2 = Calendar.getInstance();
    schedule2.add(Calendar.DAY_OF_MONTH, 3);
    testBus.addSchedule(schedule2);
    
    for(Schedule s: testBus.schedules){
        testBus.printSchedule(s);
        System.out.println();
    }
    */
    /*
    }
    private static void testExist(Integer[] t) {
        int valueToCheck = 67;
        boolean result3 = Algorithm.exists(t, valueToCheck);
        if (result3) {
            System.out.println(valueToCheck + " exist in the array.");
        } else {
            System.out.println(valueToCheck + " doesn't exists in the array.");
        }
    }
    public static void testCount(Integer[] t) {
        int valueToCount = 18;
        int result = Algorithm.count(t, valueToCount);
        System.out.println("Number " + valueToCount + " appears " + result + " times");
    }
    public static void testFind(Integer[] t) {
        Integer valueToFind = 69;
        Integer result2 = Algorithm.find(t, valueToFind);
        System.out.print("Finding " + valueToFind + " inside the array : ");
        if (result2 != null) {
            System.out.println("Found!" + result2);
        } else {
            System.out.println("Not Found");
        }
    }
    private static void testCollect(Integer[] t) {
        Predicate<Integer> below = (val)->val<=22;
        Predicate<Integer> above = (val)->val>43;

        List<Integer> integerBelow = Algorithm.collect(t, below);
        List<Integer> integerAbove = Algorithm.collect(t, above);

        System.out.println("Below 22");
        System.out.println(integerBelow);
        System.out.println("Above 43");
        System.out.println(integerAbove);
    }
    public static int getBusId(){
        return 0;
    }   
    public static String getBusName(){
        return "Bus";
    }
    public static boolean isDiscount(){
        return true;
    }
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        float discountPercentage;    
        if(beforeDiscount>afterDiscount){
            discountPercentage = (float)((beforeDiscount - afterDiscount)/(float)(beforeDiscount))*100;
        }
        else{
            discountPercentage = 0.0f;
        }
        return discountPercentage;
    }
    public static int getDiscountedPrice(int price, float discountPercentage){
        int discountedPrice = 0;
        if( discountPercentage>100.0f){
            discountPercentage=100.0f;
        }
        else{
            discountedPrice = (int) (price - (price * (discountPercentage/100.0f)));
        }
        return discountedPrice;
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        int originalPrice;
        if( discountPercentage>100.0f){
            discountPercentage=100.0f;
        }
        originalPrice = (int) (discountedPrice/ (1-(discountPercentage/100.0f)));
        return originalPrice;
    }
    
    
    public static float getAdminFeePercentage(){
        return 0.05f;
    }
    
    public static int getAdminFee(int price){
        float adminFeePercentage = getAdminFeePercentage();
        int adminFee = (int)(price * adminFeePercentage);
        return adminFee;
    }
    
    public static int getTotalPrice(int price, int numberOfSeat){
        int adminFee = getAdminFee(price * numberOfSeat);
        return (price * numberOfSeat) + adminFee;
    }
    
    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus( "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
    
    
    
    
    
    
    
}*/
