package com.api.book.bootrestbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

}
