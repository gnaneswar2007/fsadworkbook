package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // URL: http://localhost:8080/welcome
    // Returns welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // URL: http://localhost:8080/count
    // Returns total number of books
    @GetMapping("/count")
    public int getCount() {
        return 100;
    }

    // URL: http://localhost:8080/price
    // Returns sample book price
    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }

    // URL: http://localhost:8080/books
    // Returns list of book titles
    @GetMapping("/books")
    public List<String> getBooks() {

        List<String> books = new ArrayList<>();

        books.add("Java Programming");
        books.add("Spring Boot Guide");
        books.add("Data Structures");
        books.add("Machine Learning Basics");

        return books;
    }

    // URL: http://localhost:8080/books/{id}
    // Example: http://localhost:8080/books/1
    // Returns book details using PathVariable
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of book with ID: " + id;
    }

    // URL: http://localhost:8080/search?title=Java
    // Accepts request parameter
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book with title: " + title;
    }

    // URL: http://localhost:8080/author/{name}
    // Example: http://localhost:8080/author/James
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // URL: POST http://localhost:8080/addbook
    // Adds book using JSON request body
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {

        bookList.add(book);

        return "Book added successfully";
    }

    // URL: http://localhost:8080/viewbooks
    // Returns all added books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {

        return bookList;
    }
}