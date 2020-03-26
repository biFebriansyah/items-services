package com.finaltest.itemservice.controller;

import com.finaltest.itemservice.dto.ItemDto;
import com.finaltest.itemservice.service._ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class ItemController {

    @Autowired
    _ItemService ServiceItem;

    @GetMapping(value = "/{id}")
    public ResponseEntity getUserById (@PathVariable("id") int id) {
        return new ResponseEntity(ServiceItem.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getByWhat (@RequestParam(required = false) String name, @RequestParam(required = false) String price) {

        if (name == null && price == null) {
            return new ResponseEntity(ServiceItem.get(), HttpStatus.OK);
        }
        else if (name == null && price != null) {
            return new ResponseEntity(ServiceItem.getByWhat(price,  "price"), HttpStatus.OK);
        }
        else if (name != null && price == null) {
            return new ResponseEntity(ServiceItem.getByWhat(name,  "name"), HttpStatus.OK);

        } else { return new ResponseEntity("Only Accept Paramater name or Price", HttpStatus.BAD_REQUEST);}
    }

    @PostMapping
    public ResponseEntity AddItems (ItemDto Value) {
        return new ResponseEntity(ServiceItem.AddItems(Value.getNameItem(), Value.getPrice()), HttpStatus.OK);
    }
}
