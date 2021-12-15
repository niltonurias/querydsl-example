package io.github.niltonurias.querydslexample.book;

import com.querydsl.core.BooleanBuilder;
import io.github.niltonurias.querydslexample.book.QBookEntity;

import static java.util.Objects.isNull;
import static org.springframework.util.ObjectUtils.isEmpty;

public class BookQuery {
    public static BooleanBuilder simpleFilter(BookEntity book) {
        QBookEntity bookEntity = QBookEntity.bookEntity;
        BooleanBuilder builder = new BooleanBuilder();

        if (!isNull(book.getAuthor())) {
            builder.or(bookEntity.author.containsIgnoreCase(book.getAuthor()));
        }

        if (!isNull(book.getEditor())) {
            builder.or(bookEntity.editor.containsIgnoreCase(book.getEditor()));
        }

        if (!isNull(book.getLanguage())) {
            builder.or(bookEntity.language.containsIgnoreCase(book.getLanguage()));
        }

        if (!isNull(book.getName())) {
            builder.or(bookEntity.name.containsIgnoreCase(book.getName()));
        }

        if (!isNull(book.getReleaseDate())) {
            builder.or(bookEntity.releaseDate.eq(book.getReleaseDate()));
        }

        if (!isEmpty(book.getCharacters())) {
            book.getCharacters().forEach(characters -> builder.or(bookEntity.characters.any().containsIgnoreCase(characters)));
        }

        if (!isEmpty(book.getGenres())) {
            book.getGenres().forEach(genre -> builder.or(bookEntity.genres.any().containsIgnoreCase(genre)));
        }

        return builder;
    }
}
