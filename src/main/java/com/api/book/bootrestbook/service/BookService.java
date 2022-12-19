package com.api.book.bootrestbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "Spring boot training", "xyz"));
        list.add(new Book(2, "Spring boot training", "xyz"));
        list.add(new Book(3, "Spring boot training", "xyz"));
        list.add(new Book(4, "Spring boot training", "xyz"));
        list.add(new Book(5, "Spring boot training", "xyz"));

    }

    // Get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // Get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {

            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // Add new book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    // Delete new book
    public void deleteBook(int bId) {
        list = list.stream().filter(book -> book.getId() != bId).collect(Collectors.toList());
    }

    // Update book
    public void updateBook(Book book, int bId) {
        list = list.stream().map(b -> {
            if (b.getId() == bId) {
                b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
            }
            return b;
        }).collect(Collectors.toList());
    }

}
