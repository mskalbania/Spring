package com.springdata.controller;

import com.springdata.model.Book;
import com.springdata.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.internal.verification.VerificationModeFactory.times;


public class BookRestControllerTest {

    private BookRestController bookRestController;

    @Mock
    private BookService bookService;

    @Before
    public void setUp() {
        initMocks(this);
        bookRestController = new BookRestController(bookService);
    }

    //TODO ADD MORE TESTS

    @Test
    public void shouldCreateBook() {

        final Book book1 = createDefaultBook(1);
        when(bookService.create(any(Book.class))).thenReturn(1L);

        ResponseEntity<Long> response = bookRestController.create(book1);

        verify(bookService, times(1)).create(any(Book.class));
        assertEquals(response.getBody(), new Long(1));
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void shouldDeleteBook() {

        final long id = 1L;
        when(bookService.delete(id)).thenReturn(true);

        ResponseEntity response = bookRestController.delete(id);

        verify(bookService, times(1)).delete(anyLong());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    private Book createDefaultBook(int bookNumber) {
        return new Book("DefTitle" + bookNumber, "DefAuthor"
                + bookNumber, "Defisbn" + bookNumber, "DefCategeory" + bookNumber);
    }
}