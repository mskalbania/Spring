package com.springdata.controller;

import com.springdata.model.Book;
import com.springdata.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("ALL")
@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "Simple CRUD Book interface";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Long> create(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.create(book).getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Book temp = bookService.getById(id);
        if (temp != null) {
            return new ResponseEntity<Book>(bookService.getById(id), HttpStatus.OK);
        }
        return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
    }

    //Experimental
    @RequestMapping(value = "/getAllContaining/{s}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Book>> getByString(@PathVariable String s) {
        Iterable<Book> results = bookService.getAllContainingString(s);
        if (results.iterator().hasNext()) return new ResponseEntity<Iterable<Book>>(results, HttpStatus.OK);
        else return new ResponseEntity<Iterable<Book>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        if (bookService.delete(id)) return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Book> update(@RequestBody Book book) {
        if (bookService.update(book)) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Book>> getAll() {
        return new ResponseEntity<Iterable<Book>>(bookService.getAll(), HttpStatus.OK);
    }


}
