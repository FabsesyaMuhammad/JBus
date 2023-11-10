package com.FabsesyaMuhammadJBusAF;

import com.FabsesyaMuhammadJBusAF.dbjson.*;

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
        String println ="Id  : " + id + "\tStation Name : " + stationName + "\tCity : " + city.toString() + "\tAddress : " + address;
        return println;
    }
    
}
