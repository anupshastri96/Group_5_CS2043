package LibraryManagementSystem;

import java.util.ArrayList;

public class Library {

    private String name;
    private String address;
    private static int nextId = 1000;
    private final int libId;
    private ArrayList<Book> bookList;

    public Library(String name, String address) {
        name = this.name;
        address = this.address;
        libId = nextId;
        nextId++;
        bookList = new ArrayList<>();
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
    public int getId() {
        return libId;
    }


    /*
     * BOOKS[] METHODS
     */
    public void addBook(Book b) {
    	bookList.add(b);
    }
    
    public void removeBook(Book b) {
    	bookList.remove(b);
    }
    
    public String toString() {
    	String s = "======================\n";
    	
    	for(int i=0; i<bookList.size(); i++) {
    		s += bookList.get(i).toString() + "======================\n";
    	}
    	
    	return s;
    }

}
