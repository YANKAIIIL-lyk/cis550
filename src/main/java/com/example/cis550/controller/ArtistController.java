package com.example.cis550.controller;

import com.example.cis550.model.Artist;
import com.example.cis550.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/most_prolific", method = RequestMethod.GET)
    public ResponseEntity<?> mostProlific(){
        List<Artist> res = artistService.findMostProlific();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
