package FabsesyaMuhammadJBusAF;

public class JBus
{   /*
    public static void main(String[] args){
        Bus testBus = createBus();
        System.out.println(testBus.name);
        System.out.println(testBus.facility);
        System.out.println(testBus.price.price);
        System.out.println(testBus.capacity);
    } */
    public static void main(String[] args){
        Payment testPayment = new Payment(1, 1, 1, "A", 1, "A", "A");
        Invoice testInvoice = new Invoice(2,2,2, "B");
        Station testStation = new Station(3, "c", City.DEPOK);
        System.out.println(testPayment.print());
        System.out.println(testInvoice.print());
        System.out.println(testStation.print());
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
    /*
    public static Bus createBus(){
        Price price = new Price(750000, 5);
        Bus bus = new Bus("Netlab Bus", Facility.LUNCH, price, 25); 
        return bus; 
    }*/
    
    
    
    
    
    
    
}
