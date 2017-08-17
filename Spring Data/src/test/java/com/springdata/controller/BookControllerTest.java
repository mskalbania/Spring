package com.springdata.controller;

import com.springdata.model.Book;
import com.springdata.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookControllerTest {

    private BookController bookController;

    @Mock
    private BookService bookService;

    @Before
    public void setUp() {
        initMocks(this);
        bookController = new BookController(bookService);
    }

    @Test
    public void shouldCreateBook() {

        final long expectedId = 1L;
        final Book book = new Book();
        book.setId(1L);

        when(bookService.create(any(Book.class))).thenReturn(book);

        ResponseEntity<Long> response = bookController.create(book);


    }


}