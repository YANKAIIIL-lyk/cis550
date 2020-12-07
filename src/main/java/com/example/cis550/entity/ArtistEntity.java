package com.example.cis550.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Artist", schema = "project", catalog = "")
public class ArtistEntity {
    private String artist;
    private Integer followers;
    private String genres;
    private Integer numAlbums;
    private Integer yearFirstAblum;
    private String gender;
    private String groupSolo;

    @Id
    @Column(name = "Artist", nullable = false, length = 20)
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Basic
    @Column(name = "Followers", nullable = true)
    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    @Basic
    @Column(name = "Genres", nullable = true, length = 20)
    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Basic
    @Column(name = "NumAlbums", nullable = true)
    public Integer getNumAlbums() {
        return numAlbums;
    }

    public void setNumAlbums(Integer numAlbums) {
        this.numAlbums = numAlbums;
    }

    @Basic
    @Column(name = "YearFirstAblum", nullable = true)
    public Integer getYearFirstAblum() {
        return yearFirstAblum;
    }

    public void setYearFirstAblum(Integer yearFirstAblum) {
        this.yearFirstAblum = yearFirstAblum;
    }

    @Basic
    @Column(name = "Gender", nullable = true, length = 20)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "GroupSolo", nullable = true, length = 20)
    public String getGroupSolo() {
        return groupSolo;
    }

    public void setGroupSolo(String groupSolo) {
        this.groupSolo = groupSolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistEntity that = (ArtistEntity) o;
        return Objects.equals(artist, that.artist) &&
                Objects.equals(followers, that.followers) &&
                Objects.equals(genres, that.genres) &&
                Objects.equals(numAlbums, that.numAlbums) &&
                Objects.equals(yearFirstAblum, that.yearFirstAblum) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(groupSolo, that.groupSolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, followers, genres, numAlbums, yearFirstAblum, gender, groupSolo);
    }
}
