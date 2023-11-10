package com.FabsesyaMuhammadJBusAF.controller;

import com.FabsesyaMuhammadJBusAF.Algorithm;
import com.FabsesyaMuhammadJBusAF.dbjson.JsonTable;
import com.FabsesyaMuhammadJBusAF.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BasicGetController <T extends Serializable> {
    @GetMapping("/page")
    public default List<T> getPage
            (
            @RequestParam int page,
            @RequestParam int pageSize
            )
        {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, (e) -> true);
    }
    public JsonTable<T> getJsonTable();

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(), (e) ->{return e.id==id;});
    }
}
