import java.util.ArrayList;

public class Book {

    private String name;
    private String author;
    private static int nextId = 0;
    private int bookId;
    private int dewey;
    private boolean adult;
    private int amount;
    private int amountBorrowed;

    private ArrayList<Library> belongsToLibraries;
    private ArrayList<Member> hasBorrowed;
    
    public Book(int ID) {
        // Startup Book class to fix issues with overlap IDs (Currently does not work)
        nextId = ID;
    }

    public Book(String nameIn, String authorIn, int deweyIn, boolean adultIn) {
        
        name = nameIn;
        author = authorIn;
        dewey = deweyIn;
        adult = adultIn;

        bookId = ((dewey * 10000000) + nextId);
        nextId++;

        amount = 1;
        amountBorrowed = 0;

        belongsToLibraries = new ArrayList<Library>();
        hasBorrowed = new ArrayList<Member>();

    }

    public Book(String nameIn, String authorIn, int deweyIn, boolean adultIn, int amountIn, int bookIdIn, int[] libraryId, int[] memberId) {
        
        name = nameIn;
        author = authorIn;
        dewey = deweyIn;
        adult = adultIn;
        bookId = bookIdIn;
        amount = amountIn;

        amountBorrowed = 0; // This will be done when borrowed book is finished.

        belongsToLibraries = new ArrayList<Library>();
        hasBorrowed = new ArrayList<Member>();

    }

    /*
     * toString overwrite
     */
    public String toString() {
        String s;
        s = "Name: " + getName() + "\n" +
            "Author: " + getAuthor() + "\n" +
            "Genre: " + getGenre() + "\n" +
            "Status: " + getStatus() + "\n" +
            "Age Rating: " + getAgeRating() + "\n" +
            "Book ID: " + getId() + "\n" +
            "Currently borrowed: " + getBorrowed() + "\n";
        
        return s;
    }


    /* 
     * NAME METHODS 
     */
    public String getName() {
        return name;
    }

    public void changeName(String s) {
        name = s;
    }

    /* 
     * AUTHOR METHODS 
     */
    public String getAuthor() {
        return author;
    }

    public void changeAuthor(String s) {
        author = s;
    }

    /* 
     * GENRE METHODS 
     */
    public String getGenre() {
        return genre;
    }

    /* 
     * STATUS METHODS 
     */
    public String getStatus() {
        return status;
    }

    public void changeStatus(String s) {
        status = s;
    }

    /* 
     * ID METHODS 
     */
    public int getId() {
        return bookId;
    }
    
    /* 
     * ISBORROWED METHODS 
     */
    public boolean getBorrowed() {
        return isBorrowed;
    }
    
    public void borrowBook() {
    	isBorrowed = true;
    }
    
    public void returnBook() {
    	isBorrowed = false;
    }

}
