package ru.otus.hw_28_feb.dtos;

public class CommentBookDto {
    private long id;
    private String title;
    private double rate;

    public CommentBookDto(long id, String title, double rate) {
        this.id = id;
        this.title = title;
        this.rate = rate;
    }

    public CommentBookDto() {

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

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
