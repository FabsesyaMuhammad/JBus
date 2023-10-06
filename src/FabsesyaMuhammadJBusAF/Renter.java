package FabsesyaMuhammadJBusAF;



public class Renter extends Serializable
{
    public String address;
    public String companyName;
    public int phoneNumber;
    
    Renter(int id,String companyName){
        super();
        this.companyName = companyName;
        this.phoneNumber = 0;
        this.address = "";
    }
    Renter(int id,String companyName, String address){
        super();
        this.companyName = companyName;
        this.phoneNumber = 0;
        this.address = address;
    }
    Renter(int id,String companyName, int phoneNumber){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }
    Renter(int id,String companyName, int phoneNumber, String address){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    
}
