public class LibraryTestDriver{
	
	public static void main(String args[]) {
	
		Book b1 = new Book("The Hunger Games", "Suzanne Collins",  800, false);
		
		/*
		public String toString() {
			String s =	"Title: " + getName() + "\n" +
						"Author: " + getAuthor() + "\n" +
						"Dewey: " + getDewey() + "\n" +
						"Book ID: " + getId() + "\n" +
						"Amount: " + getAmount() + "\n" +
						"Amount Borrowed: " + amountBorrowed + "\n" +
						"LibraryIDs: ";
		
			if (getLibraryIDs().length == 0) s += "No LibraryIDs\n";
			else {
				for(int i=0; i<getLibraryIDs().length; i++) {
					s += getLibraryIDs()[i] + "\n";
				}
			}
		
			s += "MemberIDs: ";
		
			if (getMemberIDs().length == 0) s += "No MemberIDs";
			else {
				for(int j=0; j<getMemberIDs().length; j++) {
					s += getMemberIDs()[j] + "\n";
				}
			}
		
			return s;
		}
		*/
		
		System.out.print(b1.toString());
		
		//Library l1 = new Library("Library 1", "123 Book Rd");
	}
	
}