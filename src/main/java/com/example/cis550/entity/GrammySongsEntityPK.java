package com.example.cis550.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GrammySongsEntityPK implements Serializable {
    private String grammyAward;
    private int grammyYear;

    @Column(name = "GrammyAward", nullable = false, length = 255)
    @Id
    public String getGrammyAward() {
        return grammyAward;
    }

    public void setGrammyAward(String grammyAward) {
        this.grammyAward = grammyAward;
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
        GrammySongsEntityPK that = (GrammySongsEntityPK) o;
        return grammyYear == that.grammyYear &&
                Objects.equals(grammyAward, that.grammyAward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grammyAward, grammyYear);
    }
}
