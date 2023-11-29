
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class BorrowedBook implements Serializable {
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
	
	public BorrowedBook(int ID) {
		nextID = ID;
	}
	
	public BorrowedBook(Member borrower, Book borrowed, int libraryID, Date expectedReturnDate) {
		id = nextID;
		nextID++;

		borrowedFrom = LibraryManagementSystem.findLibrary(libraryID);
		this.borrower = borrower;
		
		this.borrowed = borrowed;
  
   		borrowDate = new Date();
		this.expectedReturnDate = expectedReturnDate;
		daysExtended = 0;
		active = true;
	}
	

	public BorrowedBook(int ID, Member borrower, Book borrowed, int libraryID, Date borrowDate, Date expectedReturnDate, boolean active) {

		id = ID;

		borrowedFrom = LibraryManagementSystem.findLibrary(libraryID);
		this.borrower = borrower;
		
		this.borrowed = borrowed;
		this.borrowDate = borrowDate;
		this.expectedReturnDate = expectedReturnDate;
		this.active = active;

	}

	public double checkedOutLength(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = calendar.getTime();
		 long differenceInMilliseconds = borrowDate.getTime() - newDate.getTime();
	     long differenceInDays = differenceInMilliseconds / (24 * 60 * 60 * 1000);
		double daysChecked = (double) differenceInDays;
		return daysChecked;
	}

	
	private void extendReturnDate(int daysToAdd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(expectedReturnDate);  

		calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
		Date newDate = calendar.getTime();
		expectedReturnDate = newDate;

		daysExtended += daysToAdd;

	}
	

	public double getLateFees() {

		if (!active) {
			if(expectedReturnDate.before(returnDate)) {
				return 0;
			} else {
				//to be determined
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				long differenceInMilliseconds = returnDate.getTime() - expectedReturnDate.getTime();
				long differenceInDays = differenceInMilliseconds / (24 * 60 * 60 * 1000);
				double fee = (double) (differenceInDays*10);
				return fee;
			}
		} else {
			Calendar calendar = Calendar.getInstance();
			Date currentDate = calendar.getTime();
			if(expectedReturnDate.before(currentDate)) {
				return 0;
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				long differenceInMilliseconds = currentDate.getTime() - expectedReturnDate.getTime();
				long differenceInDays = differenceInMilliseconds / (24 * 60 * 60 * 1000);
				double fee = (double) (differenceInDays*10);
				return fee;
			}
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

	public int getID() {
		return id;
	}

	public boolean getActive() {
		return active;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

}
