package com.FabsesyaMuhammadJBusAF.controller;

import com.FabsesyaMuhammadJBusAF.*;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonAutowired;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController implements BasicGetController<Bus>{
    public static @JsonAutowired(value = Bus.class, filepath = "C:\\Users\\asus\\Downloads\\OOP\\JBus\\src\\main\\java\\com\\FabsesyaMuhammadJBusAF\\json\\bus_db.json") JsonTable<Bus> busTable;

    @Override
    public JsonTable<Bus> getJsonTable() {
        return busTable;
    }

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
            )
    {

            if (Algorithm.<Account>find(AccountController.accountTable, e -> e.id==accountId&&e.company != null) == null) {
                return new BaseResponse<Bus>(false, "Account tidak ditemukan atau bukan merupakan Renter", null);
            }

            Station departure = Algorithm.<Station>find(StationController.stationTable, e -> e.id==stationDepartureId);
            Station arrival = Algorithm.<Station>find(StationController.stationTable, e -> e.id==stationArrivalId);

            if(departure==null||arrival==null){
                return new BaseResponse<Bus>(false, "Stasiun Departure atau Stasiun Arrival tidak terdapat dalam database", null);
            }

            Bus bus = new Bus(name, facilities, new Price(price), capacity, busType, departure, arrival);

            // Add the new station to the stationTable
            busTable.add(bus);

            //Success response message
            return new BaseResponse<Bus>(true, "Station added successfully", bus);

    }
    @PostMapping("/addSchedule")
    public BaseResponse<Bus> addSchedule
            (
                    @RequestParam int busId,
                    @RequestParam String time
            )
    {
        Bus bus = Algorithm.<Bus>find(busTable, e -> e.id == busId);
        Timestamp timestamp = Timestamp.valueOf(time);

        if(bus != null) {
            bus.addSchedule(timestamp);
            return new BaseResponse<Bus>(true, "Add Schedule success", bus);
        }
        return new BaseResponse<Bus>(false, "Failed Add Schedule", null);

    }
}
