package lms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Member extends Person implements Borrowable {
    private int memberId;
    protected List<Book> borowedBooks = new ArrayList<>();

    public Member(int id, int memberId, String name) {
        super(id, name);
        this.memberId = memberId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void borrowBook(Book book) throws Exception {
        if (this.borowedBooks.size() > 3) {
            throw new Exception("Maaf anda telah meminjam limit 3 buku, kembalikan buku untuk meminjam");
        }

        if (!book.borrowBook()) {
            throw new Exception("Copies Buku tidak tersedia");
        }

        this.borowedBooks.add(book);
        System.out.println("Berhasil meminjam buku " + book.getTitle());
    }

    public void returnBook(Book book) throws Exception {
        boolean isHaving = false;
        for (Book b :
                borowedBooks) {
            if (b.getBookId() == book.getBookId()) {
                isHaving = true;
                break;
            }
        }

        if (!isHaving) {
            throw new Exception("Buku yang dikembalikan tidak terdaftar sebagai buku pinjaman. ID : " + book.getBookId());
        }

        book.returnBook();
        System.out.println("Berhasil mengembalikan buku : " + book.getTitle());
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + this.getName() + '\'' +
                ", borowedBooks=" + borowedBooks +
                '}';
    }

    @Override
    public void displayInfo() {
        System.out.println("Member ID : " + this.memberId + " | Name : " + this.getName() + " | Total Pinjaman Buku : " + this.borowedBooks.size());
    }
}
