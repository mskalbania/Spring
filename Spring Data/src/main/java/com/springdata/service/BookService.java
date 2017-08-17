package com.springdata.service;

import com.springdata.model.Book;
import com.springdata.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public long create(Book book) {
        return repository.save(book).getId();
    }

    public boolean delete(long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else return false;
    }

    public Book getById(Long id) {
        return repository.findOne(id);
    }

    public List<Book> getAllContainingString(String s) {

        Iterator<Book> booksIterator = repository.findAll().iterator();
        List<Book> bookList = new ArrayList<>();

        booksIterator.forEachRemaining(bookList::add);
        return bookList.stream()
                .filter(book -> book.getAuthor().contains(s) || book.getTitle().contains(s)
                        || book.getCategory().contains(s) || book.getIsbn().contains(s))

                .collect(Collectors.toList());
    }

    public boolean update(Book book) {
        if (repository.exists(book.getId())) {
            repository.save(book);
            return true;
        } else return false;
    }

    public Iterable<Book> getAll() {
        return repository.findAll();
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
