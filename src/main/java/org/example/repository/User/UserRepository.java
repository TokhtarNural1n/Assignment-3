package org.example.repository.User;

import org.example.DB.IDbFunctions;
import org.example.model.Library;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{

    private final IDbFunctions db;

    public UserRepository(IDbFunctions db) {
        this.db = db;
    }

    @Override
    public boolean addUser(User user) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(name, groupname, library_id) VALUES ( ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getName());
            st.setString(2, user.getGroupName());
            st.setInt(3, user.getLibrary_id());

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
    public List<User> getAllUsers() {

        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id, name, groupname, library_id FROM users";
            Statement st = con.createStatement();


            ResultSet rs = st.executeQuery(sql);
            List<User> users = new ArrayList<>();


            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("groupname"),
                        rs.getInt("library_id"));

                users.add(user);
            }

            return users;
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
    public List<User> getUserById(Integer id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id, name, groupname, library_id FROM users WHERE id = ?";
            Statement st = con.createStatement();


            ResultSet rs = st.executeQuery(sql);
            List<User> users = new ArrayList<>();


            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("groupname"),
                        rs.getInt("library_id"));

                users.add(user);
            }

            return users;
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
    public boolean deleteUserById(Integer id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "DELETE FROM users WHERE library_id = ?";
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
