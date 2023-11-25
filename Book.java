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
        belongsToLibraries.add(LibraryManagementSystem.getCurrentLibrary());
        hasBorrowed = new ArrayList<Member>();

    }

    public Book(String nameIn, String authorIn, int deweyIn, boolean adultIn, int amountIn, int bookIdIn, ArrayList<Integer> libraryId, ArrayList<Integer> memberId) {
        
        name = nameIn;
        author = authorIn;
        dewey = deweyIn;
        adult = adultIn;
        bookId = bookIdIn;
        amount = amountIn;

        amountBorrowed = 0; // This will be done when borrowed book is finished.

        belongsToLibraries = LibraryManagementSystem.findLibrary(libraryId);
        hasBorrowed = LibraryManagementSystem.findMember(memberId);

    }

    @Override
	public String toString() {
		String toReturn =	"Title: " + this.name + "\n" +
			"Author: " + this.author + "\n" +
			"Dewey: " + this.dewey + "\n" +
			"Book ID: " + this.bookId + "\n" +
			"Amount: " + this.amount + "\n" +
			"Amount Borrowed: " + amountBorrowed + "\n" +
			"Library Names: ";
		
		if (belongsToLibraries.size() == 0) toReturn += "No Librarys\n";
		else {
			for(int i=0; i<belongsToLibraries.size(); i++) {
				toReturn += belongsToLibraries.get(i).getName() + "\n";
			}
		}
		
		toReturn += "Amount of MemberIDs: ";
		
		if (getMemberIDs().size() == 0) toReturn += "No MemberIDs\n";
		else {
			toReturn += hasBorrowed.size() + "\n";
		}
		
		return toReturn;
	}

    public String makeReadable() {
        String toReturn = (this.getId() + "," + this.getDewey() + "," + this.getName() + "," + this.getAuthor() + "," + this.getAmount());
        if (adult) {
            toReturn += ",T";
        } else {
            toReturn += ",F";
        }
        for (int i = 0; i < belongsToLibraries.size(); i++) {
            toReturn = (",L" + belongsToLibraries.get(i).getID());
        }
        for (int i = 0; i < hasBorrowed.size(); i++) {
            toReturn = (",M" + hasBorrowed.get(i).getID());
        }
        return toReturn;
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

    public void borrow(Member borrowedBy) {
        amountBorrowed++;
        hasBorrowed.add(borrowedBy);
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
    public ArrayList<Integer> getLibraryIDs() {
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        for (int i = 0; i < belongsToLibraries.size(); i++) {
            toReturn.add(belongsToLibraries.get(i).getID());
        }
        return toReturn;
    }

    public boolean checkLibrary(Library in) {
        for (int i = 0; i < belongsToLibraries.size(); i++) {
            if (in == belongsToLibraries.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void addLibrary(int libraryID) {
        
        boolean canAdd = true;
        if (belongsToLibraries.size() != 0) {
            for (int i = 0; i < belongsToLibraries.size(); i++) {
                if (belongsToLibraries.get(i).getID() == libraryID) {
                    canAdd = false;
                }
            }
        }
        if (canAdd) {
            
            belongsToLibraries.add(LibraryManagementSystem.findLibrary(libraryID));
        }
    }

    /* 
     * MEMBER METHODS 
     */
    public ArrayList<Integer> getMemberIDs() {
       ArrayList<Integer> toReturn = new ArrayList<Integer>();
        for (int i = 0; i < hasBorrowed.size(); i++) {
            toReturn.add(hasBorrowed.get(i).getID());
        }
        return toReturn;
    }

    private void findMembers() {
        // Leave this for later
    }

}   
