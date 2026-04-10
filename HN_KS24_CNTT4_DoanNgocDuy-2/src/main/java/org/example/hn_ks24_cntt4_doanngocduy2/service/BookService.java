package org.example.hn_ks24_cntt4_doanngocduy2.service;



import org.example.hn_ks24_cntt4_doanngocduy2.model.Book;
import org.example.hn_ks24_cntt4_doanngocduy2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public boolean isHighPrice(Book book) {
        return book.getPrice() >= 300000;
    }
}