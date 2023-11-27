import java.util.ArrayList;
<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
=======
>>>>>>> 2f31382e0d86d666782d44aaa9c858e0c0b2602e
import java.io.Serializable;

public class Book implements Serializable {

    private String name;
    private String author;
    private static int nextId = 0;
    private int bookId;
    private int dewey;
    private String subject;
    private boolean adult;
    private int amount;
    private int amountBorrowed;

    private ArrayList<Library> belongsToLibraries;
    private ArrayList<Member> currentlyBorrowing;
    
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
        currentlyBorrowing = new ArrayList<Member>();

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
        currentlyBorrowing = LibraryManagementSystem.findMember(memberId);

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
			toReturn += currentlyBorrowing.size() + "\n";
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

    public void setNextID(int nextId) {
        this.nextId = nextId;
    }

    /* 
     * DEWEY METHODS 
     */
    public int getDewey() {
        return dewey;
    }
    /* 
    private void getDeweyInfo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("DeweyDecimalData.txt"));
			String line = reader.readLine();
            
            while (line != null) {
                if (Integer.parseInt(line.subString(0,3)) == bookId) {

                }
                holder.add(line);
                line = reader.readLine();
            }
            String[] toReturn = new String[holder.size()];
            for (int i = 0; i < holder.size(); i++) {
                toReturn[i] = holder.get(i);
            }
            return toReturn;
        } catch(FileNotFoundException fnf) {
            System.out.println("Dewey info is not there!");
            System.exit(1);
        } catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
        return null;
    } */

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
        if (amount - amountBorrowed > 0) {
            amountBorrowed++;
            currentlyBorrowing.add(borrowedBy);
        }
    }

    public void returnBook(Member borrowedBy) {
        if (amountBorrowed > 0 && checkMember(borrowedBy)) {
            amountBorrowed--;
            currentlyBorrowing.remove(borrowedBy);
        }
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
            if (in.getID() == belongsToLibraries.get(i).getID()) {
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
        for (int i = 0; i < currentlyBorrowing.size(); i++) {
            toReturn.add(currentlyBorrowing.get(i).getID());
        }
        return toReturn;
    }

    private boolean checkMember(Member memberIn) {
        for (int i = 0; i < currentlyBorrowing.size(); i++) {
            if (currentlyBorrowing.get(i).getID() == memberIn.getID() ) {
                return true;
            }
        }
        return false;
    }

}   
