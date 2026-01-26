package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // Constructor Injection (khuyên dùng)
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET: lấy tất cả sách
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET: lấy sách theo id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // POST: thêm sách
    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    // PUT: cập nhật sách
    @PutMapping("/{id}")
    public void updateBook(
            @PathVariable int id,
            @RequestBody Book book
    ) {
        bookService.updateBook(id, book);
    }

    // DELETE: xóa sách
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
