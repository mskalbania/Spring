package com.springdata.controller;

import com.springdata.model.Book;
import com.springdata.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;


@Controller
public class ViewController {

    @Autowired
    private BookService bookService;

    //TODO Implement some gui
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome() {
        return "home";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd() {
        return "add";
    }

    @RequestMapping(value = "/bookAddSuccess", method = RequestMethod.POST)
    public String showBookSuccess(@ModelAttribute Book book, ModelMap modelMap) throws IOException {
        bookService.create(book);
        modelMap.addAttribute("book", book);
        return "bookAddSuccess";
    }

    @RequestMapping(value = "/update/{id}")
    public String update(@PathVariable String id, ModelMap modelMap) {
        Book book = bookService.getById(Long.parseLong(id));
        modelMap.addAttribute("book", book);
        return "update";
    }

    @RequestMapping(value = "/bookUpdateSuccess/{id}")
    public String updateSuccess(@PathVariable String id,
                                @ModelAttribute Book book, ModelMap modelMap) {

        book.setId(Long.parseLong(id));
        bookService.update(book);
        Iterable<Book> books = bookService.getAll();
        modelMap.addAttribute("books", books);
        return "browse";
    }

    @RequestMapping(value = "/browse")
    public String showBrowse(ModelMap modelMap) {
        Iterable<Book> books = bookService.getAll();
        modelMap.addAttribute("books", books);
        return "browse";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable String id, ModelMap modelMap) throws InterruptedException {
        bookService.delete(Long.parseLong(id));
        Iterable<Book> books = bookService.getAll();
        modelMap.addAttribute("books", books);
        return "browse";
    }
}
