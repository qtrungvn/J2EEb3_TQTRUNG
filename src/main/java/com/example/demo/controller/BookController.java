package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // LIST
    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "list";
    }

    // FORM ADD
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    // ADD
    @PostMapping("/add")
    public String add(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    // FORM EDIT
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "edit";
    }

    // EDIT
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute Book book) {
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
