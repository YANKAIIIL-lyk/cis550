package com.example.cis550.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BB200EntityPK implements Serializable {
    private String artists;
    private String albumName;
    private String week;

    @Column(name = "Artists", nullable = false, length = 255)
    @Id
    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    @Column(name = "AlbumName", nullable = false, length = 255)
    @Id
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
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
        BB200EntityPK that = (BB200EntityPK) o;
        return Objects.equals(artists, that.artists) &&
                Objects.equals(albumName, that.albumName) &&
                Objects.equals(week, that.week);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artists, albumName, week);
    }
}
