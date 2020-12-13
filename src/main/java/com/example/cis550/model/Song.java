package com.example.cis550.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Song {
    private String songName;
    private String artists;
    private String genre;
    private int year;

    public Song(String songName, String artists, String genre, int year) {
        this.songName = songName;
        this.artists = artists;
        this.genre = genre;
        this.year = year;
    }

    public Song(String songName, String artists, int year) {
        this.songName = songName;
        this.artists = artists;
        this.year = year;
    }
}
