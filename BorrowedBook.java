package lib;

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
	private ArrayList<BorrowedBook> borrowedbooks = new ArrayList<BorrowedBook>();
	private static int nextID = 0;
	private boolean active;
	private Member borrower;
	private Library borrowedFrom;
	private Book borrowed;
	//private Date borrowDate;
	//private Date expectedReturnDate;
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

		active = true;
	}

	
	public BorrowedBook(int id, int membID,Date exretdate,Date borrowdt, boolean active) 
	{
		
		this.id = id;
		this.associatedMemberID = membID;
		this.expectedReturnDate = exretdate;
		this.borrowDate = borrowdt;
		this.active = active;
		borrowedbooks.add(this);
	}
	
	public BorrowedBook(int ID, Member borrower, Book borrowed, int libraryID, Date borrowDate, boolean active) {
		id = ID;

		borrowedFrom = LibraryManagementSystem.findLibrary(libraryID);
		this.borrower = borrower;
		
		this.borrowed = borrowed;
		this.borrowDate = borrowDate;
		this.active = active;
		borrowedbooks.add(this);
		//Do something with date
	}
	private void extendReturnDate(int daysToAdd) 
	{
		
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(expectedReturnDate);  
			   
		     calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
		     Date newDate = calendar.getTime();
		     expectedReturnDate = newDate;
			
		
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
	
	private void returnbook(Date returned) 
	{
		returnDate = returned;
		borrowedbooks.remove(this);
		if(expectedReturnDate.before(returnDate)) 
		{
			JOptionPane.showMessageDialog(null, "RETURNED ON TIME");
			//print returned on time in GUI or already returned
			
		}
		else 
		{
			double display = getLateFees();
			JOptionPane.showMessageDialog(null, "YOUR LATE FEES ARE: " + display);
			//print not returned on time and calc late fees
			
		}
		
	}
	

}
