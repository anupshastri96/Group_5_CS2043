import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.FileWriter;
import java.io.BufferedReader;
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

        books = new ArrayList<Book>();
        borrowedHere = new ArrayList<BorrowedBook>();

        bookReadFile();
    
    }

    public Library(String name, String address, int numBooks, int libId) {
        this.name = name;
        this.address = address;
        this.numBooks = numBooks;
        this.libId = libId;

        books = new ArrayList<>();
        bookReadFile();
    }

       
    public String toString() {
		String s =	"Library: " + getName() + "\n" +
				"Address: " + getAddress() + "\n" +
				"LibID: " + getID() + "\n" +
				"# Books: " + books.size() + "\n";
				
    	s += "======================\n";
    	
    	for(int i=0; i<books.size(); i++) {
    		s += books.get(i).toString() + "======================\n";
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
    	boolean isTrue = false;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == bookIn.getId() || (books.get(i).getName() == bookIn.getName() && books.get(i).getAuthor() == bookIn.getAuthor())) {
                books.get(i).incAmount();
                books.get(i).addLibrary(this.getID());
                this.bookWriteFile();
				i = books.size();
				isTrue = true;
			}
		}
		if (!isTrue) {
            
            bookIn.addLibrary(libId);
			books.add(bookIn);
			this.bookWriteFile();
			
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
    private void bookReadFile() {
       /*   try {
            
			BufferedReader reader = new BufferedReader(new FileReader("bookStorage.txt"));
			String line = reader.readLine();
			int buffer = -1;
            int count = 1;

            int currentID = -1;
			String currentName = "";
            String currentAuthor = "";
            int currentDewey = -1;
            int currentAmount = -1;
            boolean currentAdult = false;
            ArrayList<Integer> libraryIDs = new ArrayList<Integer>();
            ArrayList<Integer> memberIDs = new ArrayList<Integer>();


			while (line != null) {
           	 	for (int i = 0; i < line.length(); i++) {
                    // Decoding would be done here
             	  	if (line.charAt(i) == ',') {
                        if (count == 1) {
                            currentID = Integer.parseInt(line.substring(0,i));
                            count++;
                        } else if (count == 2) {
                            currentDewey = Integer.parseInt(line.substring(buffer + 1,i));
                            count++;
                        } else if (count == 3) {
                            currentName = (line.substring(buffer + 1,i));
                            count++;
                        } else if (count == 4) {
                            currentAuthor = (line.substring(buffer + 1,i));
                            count++;
                        } else if (count == 5) {
                            currentAmount = Integer.parseInt(line.substring(buffer + 1,i));
                            count++;
                        } else if (count == 6) {
                            if (line.substring(buffer + 1,i) == "T") {
                                currentAdult = true;
                            } else {
                                currentAdult = false;
                            }
                            count++;
                        } else if (count == 7) {
                            if (line.charAt(i + 1) == 'M') {
                                count++;
                            }
                            libraryIDs.add(Integer.parseInt(line.substring(buffer + 2,i)));
                            System.out.println(line.substring(buffer + 2,i));
                        } else if (count == 8) {
                            memberIDs.add(Integer.parseInt(line.substring(buffer + 2,i)));
                        }
                        buffer = i;
                	} 
            	}
                for (int i = 0; i < libraryIDs.size(); i++) {
                    if (libraryIDs.get(i) == this.getID()) {
                        Book addBook = new Book(currentName, currentAuthor, currentDewey, currentAdult, currentAmount, currentID, libraryIDs, memberIDs);
				        books.add(addBook);
                    }
                    System.out.println(libraryIDs.get(i));
                    
                }
				buffer = -1;
                count = 1;
            	line = reader.readLine();
        	}


		} catch(FileNotFoundException fnf) {
            System.out.println("Book storage file is not there!");
            System.exit(1);
        } catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		} */ 
        try {
            FileInputStream fis = new FileInputStream("bookStorage.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0; i< numBooks; i++) {
				Book bookRead = (Book) ois.readObject();
                if (bookRead.checkLibrary(this)) {
                    this.addBook(bookRead);
                    System.out.println(bookRead.toString());
                    System.out.println("Book read from file.");
                } else {
                    i--;
                }
			}
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }

    private void bookWriteFile() {
     /* 
        try {
			FileWriter writer = new FileWriter("bookStorage.txt");
        	PrintWriter printer = new PrintWriter(writer);
			for (int i = 0; i < books.size(); i++) {
                // Encoder should be somewhere here.
                // These arrays would just turn int string arrays.
                ArrayList<Integer> libraryIDs = books.get(i).getLibraryIDs();
                ArrayList<Integer> memberIDs = books.get(i).getMemberIDs();

				printer.print(books.get(i).getId() + "," + books.get(i).getDewey() + "," + books.get(i).getName() + "," + books.get(i).getAuthor() + "," + books.get(i).getAmount() + "," + books.get(i).getAdult());
                for (int j = 0; j < libraryIDs.size(); j++) {
                    // L would also be encoded.
                    printer.print(" L" + libraryIDs.get(j));
                }
                for (int j = 0; j < memberIDs.size(); j++) {
                    // M would also be encoded.
                    printer.print(" M" + memberIDs.get(j));
                }
                printer.println();
			}
			printer.close();
        } catch(IOException ioe) {
            System.out.print("Hi");
			System.exit(1);
        }
      */
       try {
        FileOutputStream fos = new FileOutputStream("bookStorage.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i=0; i<numBooks; i++) {
				oos.writeObject(this.getBook(i));
			}
            oos.close();
            System.out.println("Book written to a file.");
        } catch (IOException e) {
            e.printStackTrace();
        } 
		
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
}

