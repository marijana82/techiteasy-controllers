package com.controllerstechiteasy.techiteasycontrolleropdracht.controllers;

import exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {
    final List<Television> televisionList;

    //constructor
    public TelevisionController() {
        televisionList = new ArrayList<>();
        //instantiate object tv
        Television tv = new Television();
        //add data to object tv
        tv.setName("Tesla");
        tv.setBrand("Tesla xyz");
        tv.setSerialNumber(123);
        //add tv to televisionList
        televisionList.add(tv);
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getTelevisions(){
        return new ResponseEntity<>(televisionList, HttpStatus.FOUND); //also possible: return ResponseEntity.ok(televisionList);
    }

    @PostMapping("/televisions")
    public ResponseEntity<Television> createTelevision(@RequestBody Television newTelevision) {
        televisionList.add(newTelevision);
        return new ResponseEntity<>(newTelevision, HttpStatus.CREATED);
    }

    @GetMapping("/televisions/{index}")
    public ResponseEntity<Television> getOneTelevision(@PathVariable int index){
        //check if the index is within the bounds
        if(index >= 0 && index < televisionList.size()) {
            Television tv = televisionList.get(index);
            return new ResponseEntity<>(tv, HttpStatus.FOUND);
        } else {
            //return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            throw new RecordNotFoundException("The requested television under index number " + index + " cannot be found.");
        }

    }


    @PutMapping("/televisions/{index}")
    public ResponseEntity<Television> updateOneTelevision(@PathVariable int index, @RequestBody Television television) {
        if (index >= 0 && index < televisionList.size()) {
            televisionList.set(index, television);
            return new ResponseEntity<>(television, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("The requested television under index number " + index + " cannot be updated.");
        }
    }


    @DeleteMapping("/televisions/{index}")
    public ResponseEntity<Television> deleteOneTelevision(@PathVariable int index) {
        if (index >= 0 && index < televisionList.size()) {
            televisionList.remove(index);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new RecordNotFoundException("Television cannot be deleted, please try again");
        }
    }



}




