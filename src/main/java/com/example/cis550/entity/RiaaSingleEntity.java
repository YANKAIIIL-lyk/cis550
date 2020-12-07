package com.example.cis550.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "riaaSingle", schema = "project", catalog = "")
@IdClass(RiaaSingleEntityPK.class)
public class RiaaSingleEntity {
    private String songName;
    private String artist;
    private String riaaStatus;
    private String label;

    @Id
    @Column(name = "SongName", nullable = false, length = 255)
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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
    @Column(name = "RiaaStatus", nullable = true, length = 255)
    public String getRiaaStatus() {
        return riaaStatus;
    }

    public void setRiaaStatus(String riaaStatus) {
        this.riaaStatus = riaaStatus;
    }

    @Basic
    @Column(name = "Label", nullable = true, length = 255)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiaaSingleEntity that = (RiaaSingleEntity) o;
        return Objects.equals(songName, that.songName) &&
                Objects.equals(artist, that.artist) &&
                Objects.equals(riaaStatus, that.riaaStatus) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName, artist, riaaStatus, label);
    }
}
