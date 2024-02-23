package ru.otus.hw_28_feb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import java.util.*;
import java.util.Set;

@Table("BOOKS")
public class Book {
    @Id
    private Long id;
    private String title;

    @MappedCollection(idColumn = "BOOK_ID")
    private Set<Page>  pages;

    @MappedCollection(idColumn = "COMMENT_BOOK_ID")
    private Set<Comment> comments;

//    @PersistenceCreator
//    public Book(Long id, String title, Long authorId) {
//        this.id = id;
//        this.title = title;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    public Set<Page> getPages() {
        return pages;
    }
}
