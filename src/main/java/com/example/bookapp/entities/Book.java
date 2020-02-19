package com.example.bookapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "bookType", discriminatorType = DiscriminatorType.STRING)
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String name;
    private double price;
    private Long totalUnitSold;
    private BookCategory category;
    private Date publicationDate;
    private int numberOfPages;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Stock> stockSet;

    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String name, double price, Long totalUnitSold, BookCategory category, Date publicationDate, int numberOfPages, List<Stock> stockSet, Author author) {
        this.name = name;
        this.price = price;
        this.totalUnitSold = totalUnitSold;
        this.category = category;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
        this.stockSet = stockSet;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getTotalUnitSold() {
        return totalUnitSold;
    }

    public void setTotalUnitSold(Long totalUnitSold) {
        this.totalUnitSold = totalUnitSold;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public List<Stock> getStockSet() {
        return stockSet;
    }

    public void setStockSet(List<Stock> stockSet) {
        this.stockSet = stockSet;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                numberOfPages == book.numberOfPages &&
                Objects.equals(bookId, book.bookId) &&
                Objects.equals(name, book.name) &&
                Objects.equals(totalUnitSold, book.totalUnitSold) &&
                category == book.category &&
                Objects.equals(publicationDate, book.publicationDate) &&
                Objects.equals(stockSet, book.stockSet) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, name, price, totalUnitSold, category, publicationDate, numberOfPages, stockSet, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", TotalUnitSold=" + totalUnitSold +
                ", category=" + category +
                ", publicationDate=" + publicationDate +
                ", numberOfPages=" + numberOfPages +
                ", stockSet=" + stockSet +
                ", author=" + author +
                '}';
    }
}
