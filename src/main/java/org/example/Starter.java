package org.example;

import org.example.controller.BookController;
import org.example.controller.LibraryController;
import org.example.controller.UserBookController;
import org.example.controller.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Starter {
    private final BookController bookController;
    private final LibraryController libraryController;
    private final UserController userController;
    private final UserBookController userBookController;
    private final Scanner scanner;

    public Starter(BookController bookController, LibraryController libraryController, UserController userController, UserBookController userBookController) {
        this.bookController = bookController;
        this.libraryController = libraryController;
        this.userController = userController;
        this.userBookController = userBookController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            System.out.println("Hello! You have the following available functions:");
            System.out.println("1) Add a new book;");
            System.out.println("2) Add a new user;");
            System.out.println("3) Add a new library;");
            System.out.println("4) Show all available books;");
            System.out.println("5) Show all libraries;");
            System.out.println("6) Show all users;");
            System.out.println("7) Lend book;");
            System.out.println("8) Delete library by id;");
            System.out.println("9) Show all books;");
            System.out.println("10) Show book by id: ");
            System.out.println("0) Exit");

            try {
                System.out.print("Enter option (1-10): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    addBookMethod();
                } else if(option == 2){
                    addUserMethod();
                }else if(option == 3) {
                    addLibraryMethod();
                }else if(option == 4) {
                    getAllAvailableBooksMethod();
                }else if(option == 5) {
                    getAllLibrariesMethod();
                }else if(option == 6) {
                    getAllUsersMethod();
                }else if(option == 7) {
                    lendBookMethod();
                } else if(option == 8) {
                    deleteLibraryByIdMethod();
                }else if(option == 9) {
                    getAllBooks();
                }else if(option == 10) {
                    getBookById();
                }else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e);
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("*************************");
        }
    }
    public void getAllAvailableBooksMethod () {
        String response = bookController.getAllAvailableBooks();
        System.out.println(response);
    }

    public void getAllBooks() {
        String response = bookController.getAllBooks();
        System.out.println(response);
    }

    public void getBookById() {
        System.out.println("Enter book id: ");
        Integer bookId = scanner.nextInt();
        String response = bookController.getBookById(bookId);
        System.out.println(response);
    }

    public void getAllLibrariesMethod () {
        String response = libraryController.getAllLibraries();
        System.out.println(response);
    }

    public void getAllUsersMethod () {
        String response = userController.getAllUsers();
        System.out.println(response);
    }



    public void deleteLibraryByIdMethod(){
        System.out.println("Enter library id: ");
        Integer libraryId = scanner.nextInt();
        String response = libraryController.deleteLibrary(libraryId);
        System.out.println(response);
    }
    public void lendBookMethod() {
        System.out.print("Enter user id: ");
        Integer userId = scanner.nextInt();
        System.out.print("Enter book id: ");
        Integer bookId = scanner.nextInt();
        System.out.print("Enter status: ");
        String status = scanner.next();

        String response = userBookController.addBookToUser(userId, bookId, status);
        System.out.println(response);
    }

    public void addBookMethod() {
        System.out.print("Enter item title: ");
        String title = scanner.next();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.next();
        System.out.print("Enter genre: ");
        String genre = scanner.next();
        System.out.print("Enter author: ");
        String author = scanner.next();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();

        System.out.print("Enter library id: ");
        int library_id = scanner.nextInt();
        System.out.print("Enter status: ");
        String status = scanner.next();


        String response = bookController.addBook(title, isbn, genre, author, year, library_id, status);
        System.out.println(response);
    }

    public void addLibraryMethod() {
        System.out.print("Enter library name: ");
        String name = scanner.next();
        System.out.print("Enter library address: ");
        String address = scanner.next();


        String response = libraryController.addLibrary(name, address);
        System.out.println(response);
    }

    public void addUserMethod() {
        System.out.print("Enter user name: ");
        String name = scanner.next();
        System.out.print("Enter user group: ");
        String groupName = scanner.next();
        System.out.print("Enter library id: ");
        int library_id = scanner.nextInt();



        String response = userController.addUser(name, groupName, library_id);
        System.out.println(response);
    }
}
