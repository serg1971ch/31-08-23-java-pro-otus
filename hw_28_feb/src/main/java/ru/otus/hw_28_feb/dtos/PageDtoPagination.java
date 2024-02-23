package ru.otus.hw_28_feb.dtos;


public class PageDtoPagination{
    private String title;
    private String size;
    private  int count;
    private int numberPage;
    private int totalBooks;

    public PageDtoPagination(String title, String size, int count) {
        this.title = title;
        this.size = size;
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public String getSize() {
        return size;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public int getTotalBooks() {
        return totalBooks;
    }
}
