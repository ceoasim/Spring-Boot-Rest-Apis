package com.api.book.bootrestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Static method
    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(1, "Spring boot training", "xyz"));
    // list.add(new Book(2, "Spring boot training", "xyz"));
    // list.add(new Book(3, "Spring boot training", "xyz"));
    // list.add(new Book(4, "Spring boot training", "xyz"));
    // list.add(new Book(5, "Spring boot training", "xyz"));

    // }

    // Get all books by static method
    // public List<Book> getAllBooks() {
    // return list;
    // }

    // Get all books by dynamic method
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // Get single book by id with static method
    // public Book getBookById(int id) {
    // Book book = null;
    // try {

    // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return book;
    // }

    // Get single book by id with dynamic method
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // Get single book by title with dynamic method
    public Book getBookByTitle(String title) {
        Book book = null;
        try {
            book = this.bookRepository.findByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // Add new book by static method
    // public Book addBook(Book b) {
    // list.add(b);
    // return b;
    // }

    // Add new book by dynamic methos
    public Book addBook(Book b) {
        Book book = this.bookRepository.save(b);
        return book;
    }

    // Delete new book static method
    // public void deleteBook(int id) {
    // list = list.stream().filter(book -> book.getId() !=
    // id).collect(Collectors.toList());
    // }

    // Delete new book dynamic method
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    // Update book by static method
    // public void updateBook(Book book, int id) {
    // list = list.stream().map(b -> {
    // if (b.getId() == id) {
    // b.setAuthor(book.getAuthor());
    // b.setTitle(book.getTitle());
    // }
    // return b;
    // }).collect(Collectors.toList());
    // }

    // Update book by dynamic method
    public void updateBook(Book book, int id) {
        book.setId(id);
        bookRepository.save(book);
    }
}
