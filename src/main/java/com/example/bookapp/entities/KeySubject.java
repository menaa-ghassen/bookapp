package com.example.bookapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class KeySubject implements Serializable {
    @Id
    private String keySubject;

    @ManyToOne
    private Magazine magazine;

    public KeySubject() {
    }

    public String getKeySubject() {
        return keySubject;
    }

    public void setKeySubject(String keySubject) {
        this.keySubject = keySubject;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    @Override
    public String toString() {
        return "KeySubject{" +
                "keySubject='" + keySubject + '\'' +
                ", magazine=" + magazine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeySubject that = (KeySubject) o;
        return Objects.equals(keySubject, that.keySubject) &&
                Objects.equals(magazine, that.magazine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keySubject, magazine);
    }
}
