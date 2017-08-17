package com.springdata;

import com.springdata.model.Book;
import com.springdata.model.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.springdata")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            // save a couple of customers
          //  addBooks(repository);
            repository.save(new Book("Clean Code", "Not Specified", "123123", "PROGRAMMING"));
            repository.save(new Book("Thinking in Java", "Not Specified", "32123", "PROGRAMMING"));
            repository.save(new Book("Design Patterns", "Head First", "543123", "PROGRAMMING"));
            repository.save(new Book("Book4", "Author4", "ISBN4", "CAT4"));
            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Book customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Book customer = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");
        };
    }

    public synchronized void addBooks(BookRepository repo) {

        int threshold = 1000;
        while ((threshold--) >= 0) {
            Book b = new Book("SomeTitle" + threshold, "SomeAuthor" + threshold,
                        "SomeISBN" + threshold, "SomeCategory" + threshold);
            repo.save(b);
        }

    }
}
