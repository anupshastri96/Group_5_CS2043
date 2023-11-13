package LibraryManagementSystem;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class Library {

    private String name;
    private String address;
    private static int nextId = 1000;
    private final int libId;
    private ArrayList<Book> bookList;
    private Scanner bookScan;

    public Library(String name, String address) {
        try {
            name = this.name;
            address = this.address;

            File checkFile = new File("BookStorage.txt");
            bookScan = new Scanner(checkFile);

            libId = nextId;
            nextId++;

            bookList = new ArrayList<>();
        } catch(FileNotFoundException fnf) {
            System.out.println("File inputed does not exist.");
            System.exit(1);
        }
    }

    public Library(String name, String address, int id) {
        name = this.name;
        address = this.address;
        libId = id;
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

    private void bookReadFile() {
        String line = bookScan.nextLine();
        Scanner lineScan = new Scanner(line);
        lineScan.useDelimiter(" ");
        String currentlyRead = "";
        while (lineScan.hasNext()) {
            currentlyRead = lineScan.next();
        }

}
