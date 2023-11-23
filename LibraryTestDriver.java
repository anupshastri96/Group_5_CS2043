public class LibraryTestDriver{
	
	public static void main(String args[]) {

		LibraryManagementSystem.libraryReadFile();
		LibraryManagementSystem.memberReadFile();
		LibraryManagementSystem.adminReadFile();
		LibraryManagementSystem.readConfig();

		Library l1 = new Library("Library 1", "123 Book Rd");
		LibraryManagementSystem.addLibrary(l1);
		LibraryManagementSystem.changeCurrentLibrary(l1);
	
		Book b1 = new Book("The Hunger Games", "Suzanne Collins",  800, false);
		
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
		
		Book b4 = new Book("The Hunger Games", "Suzanne Collins",  800, false);
		System.out.println("Created Book b4 with same values as b1");
		
		l1.addBook(b4);
		System.out.println("Added b4 to l1");
		
		System.out.println(l1.toString());
		System.out.println("Printed l1 list (4)");
	}
	
}