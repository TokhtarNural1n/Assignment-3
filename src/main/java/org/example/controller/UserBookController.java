package org.example.controller;

import org.example.repository.Book.IBookRepository;
import org.example.repository.UserBook.IUserBookRepository;

public class UserBookController {
    private final IUserBookRepository userBookRepository;
    private final IBookRepository bookRepository;

    public UserBookController(IUserBookRepository userBookRepository, IBookRepository bookRepository) {
        this.userBookRepository = userBookRepository;

        this.bookRepository = bookRepository;
    }

    public String addBookToUser(Integer userId, Integer bookId, String status) {
        boolean success = userBookRepository.lendBook(userId, bookId, status);

        if (success) {
            boolean statusUpdate = bookRepository.updateBookStatus(bookId, status);
            return "Book lent to user successfully.";
        } else {
            return "Failed to lend book to user.";
        }
    }


}
