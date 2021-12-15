package io.github.niltonurias.querydslexample.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(final BookRepository repository) {
        this.repository = repository;
    }

    public Page<BookEntity> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Page<BookEntity> findFiltered(BookEntity book, Pageable pageable) {
        return this.repository.findAll(BookQuery.simpleFilter(book), pageable);
    }
}
