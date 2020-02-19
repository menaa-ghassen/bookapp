package com.example.bookapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("novel")
public class Novel extends Book {
    private String storySummary;

    public Novel() {
    }

    public Novel(String name, double price, Long totalUnitSold, BookCategory category, Date publicationDate, int numberOfPages, List<Stock> stockSet, Author author, String storySummary) {
        super(name, price, totalUnitSold, category, publicationDate, numberOfPages, stockSet, author);
        this.storySummary = storySummary;
    }

    public String getStorySummary() {
        return storySummary;
    }

    public void setStorySummary(String storySummary) {
        this.storySummary = storySummary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Novel novel = (Novel) o;
        return Objects.equals(storySummary, novel.storySummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), storySummary);
    }

    @Override
    public String toString() {
        return "Novel{" +
                "storySummary='" + storySummary + '\'' +
                '}';
    }
}
