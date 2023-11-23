import java.util.ArrayList;
import java.io.Serializable;

public class Book implements Serializable {

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

        bookId = ((dewey * 1000000) + nextId);
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
	 * TOSTRING
	 */
	public String toString() {
		String s =	"Title: " + this.name + "\n" +
			"Author: " + this.author + "\n" +
			"Dewey: " + this.dewey + "\n" +
			"Book ID: " + this.bookId + "\n" +
			"Amount: " + this.amount + "\n" +
			"Amount Borrowed: " + amountBorrowed + "\n" +
			"LibraryIDs: ";
		
		if (getLibraryIDs().length == 0) s += "No LibraryIDs\n";
		else {
			for(int i=0; i<getLibraryIDs().length; i++) {
				s += getLibraryIDs()[i] + "\n";
			}
		}
		
		s += "MemberIDs: ";
		
		if (getMemberIDs().length == 0) s += "No MemberIDs\n";
		else {
			for(int j=0; j<getMemberIDs().length; j++) {
				s += getMemberIDs()[j] + "\n";
			}
		}
		
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

    public void incAmount() {
        amount++;
    }

    /* 
     * ADULT METHODS 
     */
    public String getAdult() {
        if (adult == true) {
            return "T";
        } else {
            return "F";
        }
    }

    /* 
     * LIBRARY METHODS 
     */
    public int[] getLibraryIDs() {
        int[] toReturn = new int[0];
        return toReturn;
    }

    private void findLibraries() {
        // Leave this for later
    }

    /* 
     * MEMBER METHODS 
     */
    public int[] getMemberIDs() {
        int[] toReturn = new int[0];
        return toReturn;
    }

    private void findMembers() {
        // Leave this for later
    }

}   
