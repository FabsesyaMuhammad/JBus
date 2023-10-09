package FabsesyaMuhammadJBusAF;


public class Station extends Serializable
{
    public City city;
    public String stationName;
    public String address;
    
    public Station( String stationName, City city, String address){
        super();
        this.stationName = stationName;
        this.city = city;
        this.address = address;
    }
    public String toString(){
        String println ="\nId  : " + id + "\nStation Name : " + stationName + "\nCity : " + city.toString() + "\nAddress : " + address;
        return println;
    }
    
}
