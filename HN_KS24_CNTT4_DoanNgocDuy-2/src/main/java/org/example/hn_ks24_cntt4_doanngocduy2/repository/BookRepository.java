package org.example.hn_ks24_cntt4_doanngocduy2.repository;

import org.example.hn_ks24_cntt4_doanngocduy2.model.Book;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private static final List<Book> books = Arrays.asList(
            new Book(1, "sách 1", "Nguyễn Văn An", 150000),
            new Book(2, "sách 2", "Nguyễn Văn Bên", 320000),
            new Book(3, "sách 3", "Nguyễn Văn Cên", 450000),
            new Book(4, "sách 4", "Nguyễn Văn Dên", 380000)
    );

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }
}