package org.example.app.services;

import org.example.web.dto.Book;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();
    void changeAll(List<Book> books);
    boolean delete(Integer id);
    void store(T book);
    List<Book> deleteBooksByQuery(String regex);
}
