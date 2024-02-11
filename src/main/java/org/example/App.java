package org.example;

import org.example.DB.DbFunctions;
import org.example.DB.IDbFunctions;
import org.example.controller.BookController;
import org.example.controller.LibraryController;
import org.example.controller.UserBookController;
import org.example.controller.UserController;
import org.example.repository.Book.BookRepository;
import org.example.repository.Book.IBookRepository;
import org.example.repository.Library.ILibraryRepository;
import org.example.repository.Library.LibraryRepository;
import org.example.repository.User.IUserRepository;
import org.example.repository.User.UserRepository;
import org.example.repository.UserBook.IUserBookRepository;
import org.example.repository.UserBook.UserBookRepository;


public class App 
{
    public static void main( String[] args )
    {
        IDbFunctions conn = new DbFunctions();
        IBookRepository bookRepository = new BookRepository(conn);
        BookController bookController = new BookController(bookRepository);
        ILibraryRepository libraryRepository = new LibraryRepository(conn);
        IUserRepository userRepository = new UserRepository(conn);
        LibraryController libraryController = new LibraryController(libraryRepository, bookRepository, userRepository);

        UserController userController = new UserController(userRepository);

        IUserBookRepository userBookRepository = new UserBookRepository(conn);
        UserBookController userBookController = new UserBookController(userBookRepository, bookRepository);

        Starter starter = new Starter(bookController, libraryController, userController, userBookController);
        starter.start();
    }
}
