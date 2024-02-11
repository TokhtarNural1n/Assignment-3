package org.example.repository.UserBook;

import org.example.model.Books;

import java.util.List;

public interface IUserBookRepository {
    boolean lendBook(Integer userId, Integer bookId, String status);


}
