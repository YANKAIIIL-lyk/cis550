package com.example.cis550.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
public class TopGenre{
    //The sequence is the same as the return value of JPA
    private String songName;
    private String artists;
    private String genre;
    private int year;

    public TopGenre(String var1, String var2, String var3, int var4){
        this.songName = var1;
        this.artists = var2;
        this.genre = var3;
        this.year = var4;
    }
}
