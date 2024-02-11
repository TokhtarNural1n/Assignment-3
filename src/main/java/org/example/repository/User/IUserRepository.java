package org.example.repository.User;

import org.example.model.Books;
import org.example.model.Library;
import org.example.model.User;

import java.util.List;

public interface IUserRepository {
    boolean addUser(User user);
    List<User> getAllUsers();
    List<User> getUserById(Integer id);
    boolean deleteUserById(Integer id);
}
