package com.FabsesyaMuhammadJBusAF.controller;

import com.FabsesyaMuhammadJBusAF.Account;
import com.FabsesyaMuhammadJBusAF.Algorithm;
import com.FabsesyaMuhammadJBusAF.Renter;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonAutowired;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{

    public static @JsonAutowired(value = Account.class, filepath = "C:\\Users\\asus\\Downloads\\OOP\\JBus\\src\\main\\java\\com\\FabsesyaMuhammadJBusAF\\json\\account.json") JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    BaseResponse<Account> register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )

    {
        Account account = new Account(name, email, password);
        if(!name.isBlank()&& account.validate()&&!Algorithm.<Account>exists(accountTable, e -> e.email.equals(email))){
            String passwordHash = password;
            String generatePassword = null;
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");

                md.update(passwordHash.getBytes());

                byte[] bytes = md.digest();

                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < bytes.length; i++){
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                generatePassword=sb.toString();
            }catch(NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            account.password = generatePassword;
            accountTable.add(account);
            return new BaseResponse<Account>(true, "Berhasil register", account);
        }
            return new BaseResponse<Account>(false, "Gagal register", null);

    }
    @PostMapping("/login")
    BaseResponse<Account> login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(password.getBytes());

            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            password=sb.toString();
        }catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        final String boolPassword = password;

        Account account;
            if(Algorithm.<Account>exists(accountTable, (e) -> e.email.equals(email)&& e.password.equals(boolPassword))){
                account = Algorithm.<Account>find(accountTable, (e) -> e.email.equals(email)&& e.password.equals(boolPassword));
                return new BaseResponse<Account>(true, "Berhasil Login", account);
            }

        return new BaseResponse<>(false, "Gagal login", null);
    }
    @PostMapping("/{id}/registerRenter")
    BaseResponse<Renter> registerRenter
            (
                @PathVariable int id,
                @RequestParam String companyName,
                @RequestParam String phoneNumber,
                @RequestParam String address

            )
    {
        for (Account account : accountTable){
            if(account.id==id&&account.company==null ){
                Renter renter = new Renter(companyName, phoneNumber, address);
                account.company = renter;
                return new BaseResponse<>(true, "Berhasil", renter);
            }
        }
        return new BaseResponse<>(false, "Gagal", null);
    }

    @PostMapping("/{id}/topUp")
    BaseResponse<Double> topUp
            (
                    @PathVariable int id,
                    @RequestParam double amount
            )
    {
        for (Account account : accountTable){
            if(account.id==id&&account.topUp(amount)){
                return new BaseResponse<>(true, "Berhasil", amount);
            }
        }
        return new BaseResponse<>(false, "Gagal", 0.0D);
    }

    /*
    @GetMapping("/{id}")
    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }*/
}
