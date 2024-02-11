package org.example.controller;

import org.example.model.Library;
import org.example.model.User;
import org.example.repository.Library.ILibraryRepository;
import org.example.repository.User.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository userRepository;

    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(String name, String groupName, Integer library_id){
        User user = new User(name, groupName, library_id);
        boolean added = userRepository.addUser(user);
        return (added ? "User was added!" : "User addition was failed!");
    }

    public String getAllUsers() {
        List<User> users = userRepository.getAllUsers();

        StringBuilder response = new StringBuilder();
        for (User user: users) {
            response.append(user.toString()).append("\n");
        }

        return response.toString();
    }
}
