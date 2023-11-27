import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.EOFException;
import java.util.Scanner;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Library implements Serializable{

    private String name;
    private String address;
    private static int nextId = 1;
    private int libId;
    private int numBooks;
    private int numBooksBorrowed;
    private ArrayList<Book> books;
    private ArrayList<BorrowedBook> borrowedHere;
    private Scanner bookScan;

    public Library(int ID) {
        // Startup Library class to fix issues with overlap IDs
        nextId = ID;
    }

    public Library(String name, String address) {

        this.name = name;
        this.address = address;

        libId = nextId;
        nextId++;

        numBooks = 0;
        numBooksBorrowed = 0;

        books = new ArrayList<Book>();
        borrowedHere = new ArrayList<BorrowedBook>();

        bookReadFile();
        borrowedBookReadFile();
    
    }

    public Library(String name, String address, int numBooks, int numBooksBorrowed, int libId) {
        this.name = name;
        this.address = address;
        this.numBooks = numBooks;
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
        LibraryManagementSystem.libraryWriteFile();
    } 


    /*
     * ADDRESS METHODS
     */
    public String getAddress() {
        return address;
    }

    public void changeAddress(String s) {
        address = s;
        LibraryManagementSystem.libraryWriteFile();
    }

    /*
     * LIBID METHODS
     */
    public int getID() {
        return libId;
    }

    public void setNextID(int nextId) {
        this.nextId = nextId;
    }


    /*
     * BOOKS METHODS
     */
    public void addBook(Book bookIn) {
        if (!bookIn.getName().equals(null) || !bookIn.getAuthor().equals(null)) {
            Book compareBook = LibraryManagementSystem.checkAllBooks(bookIn);
            if (compareBook != null) {
                compareBook.incAmount();
                if (!compareBook.checkLibrary(this)) {
                    compareBook.addLibrary(this.getID());
                    numBooks++;
                }
                bookIn.setNextID(bookIn.getId() - (bookIn.getDewey() * 1000000));
                this.bookWriteFile();
                LibraryManagementSystem.libraryWriteFile();
            } else {
                bookIn.addLibrary(libId);
			    books.add(bookIn);
                numBooks++;
			    this.bookWriteFile();
                LibraryManagementSystem.libraryWriteFile();
                LibraryManagementSystem.changeConfigInts(2);
            }
        }
    }
    
    public void removeBook(Book b) {
        boolean isReal = false;
    	books.remove(b);
    }
    public Book getBook(int n) {
		if (n >= 0 && n < books.size()) {
			return books.get(n);
		} else {
			return null;
		}
	}

    public Book findBook(int bookID) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == bookID) {
				return books.get(i);
			}
		}
		return null;
	}

    public ArrayList<Book> getAllBooks() {
        return books;
    }
    
    public int getNumBooks() {
		return numBooks;
	}
    public String toString() {
    	String s = "======================\n";
    	
    	for(int i=0; i<books.size(); i++) {
    		s += books.get(i).toString() + "======================\n";
    	}
    	
    	return s;
    }
 
    private void bookReadFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bookStorage.bin"));
            for(int i=0; i< numBooks; i++) {
                
				Book bookRead = (Book) ois.readObject();
                System.out.println(bookRead.toString());
                if (bookRead.checkLibrary(this)) {
                    books.add(bookRead);
                    System.out.println("Book read from file.");
                } else {
                    i--;
                }
			}
            ois.close();
        } catch (EOFException eof) {
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }

    private void bookWriteFile() {
       LibraryManagementSystem.bookWriteFile();
    }

    /*
     * BORROWEDBOOK METHODS
     */

    public void borrowBook(Member borrower, Book borrowed) {
        if (borrowed.getAmount() > 0) {
            BorrowedBook toAdd = new BorrowedBook(borrower, borrowed, libId);
            borrowedHere.add(toAdd);
            
        }
    }

	public void returnBook(BorrowedBook brwd) {
		// check if book is in this library
		for(int i=0; i<books.size(); i++) {
			if(brwd.getBook().getId() == books.get(i).getId()) {
				// remove book from borrowed list (??)
				
				// remove member from the book's own members list
				boolean done = false;
				for(int j=0; j<brwd.getBook().getMemberIDs().size() && (done == false); j++) {
					if(brwd.getMember().getID() == brwd.getBook().getMemberIDs().get(j)) {
						// remove from that list
						brwd.getBook().returnBook(brwd.getMember());
						
						brwd.returnBook();
						brwd.getLateFees();
						done = true;
					}
				}
			}
		}
		
	}

    public ArrayList<BorrowedBook> getAllBorrowedBooks() {
        return borrowedHere;
    }

    public int getNumBorrowedBooks() {
        return numBooksBorrowed;
    }

    private void borrowedBookReadFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("borrowedBookStorage.bin"));
            for(int i=0; i< numBooksBorrowed; i++) {
                
				BorrowedBook bookRead = (BorrowedBook) ois.readObject();
                System.out.println(bookRead.toString());
                if (bookRead.checkLibrary(this)) {
                    borrowedHere.add(bookRead);
                    System.out.println("Book read from file.");
                } else {
                    i--;
                }
			}
            ois.close();
        } catch (EOFException eof) {
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }
}

