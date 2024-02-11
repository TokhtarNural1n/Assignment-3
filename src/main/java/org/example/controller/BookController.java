package org.example.controller;

import org.example.model.Books;
import org.example.repository.Book.IBookRepository;

import java.util.List;

public class BookController {
    private final IBookRepository bookRepository;


    public BookController(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    title, isbn, genre, author, year, quantity
    public String addBook(String title, String isbn, String genre, String author, Integer year, Integer library_id, String status) {
        Books book = new Books(title, isbn, genre, author, year, library_id, status);
        boolean added = bookRepository.addBook(book);
        return (added ? "Book was add!" : "Book addition was failed!");

    }

    public String getAllAvailableBooks() {
        List<Books> booksList = bookRepository.getAllBooks();


        StringBuilder response = new StringBuilder();
        for (Books book: booksList) {
            if(book.getStatus().equals("available")) {
                response.append(book.toString()).append("\n");
            }else {

            }
        }
        return response.toString();
    }

    public String getBookById(Integer id) {
        Books book = bookRepository.getBookById(id);

        return book.toString();
    }
    public String getAllBooks() {
        List<Books> booksList = bookRepository.getAllBooks();


        StringBuilder response = new StringBuilder();
        for (Books book: booksList) {
            response.append(book.toString()).append("\n");
        }
        return response.toString();
    }
}
