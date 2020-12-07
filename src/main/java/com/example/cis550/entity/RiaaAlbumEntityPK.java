package com.example.cis550.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RiaaAlbumEntityPK implements Serializable {
    private String album;
    private String artist;

    @Column(name = "Album", nullable = false, length = 255)
    @Id
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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
        RiaaAlbumEntityPK that = (RiaaAlbumEntityPK) o;
        return Objects.equals(album, that.album) &&
                Objects.equals(artist, that.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album, artist);
    }
}
