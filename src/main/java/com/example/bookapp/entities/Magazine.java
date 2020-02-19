package com.example.bookapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Book {
    private Date netReleaseDate;

    @JsonIgnore
    @OneToMany(mappedBy = "magazine")
    private Set<KeySubject> keySubjects;

    public Date getNetReleaseDate() {
        return netReleaseDate;
    }

    public void setNetReleaseDate(Date netReleaseDate) {
        this.netReleaseDate = netReleaseDate;
    }

    public Magazine() {

    }

    public Magazine(String name, double price, Long totalUnitSold, BookCategory category, Date publicationDate, int numberOfPages, List<Stock> stockSet, Author author, Date netReleaseDate, Set<KeySubject> keySubjects) {
        super(name, price, totalUnitSold, category, publicationDate, numberOfPages, stockSet, author);
        this.netReleaseDate = netReleaseDate;
        this.keySubjects = keySubjects;
    }

    public Set<KeySubject> getKeySubjects() {
        return keySubjects;
    }

    public void setKeySubjects(Set<KeySubject> keySubjects) {
        this.keySubjects = keySubjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(netReleaseDate, magazine.netReleaseDate) &&
                Objects.equals(keySubjects, magazine.keySubjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), netReleaseDate, keySubjects);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "netReleaseDate=" + netReleaseDate +
                ", keySubjects=" + keySubjects +
                '}';
    }
}
