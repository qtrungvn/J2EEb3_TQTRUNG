package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public void updateBook(int id, Book book) {
        Book old = getBookById(id);
        if (old != null) {
            old.setTitle(book.getTitle());
            old.setAuthor(book.getAuthor());
        }
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
    }
}
