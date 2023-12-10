package com.FabsesyaMuhammadJBusAF.controller;

import com.FabsesyaMuhammadJBusAF.*;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonAutowired;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/** Ini untuk mengatur Base Api dari Bus**/
@RestController
@RequestMapping("/bus")
public class BusController implements BasicGetController<Bus> {
    public static @JsonAutowired(value = Bus.class, filepath = "C:\\Users\\asus\\Downloads\\OOP\\JBus\\src\\main\\java\\com\\FabsesyaMuhammadJBusAF\\json\\bus_db.json") JsonTable<Bus> busTable;

    @Override
    public JsonTable<Bus> getJsonTable() {
        return busTable;
    }

    /** Ini untuk Base Api Create**/
    @PostMapping("/create")
    public BaseResponse<Bus> create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int capacity,
                    @RequestParam List<Facility> facilities,
                    @RequestParam BusType busType,
                    @RequestParam int price,
                    @RequestParam int stationDepartureId,
                    @RequestParam int stationArrivalId
            ) {

        if (Algorithm.<Account>find(AccountController.accountTable, e -> e.id == accountId && e.company != null) == null) {
            return new BaseResponse<Bus>(false, "Account tidak ditemukan atau bukan merupakan Renter", null);
        }

        Station departure = Algorithm.<Station>find(StationController.stationTable, e -> e.id == stationDepartureId);
        Station arrival = Algorithm.<Station>find(StationController.stationTable, e -> e.id == stationArrivalId);

        if (departure == null || arrival == null) {
            return new BaseResponse<Bus>(false, "Stasiun Departure atau Stasiun Arrival tidak terdapat dalam database", null);
        }

        Bus bus = new Bus(name, facilities, new Price(price), capacity, busType, departure, arrival, accountId);

        // Add the new station to the stationTable
        busTable.add(bus);

        //Success response message
        return new BaseResponse<Bus>(true, "Station added successfully", bus);

    }

    /** Ini untuk Base Api Add Schedule **/
    @PostMapping("/addSchedule")
    public BaseResponse<Bus> addSchedule
            (
                    @RequestParam int busId,
                    @RequestParam String time
            ) {
        try{
            Bus busSchedule = Algorithm.<Bus>find(busTable, b -> b.id == busId);
            busSchedule.addSchedule(Timestamp.valueOf(time));
            return new BaseResponse<>(true, "Berhasil Add Schedule", busSchedule);
        }catch (IllegalArgumentException e){
            return new BaseResponse<>(false, "Gagal Add Schedule", null);
        }catch (Exception e){
            return new BaseResponse<>(false, "Gagal Add Schedule", null);
        }

    }

    /** Ini untuk Base Api Get My Bus**/
    @GetMapping("/getMyBus")
    public List<Bus> getMyBus(@RequestParam int accountId) {
        return Algorithm.<Bus>collect(getJsonTable(), b -> b.accountId == accountId);
    }

    /** Ini untuk Base Api Get All Bus**/
    @GetMapping("/getAll")
    public BaseResponse<List<Bus>> getAllBus(){
        return new BaseResponse<>(true,"Success",getJsonTable());
    }
}
