package FabsesyaMuhammadJBusAF;


public class Station extends Serializable
{
    public City city;
    public String stationName;
    
    public Station(int id, String stationName, City city){
        super(id);
        this.stationName = stationName;
        this.city = city;
    }
    public String print(){
        String print = "\nStation" + "\nId  : " + id + "\nStation Name : " + stationName + "\nCity : " + city.toString();
        return print;
    }
    
}
