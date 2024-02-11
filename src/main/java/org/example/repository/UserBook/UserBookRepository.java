package org.example.repository.UserBook;

import org.example.DB.IDbFunctions;
import org.example.model.Books;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserBookRepository implements IUserBookRepository{


    private final IDbFunctions db;

    public UserBookRepository(IDbFunctions db) {
        this.db = db;
    }

    @Override
    public boolean lendBook(Integer userId, Integer bookId, String status) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO user_book(user_id, book_id, status) VALUES ( ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);


            st.setInt(1, userId);
            st.setInt(2, bookId);
            st.setString(3, status);

            int flag = st.executeUpdate();

            return flag > 0;
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

}
