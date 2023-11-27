
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class BorrowedBook {
	private int id;
	private int associatedMemberID;
	private Date expectedReturnDate;
	private Date borrowDate;
	private Date returnDate;
	public ArrayList<BorrowedBook> borrowedbooks = new ArrayList<BorrowedBook>();
	private static int nextID = 0;
	private boolean active;
	private Member borrower;
	private Library borrowedFrom;
	private Book borrowed;
	private int daysExtended;
	//private Date returnDate;
	
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

	
	public BorrowedBook(int id, int membID,Date exretdate,Date borrowdt, boolean active) 
	{
		
		this.id = id;
		this.associatedMemberID = membID;
		this.expectedReturnDate = exretdate;
		this.borrowDate = borrowdt;
		this.active = active;
	}
	
	public BorrowedBook(int ID, Member borrower, Book borrowed, int libraryID, Date borrowDate, boolean active) {
		id = ID;

		borrowedFrom = LibraryManagementSystem.findLibrary(libraryID);
		this.borrower = borrower;
		
		this.borrowed = borrowed;
		this.borrowDate = borrowDate;
		this.active = active;

	}
	
	private void extendReturnDate(int daysToAdd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(expectedReturnDate);  

		calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
		Date newDate = calendar.getTime();
		expectedReturnDate = newDate;

		daysExtended += daysToAdd;
	}

	public double getLateFees() 
	{
		
		if(expectedReturnDate.before(returnDate)) 
		{
			JOptionPane.showMessageDialog(null, "RETURNED ON TIME");
			return 0;
		}
		else 
		{
			//to be determined
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			 long differenceInMilliseconds = returnDate.getTime() - borrowDate.getTime();
		     long differenceInDays = differenceInMilliseconds / (24 * 60 * 60 * 1000);
			double fee = (double) (differenceInDays*10);
			return fee;
		}
		
	}

	public boolean checkLibrary(Library libraryIn) {
		if (libraryIn.getID() == borrowedFrom.getID()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void returnBook() {
		Date currentDate = new Date();
		returnDate = currentDate;
		active = false;
		//return getLateFees();
		
	}

	/*
	 * GET METHODS
	 */
	
	public Book getBook() {
		return borrowed;
	}
	
	public Member getMember() {
		return borrower;
	}
	
	public Library getLibrary() {
		return borrowedFrom;
	}
	
}
