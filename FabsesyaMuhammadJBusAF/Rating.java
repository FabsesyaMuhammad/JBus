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
            return (double)this.total/this.count;
        }
        else{
            return 0;
        }
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }
}