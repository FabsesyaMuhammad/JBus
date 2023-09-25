package FabsesyaMuhammadJBusAF;



public class Review extends Serializable
{
    public String date;
    public String desc;
    
    public Review(int id, String date, String desc){
        super(id);
        this.date = date;
        this.desc = desc;
    }
    
    public String toString(){
        String println = "\nReview" + "\nId : " + id + "\nDate : " + date + "\nDescription : " + desc;
        return println;
    }
}
