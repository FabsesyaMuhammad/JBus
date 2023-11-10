package com.FabsesyaMuhammadJBusAF;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.FabsesyaMuhammadJBusAF.dbjson.*;

public class Account extends Serializable
{
    public String email;
    public String name;
    public String password;
    private static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z_]+?\\.[a-zA-Z.]+[a-zA-Z]+$";
    private static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public double balance;
    public Renter company;
    
    public Account(String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
        this.company = null;
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
    public boolean topUp(double balanced){
        if(balanced>0.0D){
            this.balance += balanced;
            return true;
        }
        return false;
    }
}

