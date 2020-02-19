package com.example.bookapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*@JsonIgnore*/
    @ManyToOne()
    private Library library;
    /*@JsonIgnore*/
    @ManyToOne()
    private Book book;

    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return quantity == stock.quantity &&
                Objects.equals(id, stock.id) &&
                Objects.equals(library, stock.library) &&
                Objects.equals(book, stock.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, library, book, quantity);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", library=" + library +
                ", book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}
