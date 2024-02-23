package ru.otus.hw_28_feb.dtos;


public class BookDto {

    private Long id;
    private String title;

    public BookDto() {
    }

    public BookDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
