package org.example.repository.Library;

import org.example.model.*;

import java.util.List;


public interface ILibraryRepository {
    boolean addLibrary(Library library);
    List<Library> getAllLibraries();

    boolean deleteLibraryById(Integer id);
}
