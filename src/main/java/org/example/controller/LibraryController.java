package org.example.controller;

import org.example.model.Library;
import org.example.repository.Book.IBookRepository;
import org.example.repository.Library.ILibraryRepository;
import org.example.repository.User.IUserRepository;

import java.util.List;

public class LibraryController {

    private final ILibraryRepository libraryRepository;
    private final IBookRepository bookRepository;
    private final IUserRepository userRepository;

    public LibraryController(ILibraryRepository libraryRepository, IBookRepository bookRepository, IUserRepository userRepository) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public String addLibrary(String name, String address){
        Library library = new Library(name, address);
        boolean added = libraryRepository.addLibrary(library);
        return (added ? "Library was added!" : "Library addition was failed!");
    }

    public String getAllLibraries() {
        List<Library> libraries = libraryRepository.getAllLibraries();

        StringBuilder response = new StringBuilder();
        for (Library library: libraries) {
            response.append(library.toString()).append("\n");
        }

        return response.toString();
    }

    public String deleteLibrary(Integer libraryId) {
        boolean success = libraryRepository.deleteLibraryById(libraryId);

        if (success) {
            return "Library deleted successfully.";
        } else {
            return "Failed to delete library.";
        }
    }
}
