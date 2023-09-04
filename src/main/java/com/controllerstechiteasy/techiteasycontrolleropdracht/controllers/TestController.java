package com.controllerstechiteasy.techiteasycontrolleropdracht.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @PostMapping("/test")
    public String postTestRequest(@RequestBody String test) {
        return "This is request body test: " + test;
    }

   @PostMapping("/test/{test}")
    public String postTestVariable(@PathVariable String test) {
        return "This is path variable test: " + test;
    }

    @PostMapping("/parameter")
    public String postParam(@RequestParam int parameter) {
        return "This is request param test " + parameter;
    }





}
