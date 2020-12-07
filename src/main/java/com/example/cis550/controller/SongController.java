package com.example.cis550.controller;

import com.example.cis550.entity.BB200Entity;
import com.example.cis550.model.Song;
import com.example.cis550.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/song")
public class SongController {

    @Autowired
    private SongService songService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> test(
            @RequestParam(value = "startYear") String startYear,
            @RequestParam(value = "endYear") String endYear) {
        String list = startYear + " " + endYear;
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/allGrammy", method = RequestMethod.GET)
    public ResponseEntity<?> allGrammy() {
        List<BB200Entity> res = songService.findAllGrammySongs();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //Start from here
    @RequestMapping(value = "/range", method = RequestMethod.GET)
    public ResponseEntity<?> range(
            @RequestParam(value = "startYear") String startYear,
            @RequestParam(value = "endYear") String endYear) {
        List<Song> res = songService.findRange(startYear, endYear);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
