package FabsesyaMuhammadJBusAF;

import java.util.*;
import java.text.*;
import java.util.Calendar;

public class JBus
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
    public static void main(String[] args){
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
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
    
    
    
    
    
    
    
}
