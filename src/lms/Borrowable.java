package lms;

public interface Borrowable {
    void borrowBook(Book book) throws Exception ;
    void returnBook(Book book) throws Exception;
}
