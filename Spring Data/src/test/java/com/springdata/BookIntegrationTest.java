package com.springdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springdata.model.Book;
import com.springdata.model.BookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookIntegrationTest {

    private ObjectMapper objectMapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = webAppContextSetup(context).build();
    }

    @After
    public void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    public void shouldFindAllBooks() throws Exception {

        final Book book1 = bookRepository.save(createDefaultBook(1));
        final Book book2 = bookRepository.save(createDefaultBook(2));
        final Book book3 = bookRepository.save(createDefaultBook(3));

        final String expected = convertBooksToString(book1, book2, book3);

        mockMvc.perform(MockMvcRequestBuilders.get("/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(expected));
    }

    @Test
    public void shouldCreateBook() throws Exception {

        final Book book1 = createDefaultBook(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                .content(objectMapper.writeValueAsBytes(book1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldFindCorrectBookById() throws Exception {

        final Book book1 = bookRepository.save(createDefaultBook(1));

        final String expected = convertBooksToString(book1);

        mockMvc.perform(MockMvcRequestBuilders.get("/getById/" + book1.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(expected));

    }

    @Test
    public void shouldDeleteBook() throws Exception {

        final Book book1 = bookRepository.save(createDefaultBook(1));

        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/" + book1.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        assertEquals(bookRepository.exists(book1.getId()), false);
    }

    @Test
    public void shouldUpdateBook() throws Exception {

        final Book book1 = bookRepository.save(createDefaultBook(1));
        final Book book2 = createDefaultBook(2);
        book2.setId(book1.getId());

        final String expected = objectMapper.writeValueAsString(book2);

        mockMvc.perform(MockMvcRequestBuilders.put("/update")
                .content(objectMapper.writeValueAsBytes(book2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(expected));
    }

    private Book createDefaultBook(int bookNumber) {
        return new Book("DefTitle" + bookNumber, "DefAuthor"
                + bookNumber, "Defisbn" + bookNumber, "DefCategeory" + bookNumber);
    }

    private String convertBooksToString(Book... books) throws JsonProcessingException {
        if (books.length == 1) {
            return objectMapper.writeValueAsString(books[0]);
        } else {
            List<Book> bookList = Arrays.asList(books);
            return objectMapper.writeValueAsString(bookList);
        }
    }
}
