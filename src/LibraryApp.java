import lms.Book;
import lms.Library;
import lms.Member;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LibraryApp {
    public static void main(String[] args) {
        Library filkom = new Library();


        Book programin101 = new Book(1, "Programming 101", "Gill Bates", 10);
        Book bukulangka = new Book(2, "Buku cuman ada 1", "Misterius", 1);

        Member mail = new Member(1, 1, "Mail");
        Member mailClone = new Member(1, 1, "MailClone");
        Member liam = new Member(2, 2, "Liam");

        filkom.addBook(programin101);
        filkom.addBook(bukulangka);

        filkom.registerMember(mail);
        filkom.registerMember(mailClone);
        filkom.registerMember(liam);

        filkom.displayAvailableBooks();

        Book resBook = filkom.findBookByTitle("Programming 101");
        System.out.println(resBook);

        try {
            mail.borrowBook(resBook);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        mail.displayInfo();

        resBook = filkom.findBookByTitle("Buku cuman ada 1");
        try {
            mail.borrowBook(resBook);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        mail.displayInfo();

        try {
            liam.borrowBook(resBook);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        liam.displayInfo();

        filkom.displayAvailableBooks();
    }

}