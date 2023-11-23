package lib;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class BorrowedBook {
	private int id;
	private int associatedMemberID;
	private Date expectedReturnDate;
	private Date borrowDate;
	private Date returnDate;
	
	public BorrowedBook(int id, int membID,Date exretdate,Date borrowdt) 
	{
		this.id = id;
		this.associatedMemberID = membID;
		this.expectedReturnDate = exretdate;
		this.borrowDate = borrowdt;
	}
	private void extendReturnDate() 
	{
		
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(expectedReturnDate);  
			 int daysToAdd = 7;  
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
