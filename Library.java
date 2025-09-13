package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    
    private List<Book> booksCollection;

    public Library() {
        booksCollection = new ArrayList<>();
    }

   
    public void addBook(Book newBook) {
        booksCollection.add(newBook);
    }

    
    public boolean issueBook(String code) {
        for (Book bk : booksCollection) {
            if (bk.getBooksIsb().equals(code)) {
                return bk.issue();
            }
        }
        return false; 
    }

   
    public boolean returnBook(String code) {
        for (Book bk : booksCollection) {
            if (bk.getBooksIsb().equals(code)) {
                return bk.returnBook();
            }
        }
        return false; 
    }

   
    public boolean isBookAvailable(String code) {
        for (Book bk : booksCollection) {
            if (bk.getBooksIsb().equals(code)) {
                return bk.isAvailable();
            }
        }
        return false; 
    }
}