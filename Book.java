package library;


public class Book implements Issueables {

    private String bookssTitle;
    private String booksAuthor;
    private String booksIsb;
    private boolean issued;

    public Book(String bookssTitle, String booksAuthor, String booksIsb) {
        this.bookssTitle = bookssTitle;
        this.booksAuthor = booksAuthor;
        this.booksIsb = booksIsb;
        this.issued = false; 
    }

    // --- Getters ---
    public String getBookssTitle() {
        return bookssTitle;
    }

    public String getBooksAuthor() {
        return booksAuthor;
    }

    public String getBooksIsb() {
        return booksIsb;
    }

    
    @Override
    public boolean issue() {
        if (!issued) {
            issued = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean returnBook() {
        if (issued) {
            issued = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean isAvailable() {
        return !issued;
    }
}

