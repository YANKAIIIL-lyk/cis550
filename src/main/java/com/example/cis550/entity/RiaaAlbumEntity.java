package com.example.cis550.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "riaaAlbum", schema = "project", catalog = "")
@IdClass(RiaaAlbumEntityPK.class)
public class RiaaAlbumEntity {
    private String album;
    private String artist;
    private String status;
    private String label;

    @Id
    @Column(name = "Album", nullable = false, length = 255)
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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
    @Column(name = "Status", nullable = true, length = 255)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        RiaaAlbumEntity that = (RiaaAlbumEntity) o;
        return Objects.equals(album, that.album) &&
                Objects.equals(artist, that.artist) &&
                Objects.equals(status, that.status) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album, artist, status, label);
    }
}
