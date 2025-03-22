package lms;

import java.util.List;

public class StaffMember extends Member implements Borrowable {
    private String position;

    public StaffMember(int id, int memberId, String name) {
        super(id, memberId, name);
    }

    @Override
    public void borrowBook(Book book) {
        if (this.borowedBooks.size() > 3) {
            System.out.println("Maaf anda telah meminjam limit 3 buku, kembalikan buku untuk meminjam");
            return;
        }

        if (!book.borrowBook()) {
            System.out.println("Copies Buku tidak tersedia");
            return;
        }

        this.borowedBooks.add(book);
        System.out.println("Berhasil meminjam buku");
    }

    @Override
    public void returnBook(Book book) throws Exception {
        super.returnBook(book);
    }
}
