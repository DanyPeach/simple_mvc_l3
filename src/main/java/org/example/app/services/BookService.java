package org.example.app.services;

import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final ProjectRepository<Book> bookRepository;

    @Autowired
    public BookService(ProjectRepository<Book> bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.retreiveAll();
    }

    public void save(Book book){
        bookRepository.store(book);
    }

    public void changeAll(List<Book> books){
        bookRepository.changeAll(books);
    }

    public List<Book> deleteByRegex(String q){
        return bookRepository.deleteBooksByQuery(q);
    }

    public boolean delete(Integer id){ return bookRepository.delete(id);}
}
