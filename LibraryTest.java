package library;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LibraryTest {
    private Library library;
    private Book testBook;

    @Before
    public void setup() {
        
        library = new Library();
        
        
        testBook = new Book("Java Basics", "Ravi Kumar", "JS12345");
        library.addBook(testBook);
    }

    @Test
    public void testIssueBook() {
       
        boolean issued = library.issueBook("JS12345");
        assertTrue("Book should be issued successfully", issued);
        assertFalse("Book should not be available after issuing", testBook.isAvailable());
    }

    @Test
    public void testReturnBook() {
       
        library.issueBook("JS12345");
        boolean returned = library.returnBook("JS12345");
        assertTrue("Book should be returned successfully", returned);
        assertTrue("Book should be available again after returning", testBook.isAvailable());
    }

    @Test
    public void testAvailabilityCheck() {
       
        assertTrue("Book should be available initially", library.isBookAvailable("JS12345"));
        library.issueBook("JS12345");
        assertFalse("Book should not be available after being issued", library.isBookAvailable("JS12345"));
    }
}