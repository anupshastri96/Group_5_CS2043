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

        // Method to turn the IDs into actual libraries or members would be here.

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
     * ID METHODS 
     */
    public int getId() {
        return bookId;
    }

    /* 
     * DEWEY METHODS 
     */
    public int getDewey() {
        return dewey;
    }

    /* 
     * AMOUNT METHODS 
     */
    public int getAmount() {
        return amount;
    }

    /* 
     * ADULT METHODS 
     */
    public String getAdult() {
        if (Adult == true) {
            return "T";
        } else {
            return "F";
        }
    }

    /* 
     * LIBRARY METHODS 
     */
    public int[] getLibraryIDs() {
        // All of this should get replaced with cleaner code because it's really gross.
        int[] toReturn = new int[0];
        int[] holder = toReturn;
        for (int i = 0; i < belongsToLibraries.size(); i++) {
            toReturn = new int[holder.length + 1;]
            for (int i = 0; i < holder.length; i++) {
                toReturn[i] = holder[i];
            }
            toReturn[holder.length] = belongsToLibraries.get(belongsToLibraries.size()).getID();
            holder = toReturn;

        }
        return toReturn;
    }

    /* 
     * MEMBER METHODS 
     */
    public int[] getMemberIDs() {
        // All of this should get replaced with cleaner code because it's really gross.
        int[] toReturn = new int[0];
        int[] holder = toReturn;
        for (int i = 0; i < hasBorrowed.size(); i++) {
            toReturn = new int[holder.length + 1;]
            for (int i = 0; i < holder.length; i++) {
                toReturn[i] = holder[i];
            }
            toReturn[holder.length] = hasBorrowed.get(hasBorrowed.size()).getID();
            holder = toReturn;

        }
        return toReturn;
    }

}   
