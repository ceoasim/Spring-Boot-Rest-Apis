package com.api.book.bootrestbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "customer")

public class Customer {
    @Id
    // Auto generated primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    // To change column name
    @Column(name = "customer_id")
    private int id;
    private String name;

    @ManyToMany(mappedBy = "customers")
    @JsonIgnoreProperties("customers")
    private List<Book> books = new ArrayList<>();
}
