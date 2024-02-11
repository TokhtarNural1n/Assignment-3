package org.example.model;

public class Books  {
    private Integer id;
    private String title;
    private String isbn;
    private String genre;
    private String author;
    private Integer year;
    private Integer library_id;
    private String status;

    public Books(String title, String isbn, String genre, String author, Integer year, Integer library_id, String status) {
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.library_id = library_id;
        this.status = status;
    }

    public Books(Integer id, String title, String isbn, String genre, String author, Integer year, Integer libraryId, String status) {
        this(title, isbn, genre, author, year, libraryId, status);
        setId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public Integer getLibraryId() {
        return library_id;
    }

    public void setLibraryId(Integer library_id) {
        this.library_id = library_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", libraryId=" + library_id +
                ", status='" + status + '\'' +
                '}';
    }
}
