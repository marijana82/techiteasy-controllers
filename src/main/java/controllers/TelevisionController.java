package controllers;

//give this controller class @RestController annotation

import exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {
    //here I create a list of datatype Television
    //in order to use datatype Television, I have to create a new class Television and give it instance variables
    private List<Television> televisionList = new ArrayList<>();

    //here I create constructor for the class TelevisionController
    public TelevisionController() {
        //here I instantiate the new object of the Television class
        Television newTelevision = new Television("Samsung XL", "Samsung", 123);
        televisionList.add(newTelevision);
    }

    //get-request for all televisions
    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return new ResponseEntity<>(televisionList, HttpStatus.OK);
    }

    //get-request for one television
    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getOneTelevision(@PathVariable int id) {
        if (id >= 0 && id < televisionList.size()) {
            Television t = televisionList.get(id);
            return new ResponseEntity<>(t, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("Television with ID number " + id + " does not exist");
        }
    }

    //post-request for one television
    @PostMapping("/televisions/addNewTv")
    public ResponseEntity<Television> createNewTelevision(@RequestBody Television addNewTv) {
        //here we save data in the database

        URI location =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{name}")
                        .buildAndExpand(addNewTv.getName())
                        .toUri();
        return ResponseEntity.created(location).build();
    }

    //put-request for one television
    @PutMapping("/televisions/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable int id, @RequestBody Television television) {
        if (id >= 0 && id < televisionList.size()) {
            televisionList.set(id, television);
            return new ResponseEntity<>(television, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("Television with id: " + id + " does not exist and cannot be updated");
        }

    }

    //delete-request for one television
    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable int id) {
        if(id >= 0 && id < televisionList.size()) {
            televisionList.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new RecordNotFoundException("Television with id " + id + " does not exist and cannot be deleted");
        }
    }
}
