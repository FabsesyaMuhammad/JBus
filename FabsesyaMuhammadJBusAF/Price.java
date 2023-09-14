package FabsesyaMuhammadJBusAF;


public class Price {
    public double price;
    public double rebate;
    public int discount;

    public Price(double price){
        this.price = price;
        this.rebate = 0;
        this.discount = 0;
    }

    public Price(double price, int discount){
        this.price = price;
        this.rebate = 0;
        this.discount = discount;
    }

    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    } 

}

