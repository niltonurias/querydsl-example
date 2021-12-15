package io.github.niltonurias.querydslexample.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RequestMapping("/book")
@RestController
public class BookEndpoint {
    private final BookService service;

    public BookEndpoint(final BookService service) {
        this.service = service;
    }

    @GetMapping
    public Page<BookEntity> findAll(Pageable pageable) {
        return this.service.findAll(pageable);
    }

    @GetMapping("/filter{matrix}")
    public Page<BookEntity> findBy(Pageable pageable,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "author", required = false) String author,
                                   @RequestParam(value = "editor", required = false) String editor,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value = "releaseDate", required = false) LocalDate releaseDate,
                                   @RequestParam(value = "language", required = false) String language,
                                   @RequestParam(value = "genres", required = false) List<String> genres,
                                   @RequestParam(value = "characters", required = false) List<String> characters) {
        BookEntity book = new BookEntity();
        book.setName(name);
        book.setAuthor(author);
        book.setEditor(editor);
        book.setLanguage(language);
        book.setReleaseDate(releaseDate);
        book.setGenres(genres);
        book.setCharacters(characters);

        return this.service.findFiltered(book, pageable);
    }
}
