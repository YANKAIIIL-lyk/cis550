package com.example.cis550.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class Test {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> index(){
        String list = "res";
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
