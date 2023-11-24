import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BorrowedBook {
	private int id;
	private static int nextID = 0;
	private boolean active;
	private Member borrower;
	private Library borrowedFrom;
	private Book borrowed;
	private Date borrowDate;
	private Date expectedReturnDate;
	private int daysExtended;
	private Date returnDate;

	public BorrowedBook(int ID) {
		nextID = ID;
	}
	
	public BorrowedBook(Member borrower, Book borrowed, int libraryID) {
		id = nextID;
		nextID++;

		borrowedFrom = LibraryManagementSystem.findLibrary(libraryID);
		this.borrower = borrower;
		
		this.borrowed = borrowed;
		borrowDate = new Date();
		daysExtended = 0;
		active = true;
	}

	public BorrowedBook(int ID, Member borrower, Book borrowed, int libraryID, Date borrowDate, boolean active) {
		id = ID;

		borrowedFrom = LibraryManagementSystem.findLibrary(libraryID);
		this.borrower = borrower;
		
		this.borrowed = borrowed;
		this.borrowDate = borrowDate;
		this.active = active;

		//Do something with date
	}


	private void extendReturnDate(int amountOfDays) {
		daysExtended += amountOfDays;
	}
	
	public double getLateFees() {
		if(expectedReturnDate.before(returnDate)) 
		{
			//print returned on time in GUI or already returned
			return 0;
		}
		else 
		{
			//to be determined
			int fee = 0;
			return fee;
		}
	}
	
	private void returnbook(Date returned) {
		returnDate = returned;
		active = false;
		
	}
	

}
