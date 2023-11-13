package com.FabsesyaMuhammadJBusAF.controller;

import com.FabsesyaMuhammadJBusAF.*;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonAutowired;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static @JsonAutowired(value = Payment.class, filepath = "C:\\Users\\asus\\Downloads\\OOP\\JBus\\src\\main\\java\\com\\FabsesyaMuhammadJBusAF\\json\\payment.json") JsonTable<Payment> paymentTable;

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/makeBooking")
    public BaseResponse<Payment> makeBooking
            (
                    @RequestParam int buyerId,
                    @RequestParam int renterId,
                    @RequestParam int busId,
                    @RequestParam List<String> busSeats,
                    @RequestParam String departureDate
            ){
    Account buyer = Algorithm.<Account>find(AccountController.accountTable, e -> e.id==buyerId);
    Account renter = Algorithm.<Account>find(AccountController.accountTable, e -> e.id == renterId);
    Bus bus = Algorithm.<Bus>find(BusController.busTable, e -> (e.id==busId)&&(e.accountId==renterId));
    if(buyer!=null&&bus!=null){
        if(Payment.makeBooking(Timestamp.valueOf(departureDate), busSeats, bus)){
            Payment payment = new Payment(buyer, renter.company, busId, String.valueOf(busSeats), Timestamp.valueOf(departureDate));
            payment.status = Invoice.PaymentStatus.WAITING;
            paymentTable.add(payment);
            return new BaseResponse<Payment>(true, "Success Booking", payment);
        }
        else return new BaseResponse<Payment>(false, "Failed booking, no schedule or seats", null);
    }
    return new BaseResponse<Payment>(false, "Failed booking, no account or bus", null);

    }

    @PostMapping("/{id}/accept")
    public BaseResponse<Payment> accept(@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), e -> e.id == id);
        if(payment != null){
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return new BaseResponse<Payment>(true, "Success accept payment", payment);
        }
        return new BaseResponse<Payment>(false, "Failed accept payment", null);
    }

    @PostMapping("/{id}/cancel")
    public BaseResponse<Payment> cancel(@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), e -> e.id==id);
        if(payment != null){
            payment.status = Invoice.PaymentStatus.FAILED;
            return new BaseResponse<Payment>(true, "Success cancel payment", payment);
        }
        return new BaseResponse<Payment>(false, "Failed cancel payment", null);
    }
}
