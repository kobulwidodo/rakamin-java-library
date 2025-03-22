package lms;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private int availableCopies;

    public Book(int bookId, String title, String author, int availableCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public boolean borrowBook() {
        if (this.availableCopies > 0) {
            this.availableCopies--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        this.availableCopies++;
        System.out.println("Berhasil mengembalikan buku : " + this.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
