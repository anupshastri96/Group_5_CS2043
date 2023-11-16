public class LibraryTestDriver{
	
	public static void main(String args[]) {
	
		Book b1 = new Book("The Hunger Games", "Suzanne Collins",  800, false);
		
		System.out.println("Created Book b1");
		
		Book b2 = new Book("The Hobbit", "J.R.R. Tolkien", 800, false);
		
		System.out.println("Created Book b2");
		
		Library l1 = new Library("Library 1", "123 Book Rd");
		
		System.out.println("Created Library l1");
		
		l1.addBook(b1);
		l1.addBook(b2);
		
		System.out.println("Added b1 and b2 to l1");
		
		System.out.println(l1.toString());
		
		System.out.println("Printed l1 list");
	}
	
}