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
    
    private double getDiscountedPrice(){
        if(this.discount>=100.0f){
            this.discount=100;
            return 0.0f;
        }
        else{
            this.price = (this.price - (this.price * ((double)this.discount/100.0f)));
            return this.price;
        }
    }
    
    private double getRebatedPrice(){
        this.price = this.price - this.rebate; 
        if(this.price<0){
            this.price = 0;
        }
        return this.price;
    }
    

}

