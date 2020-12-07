package com.example.cis550.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GrammyAlbumsEntityPK implements Serializable {
    private String award;
    private int grammyYear;

    @Column(name = "Award", nullable = false, length = 255)
    @Id
    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Column(name = "GrammyYear", nullable = false)
    @Id
    public int getGrammyYear() {
        return grammyYear;
    }

    public void setGrammyYear(int grammyYear) {
        this.grammyYear = grammyYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrammyAlbumsEntityPK that = (GrammyAlbumsEntityPK) o;
        return grammyYear == that.grammyYear &&
                Objects.equals(award, that.award);
    }

    @Override
    public int hashCode() {
        return Objects.hash(award, grammyYear);
    }
}
