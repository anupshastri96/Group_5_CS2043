public class LibraryTestDriver{
	
	public static void main(String args[]) {
	
		Book b1 = new Book("The Hunger Games", "Suzanne Collins",  800, false);
	
		System.out.println(b1.getName());
		System.out.println(b1.getAuthor());
		System.out.println(b1.getId());
		System.out.println(b1.getDewey());
		System.out.println(b1.getAmount());
		System.out.println(b1.getAdult());
		
		for(int i=0; i<b1.getLibraryIDs().length; i++) {
			System.out.println(b1.getLibraryIDs()[i]);
		}
		if (b1.getLibraryIDs().length == 0) System.out.println("No LibraryIDs");
		
		for(int j=0; j<b1.getMemberIDs().length; j++) {
			System.out.println(b1.getMemberIDs()[j]);
		}
		if (b1.getMemberIDs().length == 0) System.out.println("No MemberIDs");
		
		
		//Library l1 = new Library("Library 1", "123 Book Rd");
	}
	
}