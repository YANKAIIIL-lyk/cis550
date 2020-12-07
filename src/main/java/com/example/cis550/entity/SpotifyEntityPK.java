package com.example.cis550.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SpotifyEntityPK implements Serializable {
    private String name;
    private String artist;
    private String week;

    @Column(name = "Name", nullable = false, length = 255)
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Artist", nullable = false, length = 255)
    @Id
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Column(name = "Week", nullable = false, length = 255)
    @Id
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpotifyEntityPK that = (SpotifyEntityPK) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(artist, that.artist) &&
                Objects.equals(week, that.week);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, artist, week);
    }
}
