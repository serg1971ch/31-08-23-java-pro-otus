package ru.otus.hw_28_feb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("FORMATS")
public class FormatPage {
    @Id
    private Long id;
    private String size;
    private int width;
    private int height;

    @MappedCollection(idColumn = "PAGE_FORMAT_ID")
    private Page  page;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    @PersistenceCreator
    public FormatPage(Long id, String size, int width, int height, Page page) {
        this.id = id;
        this.size = size;
        this.width = width;
        this.height = height;
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
