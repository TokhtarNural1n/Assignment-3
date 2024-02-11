package org.example.repository.Library;

import org.example.DB.IDbFunctions;
import org.example.model.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryRepository implements ILibraryRepository{

    private final IDbFunctions db;

    public LibraryRepository(IDbFunctions db) {
        this.db = db;
    }

    @Override
    public boolean addLibrary(Library library) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO library(name, address) VALUES ( ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, library.getName());
            st.setString(2, library.getAddress());

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
    public List<Library> getAllLibraries() {

        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id, name, address FROM library";
            Statement st = con.createStatement();


            ResultSet rs = st.executeQuery(sql);
            List<Library> libraries = new ArrayList<>();


            while (rs.next()) {
                Library library = new Library(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"));

                libraries.add(library);
            }

            return libraries;
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
    public boolean deleteLibraryById(Integer id) {
        Connection con = null;

        try {
            con = db.getConnection();

            String deleteUserBookSql = "DELETE FROM user_book WHERE book_id IN (SELECT id FROM book WHERE library_id = ?)";
            PreparedStatement deleteUserBookSt = con.prepareStatement(deleteUserBookSql);
            deleteUserBookSt.setInt(1, id);
            deleteUserBookSt.executeUpdate();

            String deleteBooksSql = "DELETE FROM book WHERE library_id = ?";
            PreparedStatement deleteBooksSt = con.prepareStatement(deleteBooksSql);
            deleteBooksSt.setInt(1, id);
            deleteBooksSt.executeUpdate();

            String deleteUsersSql = "DELETE FROM users WHERE library_id = ?";
            PreparedStatement deleteUsersSt = con.prepareStatement(deleteUsersSql);
            deleteUsersSt.setInt(1, id);
            deleteUsersSt.executeUpdate();

            String sql = "DELETE FROM Library WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

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
