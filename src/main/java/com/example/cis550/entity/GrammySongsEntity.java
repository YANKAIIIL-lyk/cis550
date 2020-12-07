package com.example.cis550.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GrammySongs", schema = "project", catalog = "")
@IdClass(GrammySongsEntityPK.class)
public class GrammySongsEntity {
    private String grammyAward;
    private int grammyYear;
    private String genre;
    private String songName;
    private String artist;

    @Id
    @Column(name = "GrammyAward", nullable = false, length = 255)
    public String getGrammyAward() {
        return grammyAward;
    }

    public void setGrammyAward(String grammyAward) {
        this.grammyAward = grammyAward;
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
    @Column(name = "SongName", nullable = true, length = 255)
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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
        GrammySongsEntity that = (GrammySongsEntity) o;
        return grammyYear == that.grammyYear &&
                Objects.equals(grammyAward, that.grammyAward) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(songName, that.songName) &&
                Objects.equals(artist, that.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grammyAward, grammyYear, genre, songName, artist);
    }
}
