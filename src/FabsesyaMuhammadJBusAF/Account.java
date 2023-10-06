package FabsesyaMuhammadJBusAF;

    

public class Account extends Serializable implements FileParser
{
    public String email;
    public String name;
    public String password;
    
    public Account(int id, String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String toString(){
        String println = "\nAccount" + "\nId  : " + id + "\nAccount Name : " + name + "\nEmail : " + email + "\nPassword : " + password;
        return println;
    }
    public boolean read(String obj){
        return false;        
    }
    public Object write(){
        return null;
    }
}
