package FabsesyaMuhammadJBusAF;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    public String email;
    public String name;
    public String password;
    private final static String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+\\\\.(com)$";
    private final static String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)[A-Za-z\\\\d]{8,}$";
    
    public Account(int id, String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String toString(){
        String println = "\nAccount" + "Id  : " + id + "\nName : " + name + "\nEmail : " + email + "\nPassword : " + password;
        return println;
    }
    public boolean read(String obj){
        return false;        
    }
    public Object write(){
        return null;
    }
    public boolean validate(){
        boolean emailTrue = Pattern.matches(REGEX_EMAIL, email);
        boolean passwordTrue = Pattern.matches(REGEX_PASSWORD, password);

        return emailTrue && passwordTrue;
    }
}

