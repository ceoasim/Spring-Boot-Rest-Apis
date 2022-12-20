package com.api.book.bootrestbook.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Helps to construct getters, setters, parametarize constructors etc
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

//To change table name
@Table(name="books")
public class Book {
    @Id
    //Auto generated primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    //To change column name
    @Column(name="book_id")
    private int id;
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;


    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }
    // public String getAuthor() {
    //     return author;
    // }
    // public void setAuthor(String author) {
    //     this.author = author;
    // }
    // @Override
    // public String toString() {
    //     return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    // }
    // public Book() {
    // }
    // public Book(int id, String title, String author) {
    //     this.id = id;
    //     this.title = title;
    //     this.author = author;
    // }

    
}
