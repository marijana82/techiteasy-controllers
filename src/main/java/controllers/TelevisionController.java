package controllers;

//give this controller class @RestController annotation

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
    public ResponseEntity<String> getOneTelevision() {
        return ResponseEntity.ok("One television delivered");
    }

    //post-request for one television
    @PostMapping("/television")
    public ResponseEntity<String> createNewTelevision(@RequestBody String title) {
        //here we save data in the database
        String name = "Television One";
        URI location =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{name}")
                        .buildAndExpand(name).toUri();
        return ResponseEntity.created(location).build();
    }

    //put-request for one television
    @PutMapping("/television/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String tvTitle) {
        //here is where the updating logics happens
        //return ResponseEntity.noContent();

    }

    //delete-request for one television
    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        //here is where the name gets deleted from the database
        //return ResponseEntity.noContent();
    }
}
