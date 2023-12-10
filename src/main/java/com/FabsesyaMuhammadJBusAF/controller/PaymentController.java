package com.FabsesyaMuhammadJBusAF.controller;

import com.FabsesyaMuhammadJBusAF.*;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonAutowired;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import static com.FabsesyaMuhammadJBusAF.controller.AccountController.accountTable;

/** Ini untuk Mengatur Base Api dari Payment **/
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static @JsonAutowired(value = Payment.class, filepath = "C:\\Users\\asus\\Downloads\\OOP\\JBus\\src\\main\\java\\com\\FabsesyaMuhammadJBusAF\\json\\payment.json") JsonTable<Payment> paymentTable;

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    /** Ini untuk Base Api Make Booking**/
    @PostMapping("/makeBooking")
    public BaseResponse<Payment> makeBooking
            (
                    @RequestParam int buyerId,
                    @RequestParam int renterId,
                    @RequestParam int busId,
                    @RequestParam List<String> busSeats,
                    @RequestParam String departureDate
            ){

        Account buyerAcc = Algorithm.<Account>find(accountTable, a->a.id == buyerId);
//        Account renterAcc = Algorithm.<Account>find(accountTable, r->r.company != null & r.company.id == renterId);
        Bus bus = Algorithm.<Bus>find(BusController.busTable, b->b.id == busId);
        double priceBook = Algorithm.<String>count(busSeats, p->true) * bus.price.price;
        Schedule schedule = Payment.availableSchedule(Timestamp.valueOf(departureDate), busSeats, bus);
        if(buyerAcc == null){
            return new BaseResponse<>(false, "Account not  valid", null);
        }
//        if(renterAcc == null){
//            return new BaseResponse<>(false, "Renter not valid", null);
//        }
        if(bus == null){
            return new BaseResponse<>(false, "Bus not valid", null);
        }
        if(priceBook > buyerAcc.balance){
            return new BaseResponse<>(false, "Not enough balance", null);
        }
        if(schedule == null){
            return new BaseResponse<>(false, "Schedule not exist", null);
        }
        if(!Payment.makeBooking(Timestamp.valueOf(departureDate), busSeats, bus)){
            return new BaseResponse<>(false, "Payment Failed", null);
        }
        Payment payment = new Payment(buyerId, renterId, busId, busSeats, Timestamp.valueOf(departureDate));
        paymentTable.add(payment);
        return new BaseResponse<>(true, "Payment Succesful", null);
    }

    /** Ini untuk Base Api Accept**/
    @PostMapping("/{id}/accept")
    public BaseResponse<Payment> accept (@PathVariable int id) {

        Payment payment = Algorithm.<Payment>find(paymentTable, t -> t.id == id);
        Account paymentAccount = Algorithm.<Account>find(AccountController.accountTable, a -> a.id == payment.buyerId);

        Bus tempBus = Algorithm.<Bus>find(BusController.busTable, b -> b.id == payment.getBusId());
        if (payment == null) {
            return new BaseResponse<>(false, "Payment tidak ditemukan", null);
        }
        else {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            paymentAccount.balance -= tempBus.price.price;
        }
        return new BaseResponse<>(true, "Payment telah berhasil", payment);
    }

    /** Ini untuk Base Api Cancel**/
    @PostMapping("/{id}/cancel")
    public BaseResponse<Payment> cancel(@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), e -> e.id==id);
        if(payment != null){
            payment.status = Invoice.PaymentStatus.FAILED;
            return new BaseResponse<Payment>(true, "Success cancel payment", payment);
        }
        return new BaseResponse<Payment>(false, "Failed cancel payment", null);
    }
    /** Ini untuk Base Api Get All Payment**/
    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayment(

    ) {
        System.out.println("Over here");
        return getJsonTable();
    }

    /** Ini untuk Base Api Get My Payment**/
    @GetMapping("/getMyPayment")
    public List<Payment> getMyPayment(@RequestParam int buyerId) {
        return Algorithm.<Payment>collect(getJsonTable(), b->b.buyerId == buyerId);
    }
}
