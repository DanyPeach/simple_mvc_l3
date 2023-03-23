package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.services.BookService;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "books")
public class BookShelfController {
    private Logger logger = Logger.getLogger(BookShelfController.class);
    private BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/shelf")
    public String books(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        logger.info("GET /shelf ");
        return "book_sehelf";
    }

    @PostMapping(value = "/save")
    public String saveBooks(Book book) {
        if(book.getAuthor().isEmpty() && book.getSize() == 0 && book.getTitle().isEmpty()){
            logger.info("POST save book error, all lines are empty");
        } else{
            bookService.save(book);
            logger.info("POST save book completed");
        }
        return "redirect:/books/shelf";
    }

    @PostMapping(value = "/delete")
    public String deleteBook(@RequestParam(value = "bookIdToRemove") Integer id) {
        if (bookService.delete(id)) {
            bookService.delete(id);
            logger.info("POST delete book done");
        } else {
            logger.info("POST delete book false");
        }

        return "redirect:/books/shelf";
    }

    @PostMapping(value = "/removeByRegex")
    public String deleteBooksByQuery(@RequestParam(value = "queryRegex") String query){
        List<Book> list = bookService.deleteByRegex(query);
        bookService.changeAll(list);
        logger.info("retain the collection");
        return "redirect:/books/shelf";
    }
}
