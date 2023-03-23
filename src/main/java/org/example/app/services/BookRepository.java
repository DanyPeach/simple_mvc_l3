package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class BookRepository implements ProjectRepository<Book>{
    private Logger logger = Logger.getLogger(BookRepository.class);
    private List<Book> bookList = new ArrayList<>();

    @Override
    public List<Book> retreiveAll() {
        return bookList;
    }

    @Override
    public void changeAll(List<Book> books) {
        bookList.removeAll(books);
    }

    @Override
    public List<Book> deleteBooksByQuery(String regex) {
        List<Book> deletedBooks = new ArrayList<>();
        Iterator<Book> it = retreiveAll().iterator();
        Pattern pattern = Pattern.compile(regex);
        while (it.hasNext()) {
            Book book = it.next();
            Matcher matcher = pattern.matcher(book.toString());
            if (matcher.find()) {
                deletedBooks.add(book);
                it.remove();
            }
        }
        return deletedBooks;
    }

    @Override
    public boolean delete(Integer id) {
        for(Book i : bookList){
            if(i.getId().equals(id)){
                logger.info("deleting book");
                return bookList.remove(i);
            }
        }
        return false;
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("store book" + book.getId());
        bookList.add(book);
    }
}
