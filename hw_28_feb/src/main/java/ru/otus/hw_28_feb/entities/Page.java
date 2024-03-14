package ru.otus.hw_28_feb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("PAGES")
public class Page {
    @Id
    private Long id;
    private int count;

    @PersistenceCreator
    public Page(Long id, int count) {
        this.id = id;
        this.count = count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public int getCount() {
        return count;
    }
}
