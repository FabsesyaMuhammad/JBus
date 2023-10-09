package FabsesyaMuhammadJBusAF;


public class Voucher extends Serializable implements FileParser
{
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;
    
    public Voucher(String name, int code, Type type, double minimum, double cut){
        super();
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = false;
    }
    
    public boolean isUsed(){
        return this.used;
    }
    
    public boolean canApply(Price price){
        if(price.price > this.minimum && !this.used){
            return true;
        }
        else{
            return false;
        }
    }
    
    public double apply(Price price){
        this.used = true;
        
        if(this.type == type.DISCOUNT){
            if(this.cut>100){
                this.cut = 100;
            } 
            return (price.price - (price.price * ((double)this.cut/100.0f)));
        }
        else{
            if(this.cut > price.price){
                return 0;
            }
            
            return price.price - this.cut;
        }
        
    }
    public boolean read(String obj){
        return false;        
    }
    public Object write(){
        return null;
    }
    
    
}
