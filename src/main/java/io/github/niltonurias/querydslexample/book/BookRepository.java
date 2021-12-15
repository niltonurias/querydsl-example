package io.github.niltonurias.querydslexample.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID>, QuerydslPredicateExecutor<BookEntity> {
}
