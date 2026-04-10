package org.example.hn_ks24_cntt4_doanngocduy2.controller;

import org.example.hn_ks24_cntt4_doanngocduy2.model.Book;
import org.example.hn_ks24_cntt4_doanngocduy2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Danh Sách Sách");
        return "pages/list";
    }

    @GetMapping("/{id}")
    public String bookDetail(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        model.addAttribute("isHighPrice", bookService.isHighPrice(book));
        model.addAttribute("pageTitle", "Chi Tiết: " + book.getTitle());
        return "pages/detail";
    }
}