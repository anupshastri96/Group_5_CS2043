package lib;

import java.util.Calendar;
import java.util.Date;

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
	
	private void returnbook(Date returned) 
	{
		returnDate = returned;
		if(expectedReturnDate.before(returnDate)) 
		{
			//print returned on time in GUI or already returned
			
		}
		else 
		{
			//print not returned on time and calc late fees
			
		}
		
	}
	

}