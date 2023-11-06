package FabsesyaMuhammadJBusAF;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Renter extends Serializable
{
    public String address;
    public String companyName;
    public String phoneNumber;
    private final String REGEX_PHONE = "[0-9]{9,12}";
    private final String REGEX_NAME = "[A-Z][A-Za-z0-9]";

    
    Renter(String companyName){
        super();
        this.companyName = companyName;
        this.phoneNumber = "";
        this.address = "";
    }

    Renter(String companyName, String phoneNumber){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }
    Renter(String companyName, String phoneNumber, String address){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public boolean validate(){
        Pattern pattern1 = Pattern.compile(REGEX_PHONE);
        Matcher matcher1 = pattern1.matcher(String.valueOf(phoneNumber));
        boolean matchFound1 = matcher1.find();

        Pattern pattern2 = Pattern.compile(REGEX_NAME);
        Matcher matcher2 = pattern2.matcher(companyName);
        boolean matchFound2 = matcher2.find();

        if(matchFound1){
            if(matchFound2){
                return true;
            }
        }
        return matchFound1 && matchFound2;
    }
    
    
}
