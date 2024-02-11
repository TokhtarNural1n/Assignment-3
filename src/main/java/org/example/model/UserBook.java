package org.example.model;

public class UserBook {
    private Integer user_id;
    private Integer book_id;
    private String status;

    public UserBook(Integer user_id, Integer book_id, String status) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.status = status;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBookId() {
        return book_id;
    }

    public void setBookId(Integer book_id) {
        this.book_id = book_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "userId=" + user_id +
                ", bookId=" + book_id +
                ", status='" + status + '\'' +
                '}';
    }
}
