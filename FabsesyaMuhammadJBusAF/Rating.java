package FabsesyaMuhammadJBusAF;


public class Rating{
    private long count;
    private long total;

    public Rating(){
        this.count = 0;
        this.total = 0;
    }
    
    public void Insert(int rating){
        this.total += rating;
        this.count++;
    }
    
    public double getAverage(){
        if(this.count!=0){
            return this.total/this.count;
        }
        else{
            this.count++;
            return this.total/this.count;
        }
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }
}