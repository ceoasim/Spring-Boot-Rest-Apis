package com.api.book.bootrestbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Helps to construct getters, setters, parametarize constructors etc
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

// To change table name
@Table(name = "books")

public class Book {
    @Id
    // Auto generated primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    // To change column name
    @Column(name = "book_id")
    private int id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnoreProperties("books")
    private Author author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_book", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"), inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id"))
    @JsonIgnoreProperties("books")
    private List<Customer> customers = new ArrayList<>();

}
