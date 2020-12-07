package com.example.cis550.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Spotify", schema = "project", catalog = "")
@IdClass(SpotifyEntityPK.class)
public class SpotifyEntity {
    private String name;
    private String artist;
    private Integer streams;
    private String week;

    @Id
    @Column(name = "Name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "Artist", nullable = false, length = 255)
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Basic
    @Column(name = "Streams", nullable = true)
    public Integer getStreams() {
        return streams;
    }

    public void setStreams(Integer streams) {
        this.streams = streams;
    }

    @Id
    @Column(name = "Week", nullable = false, length = 255)
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
        SpotifyEntity that = (SpotifyEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(artist, that.artist) &&
                Objects.equals(streams, that.streams) &&
                Objects.equals(week, that.week);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, artist, streams, week);
    }
}
