package ru.otus.hw_28_feb.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table("COMMENTS")
public class Comment {
    @Id
    private Long id;
    private String name;
    private String text;
    private int rate;
    private Date date;

    @PersistenceCreator
    public Comment(Long id, String name, String text, int rate, Date date) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.rate = rate;
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
