package ru.otus.hw_28_feb.dtos;

import ru.otus.hw_28_feb.entities.Book;

import java.util.*;

public class PageDto {
    private List<Book> books;
    private int pageNumber;
    private String pageSize;
    private String title;
    private int totalPages;
    private long totalBooks;


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(long totalBooks) {
        this.totalBooks = totalBooks;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public PageDto(List<Book> books, int pageNumber, String pageSize, String title, int totalPages, long totalBooks) {
        this.books = books;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.title = title;
        this.totalPages = totalPages;
        this.totalBooks = totalBooks;
    }
}
