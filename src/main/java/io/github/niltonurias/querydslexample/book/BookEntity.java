package io.github.niltonurias.querydslexample.book;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class BookEntity {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private LocalDate releaseDate;
    private String author;
    private String language;
    private String editor;

    @ElementCollection
    private List<String> genres = new java.util.ArrayList<>();

    @ElementCollection
    private List<String> characters = new java.util.ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookEntity that = (BookEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
