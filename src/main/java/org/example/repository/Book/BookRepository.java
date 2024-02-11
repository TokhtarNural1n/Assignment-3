package org.example.repository.Book;

import org.example.DB.IDbFunctions;
import org.example.model.Books;
import org.example.repository.Book.IBookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

    private final IDbFunctions db;

    public BookRepository(IDbFunctions db) {
        this.db = db;
    }

    @Override
    public boolean addBook(Books book) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO book(title, isbn, genre, author, year, library_id, status) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, book.getTitle());
            st.setString(2, book.getIsbn());
            st.setString(3, book.getGenre());
            st.setString(4, book.getAuthor());
            st.setInt(5, book.getYear());
            st.setInt(6, book.getLibraryId());
            st.setString(7, book.getStatus());

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public Books getBookById(Integer id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT * FROM book WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();


            if (rs.next()) {
                return new Books(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("isbn"),
                        rs.getString("genre"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getInt("library_id"),
                        rs.getString("status"));
            }else {

                return null;
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<Books> getAllBooks() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT * FROM book";
            Statement st = con.createStatement();


            ResultSet rs = st.executeQuery(sql);
            List<Books> booksList = new ArrayList<>();


            while (rs.next()) {
                Books book = new Books(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("isbn"),
                        rs.getString("genre"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getInt("library_id"),
                        rs.getString("status"));

                booksList.add(book);
            }

            return booksList;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean updateBookStatus(Integer bookId, String status) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "UPDATE Book SET status = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, status);
            st.setInt(2, bookId);

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage());
            }
        }
        return false;
    }

}
