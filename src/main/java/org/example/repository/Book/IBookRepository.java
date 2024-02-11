package org.example.repository.Book;


import org.example.model.Books;

import java.util.List;

public interface IBookRepository {
    boolean addBook(Books book);
    Books getBookById(Integer id);
    List<Books> getAllBooks();

    boolean updateBookStatus(Integer bookId, String status);
}
