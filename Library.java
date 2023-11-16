import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Scanner;

public class Library {

    private String name;
    private String address;
    private static int nextId = 1;
    private int libId;
    private ArrayList<Book> books;
    private Scanner bookScan;

    public Library(int ID) {
        // Startup Library class to fix issues with overlap IDs (Currently does not work)
        nextId = ID;
    }

    public Library(String name, String address) {

        this.name = name ;
        this.address = address;

        libId = nextId;
        nextId++;

        books = new ArrayList<>();
    
    }

    public Library(String name, String address, int libId) {
        this.name = name ;
        this.address = address;
        this.libId = libId;

        books = new ArrayList<>();
        this.bookReadFile();


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
     * ADDRESS METHODS
     */
    public String getAddress() {
        return address;
    }

    public void changeAddress(String s) {
        address = s;
    }


    /*
     * LIBID METHODS
     */
    public int getID() {
        return libId;
    }


    /*
     * BOOKS METHODS
     */
    public void addBook(Book bookIn) {
    	boolean isTrue = false;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == bookIn.getId() || (books.get(i).getName() == bookIn.getName() && books.get(i).getAuthor() == bookIn.getAuthor())) {
                books.get(i).incAmount();
				i = books.size();

				isTrue = true;
			}
		}
		if (!isTrue) {
			if (bookIn.getName() == null ||  bookIn.getAuthor() == null) {

			} else {
				books.add(bookIn);
				this.bookWriteFile();
			}
		}

    }
    
    public void removeBook(Book b) {
        boolean isReal = false;
    	books.remove(b);
    }
    
    public String toString() {
    	String s = "======================\n";
    	
    	for(int i=0; i<books.size(); i++) {
    		s += books.get(i).toString() + "======================\n";
    	}
    	
    	return s;
    }
 
    private void bookReadFile() {
       
    }

    private void bookWriteFile() {
        
    }
}
