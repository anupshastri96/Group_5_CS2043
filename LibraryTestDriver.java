import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.io.IOException;


public class LibraryTestDriver{
	
	public static void main(String args[]) {

		LibraryManagementSystem.libraryReadFile();
		LibraryManagementSystem.memberReadFile();
		LibraryManagementSystem.adminReadFile();
		LibraryManagementSystem.readConfig();
		/* 
		Library l1 = new Library("Library 1", "123 Book Rd");
		LibraryManagementSystem.addLibrary(l1, false);
		LibraryManagementSystem.changeCurrentLibrary(l1);
	
		Book b1 = new Book("The Hunger Games", "Suzanne Collins", 800, false);
		
		System.out.println("Created Book b1");
		
		Book b2 = new Book("The Hobbit", "J.R.R. Tolkien", 800, false);
		
		System.out.println("Created Book b2");
		
		System.out.println("Created Library l1");
		
		l1.addBook(b1);
		l1.addBook(b2);
		System.out.println("Added b1 and b2 to l1");
		
		System.out.println(l1.toString());
		System.out.println("Printed l1 list (1)");
		
		l1.addBook(b2);
		System.out.println("Added b2 to l1 again");
		
		System.out.println(l1.toString());
		System.out.println("Printed l1 list (2)");
		
		Book b3 = b1;
		System.out.println("Created Book b3 as a copy of b1");
		
		l1.addBook(b3);
		System.out.println("Added b3 to l1");
		
		System.out.println(l1.toString());
		System.out.println("Printed l1 list (3)");
		
		Book b4 = new Book("The Hunger Games", "Suzanne Collins", 800, false);
		System.out.println("Created Book b4 with same values as b1");
		
		l1.addBook(b4);
		System.out.println("Added b4 to l1");
		
		System.out.println(l1.toString());
		System.out.println("Printed l1 list (4)");
		*/
		
		
		Book bk;
		String str1;
		String str2;
		int gen;
		int nbks = 3;
		
		Library lib = new Library("Test Library", "999 Book Rd");
		LibraryManagementSystem.addLibrary(lib, false);
		System.out.println("Created new lib");

		for(int i=0; i<nbks; i++) {
			str1 = "name" + i;
			str2 = "author" + i;
			bk = new Book(str1, str2, 100, false);
			lib.addBook(bk);
		}
		System.out.println("Added " + nbks + " books to lib");
		
		System.out.println(lib.toString());
		System.out.println("Printed new lib (1)");
		
		
		/* 
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bookStorage.bin"))) {
            for(int i=0; i<nbks; i++) {
				oos.writeObject(lib.getBook(i));
			}
			oos.close();
            System.out.println("Books written to a file.");
        } catch (IOException e) {
            e.printStackTrace();
        } */
		
		
		
		Library dupLib = new Library("The Better Test Library", "999.1 Book Rd");
		/* 
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bookStorage.bin"))) {
            for(int i=0; i<nbks; i++) {
				bk = (Book) ois.readObject();
				dupLib.addBook(bk);
			}
			ois.close();
			System.out.println(nbks + " books successfully read from a file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } */
		
		System.out.println(dupLib.toString());
		System.out.println("Printed dupLib (1)");
		
		boolean same = true;
		for(int i=0; i<nbks && same==true; i++) {
			if((lib.getBook(i).getId() - dupLib.getBook(i).getId()) != 0) {
				System.out.println("lib and dupLib are not the same (problem at " + i + ")");
				same = false;
			}
		}
		System.out.println("lib and dupLib are the same");
		
		for(int i=0; i<nbks; i++) {
			dupLib.getBook(i).changeName("newName" + i);
		}
		System.out.println(dupLib.toString());
		System.out.println("Printed dupLib (2)");
		
		for(int i=0; i<nbks; i++) {
			dupLib.removeBook(dupLib.getBook(0));
		}
		System.out.println("Removed all books from dupLib");
		System.out.println(dupLib.toString());
		System.out.println("Printed dupLib (3)");
	}
	
}