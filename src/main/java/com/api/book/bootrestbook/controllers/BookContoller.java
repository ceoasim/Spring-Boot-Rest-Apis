package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.dao.AuthorRepository;
import com.api.book.bootrestbook.dao.CustomerRepository;
import com.api.book.bootrestbook.entities.Author;
import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.entities.Customer;
import com.api.book.bootrestbook.service.BookService;

@RestController
public class BookContoller {

  @Autowired
  private BookService bookService;

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private CustomerRepository customerRepository;

  // 1st way to for request mapping
  // @RequestMapping(value= "/test", method = RequestMethod.GET)

  // 2nd way to for request mapping
  @GetMapping("/books")
  public ResponseEntity<List<Book>> getBooks() {

    // Set single item
    // Book book = new Book();
    // book.setId(1);
    // book.setTitle("Spring Boot Training");
    // book.setAuthor("Asim");
    // return book;

    List<Book> list = bookService.getAllBooks();
    if (list.size() <= 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(list));
  }

  @GetMapping("/books/{id}")
  public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

    Book book = bookService.getBookById(id);
    if (book == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(book));

  }

  @GetMapping("/books/author/{id}")
  public ResponseEntity<?> getAuthorBooks(@PathVariable("id") int id) {

    Author author = authorRepository.findById(id).get();
    if (author == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(author));

  }

  @GetMapping("/customers")
  public ResponseEntity<?> getAllCustomers() {

    Iterable<Customer> customer = customerRepository.findAll();

    if (customer == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(customer));

  }

  // find by title
  @GetMapping("/books/title/{title}")
  public ResponseEntity<Book> getBook(@PathVariable("title") String title) {

    Book book = bookService.getBookByTitle(title);
    if (book == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(book));

  }

  // Post method to add new book

  @PostMapping("/books")
  public ResponseEntity<Book> addBook(@RequestBody Book book) {

    System.out.println(book);

    Book b = null;

    try {
      b = this.bookService.addBook(book);
      return ResponseEntity.of(Optional.of(b));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  // Delete method book
  @DeleteMapping("/books/{bookId}")
  public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
    try {
      this.bookService.deleteBook(bookId);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  // Update method book
  @PutMapping("/books/{bookId}")
  public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {

    try {
      this.bookService.updateBook(book, bookId);
      return ResponseEntity.ok().body(book);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
