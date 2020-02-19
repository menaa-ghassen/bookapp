package com.example.bookapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Library implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long libraryId;

    private String name;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<Stock> stockSet;

    public Library() {
    }

    public Library(String name, String address, List<Stock> stockSet) {
        this.name = name;
        this.address = address;
        this.stockSet = stockSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public List<Stock> getStockSet() {
        return stockSet;
    }

    public void setStockSet(List<Stock> stockSet) {
        this.stockSet = stockSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(libraryId, library.libraryId) &&
                Objects.equals(name, library.name) &&
                Objects.equals(address, library.address) &&
                Objects.equals(stockSet, library.stockSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, name, address, stockSet);
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryId=" + libraryId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", stockSet=" + stockSet +
                '}';
    }
}
