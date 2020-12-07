package com.example.cis550.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RiaaSingleEntityPK implements Serializable {
    private String songName;
    private String artist;

    @Column(name = "SongName", nullable = false, length = 255)
    @Id
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Column(name = "Artist", nullable = false, length = 255)
    @Id
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiaaSingleEntityPK that = (RiaaSingleEntityPK) o;
        return Objects.equals(songName, that.songName) &&
                Objects.equals(artist, that.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName, artist);
    }
}
