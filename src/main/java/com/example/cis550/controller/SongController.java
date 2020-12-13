package com.example.cis550.controller;

import com.example.cis550.entity.BB200Entity;
import com.example.cis550.model.RecommendView;
import com.example.cis550.model.Song;
import com.example.cis550.model.TopGenre;
import com.example.cis550.service.SongService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api/song")
@CrossOrigin
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

    @RequestMapping(value = "/top_genre", method = RequestMethod.GET)
    public ResponseEntity<?> topGenre(
            @RequestParam(value = "year") int year,
            @RequestParam(value = "genre") String genre,
            @RequestParam(value = "orderby", required = false) boolean sort
    ){
        List<TopGenre> topgenres = songService.findTopGenre(year, genre, sort);
        return new ResponseEntity<>(topgenres, HttpStatus.OK);
    }

    @RequestMapping(value = "/hidden_gem", method = RequestMethod.GET)
    public ResponseEntity<?> hiddenGem(
            @RequestParam(value = "startYear") String startYear,
            @RequestParam(value = "endYear") String endYear) {
        List<Song> res = songService.hidden(startYear, endYear);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/spotify", method = RequestMethod.GET)
    public ResponseEntity<?> spotifyExclusive(
            @RequestParam(value = "startYear") String start,
            @RequestParam(value = "endYear") String end){
        List<Song> res = songService.exclusive(start, end);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/recommendation", method = RequestMethod.GET)
    public ResponseEntity<?> recommend(
            @RequestParam(value = "genre") String genre){
        List<RecommendView> res = songService.recommend(genre);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
