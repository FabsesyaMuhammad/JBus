package FabsesyaMuhammadJBusAF;


public class Price {
    public double price;
    public double rebate;
    //public int discount;

    public Price(double price){
        this.price = price;
        this.rebate = 0;
        //this.discount = 0;
    }

    /*public Price(double price, int discount){
        this.price = price;
        this.rebate = 0;
        this.discount = discount;
    }*/

    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
        //this.discount = 0;
    } 
    
    /*private double getDiscountedPrice(){
        if(this.discount>=100.0f){
            return 0.0f;
        }
        else{
            return (this.price - (this.price * ((double)this.discount/100.0f)));
        }
    }
    
    private double getRebatedPrice(){
        if(this.price<this.rebate){
            return 0;
        }
        return this.price - this.rebate;
    }*/
    public String toString(){
        String println = "\nPrice" + "\nPrice : " + price + "\nRebate : " + rebate;
        return println;
    }
    

}

