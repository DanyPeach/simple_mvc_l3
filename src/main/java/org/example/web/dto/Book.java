package org.example.web.dto;

public class Book {
    private Integer id;
    private String author;
    private String title;
    private int size;

    public Book() {
    }

    public Book(Integer id, String author, String title, int size) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return  author + " " +
                title + " " +
                size;
    }
}
