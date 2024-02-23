package ru.otus.hw_28_feb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;


@Table("AUTHORS")
public class Author {
    @Id
    private Long id;
    private String fullName;
    @MappedCollection(idColumn = "AUTHOR_ID")
    private Set<Book> books;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @PersistenceCreator
    public Author(Long id, String fullName, Set<Book> books) {
        this.id = id;
        this.fullName = fullName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public Set<Book> getBooks() {
        return books;
    }
}