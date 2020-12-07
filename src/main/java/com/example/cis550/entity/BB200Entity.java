package com.example.cis550.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BB200", schema = "project", catalog = "")
@IdClass(BB200EntityPK.class)
public class BB200Entity {
    private String artists;
    private String albumName;
    private Integer weeklyRank;
    private Integer peak;
    private Integer weeksChart;
    private String week;
    private Integer date;
    private String genre;

    @Id
    @Column(name = "Artists", nullable = false, length = 255)
    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    @Id
    @Column(name = "AlbumName", nullable = false, length = 255)
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Basic
    @Column(name = "WeeklyRank", nullable = true)
    public Integer getWeeklyRank() {
        return weeklyRank;
    }

    public void setWeeklyRank(Integer weeklyRank) {
        this.weeklyRank = weeklyRank;
    }

    @Basic
    @Column(name = "Peak", nullable = true)
    public Integer getPeak() {
        return peak;
    }

    public void setPeak(Integer peak) {
        this.peak = peak;
    }

    @Basic
    @Column(name = "WeeksChart", nullable = true)
    public Integer getWeeksChart() {
        return weeksChart;
    }

    public void setWeeksChart(Integer weeksChart) {
        this.weeksChart = weeksChart;
    }

    @Id
    @Column(name = "Week", nullable = false, length = 255)
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Basic
    @Column(name = "Date", nullable = true)
    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Genre", nullable = true, length = 255)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BB200Entity that = (BB200Entity) o;
        return Objects.equals(artists, that.artists) &&
                Objects.equals(albumName, that.albumName) &&
                Objects.equals(weeklyRank, that.weeklyRank) &&
                Objects.equals(peak, that.peak) &&
                Objects.equals(weeksChart, that.weeksChart) &&
                Objects.equals(week, that.week) &&
                Objects.equals(date, that.date) &&
                Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artists, albumName, weeklyRank, peak, weeksChart, week, date, genre);
    }
}
