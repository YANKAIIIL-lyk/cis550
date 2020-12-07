package com.example.cis550.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GrammyAlbums", schema = "project", catalog = "")
@IdClass(GrammyAlbumsEntityPK.class)
public class GrammyAlbumsEntity {
    private String award;
    private int grammyYear;
    private String genre;
    private String album;
    private String artist;

    @Id
    @Column(name = "Award", nullable = false, length = 255)
    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Id
    @Column(name = "GrammyYear", nullable = false)
    public int getGrammyYear() {
        return grammyYear;
    }

    public void setGrammyYear(int grammyYear) {
        this.grammyYear = grammyYear;
    }

    @Basic
    @Column(name = "Genre", nullable = true, length = 255)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "Album", nullable = true, length = 255)
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Basic
    @Column(name = "Artist", nullable = true, length = 255)
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
        GrammyAlbumsEntity that = (GrammyAlbumsEntity) o;
        return grammyYear == that.grammyYear &&
                Objects.equals(award, that.award) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(album, that.album) &&
                Objects.equals(artist, that.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(award, grammyYear, genre, album, artist);
    }
}
