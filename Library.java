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
        try {

			BufferedReader reader = new BufferedReader(new FileReader("bookStorage.txt"));
			String line = reader.readLine();
			int buffer = -1;
            int count = 1;

            int currentID = -1;
			String currentName = "";
            String currentAuthor = "";
            int currentDewey = -1;
            int currentAmount = -1;
            boolean currentAdult = null;
            ArrayList<int> libraryIDs = new ArrayList<int>();
            ArrayList<int> memberIDs = new ArrayList<int>();


			while (line != null) {
           	 	for (int i = 0; i < line.length(); i++) {
                    // Decoding would be done here
             	  	if (line.charAt(i) == ' ') {
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
                        } else if (count == 8) {
                            memberIDs.add(Integer.parseInt(line.substring(buffer + 2,i)));
                        }
                        buffer = i;
                	} 
            	}

				Book addBook = new Book(currentName, currentAuthor, currentDewey, currentAdult, currentAmount, currentID, libraryIDs, memberIDs);
				books.add(addBook);
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
		}
    }

    private void writeBookFile() {
        try {
			FileWriter writer = new FileWriter("bookStorage.txt");
        	PrintWriter printer = new PrintWriter(writer);
			for (int i = 0; i < books.size(); i++) {
                // Encoder should be somewhere here.
                // These arrays would just turn int string arrays.
                int[] libraryIDs = books.get(i).getLibraryIDs();
                int[] memberIDs = books.get(i).getMemberIDs();

				printer.print(books.get(i).getId() + " " + books.get(i).getDewey() + " " + books.get(i).getName() + " " + books.get(i).getAuthor() + " " + books.get(i).getAmount() + " " + books.get(i).getAdult());
                for (int i = 0; i < libraryIDs.length; i++) {
                    // L would also be encoded.
                    printer.print(" L" + libraryIDs[i])
                }
                for (int i = 0; i < memberIDs.length; i++) {
                    // M would also be encoded.
                    printer.print(" M" + memberIDs[i])
                }
                printer.println();
			}
			printer.close();

		} catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
    }
}
