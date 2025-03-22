package lms;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public Library() {
    }

    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Berhasil menambah buku : " + book.toString());
    }

    public void registerMember(Member member) {
        for (Member m :
                this.members) {
            if (m.getMemberId() == member.getMemberId()) {
                System.out.println("Member sudah terdaftar ID : " + member.getMemberId());
                return;
            }
        }

        this.members.add(member);
        System.out.println("Berhasil menambah member : " + member.toString());
    }

    public Book findBookByTitle(String title) {
        for (Book b : this.books) {
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        System.out.println("Buku tidak ditemukan : " + title);
        return null;
    }

    public void displayAvailableBooks() {
        System.out.println("List buku tersedia : ");
        for (Book b : this.books) {
            if (b.getAvailableCopies() > 0) {
                System.out.printf("ID: %d - %s | STOK : %d\n", b.getBookId(), b.getTitle(), b.getAvailableCopies());
            }
        }
    }
}