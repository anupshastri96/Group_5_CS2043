import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Member implements Serializable{
	private int birthyear;
	private String firstName;
	private String lastName;
	private String gender;
	private Date expirationDate;
	private String address;
	private static int nextID = 1;
    private int memID;
    private ArrayList<BorrowedBook> hasBorrowed;

	public Member(int ID) {
		nextID = ID;	
	}
	
	public Member(int birthyear, String frstNm, String lstNm, String gender, String address) 
	{
		this.birthyear = birthyear;
		this.firstName = frstNm;
		this.lastName = lstNm;
		this.gender = gender;
		this.address = address;
		memID = nextID;
        nextID++;
		hasBorrowed = new ArrayList<>();
		
		dateExpired();
		
	}
	
	public Member(int birthyear, String frstNm, String lstNm, String gender, String address, Date expDate, int id, ArrayList<Integer> hasBorrowedID)  {
		this.birthyear = birthyear;
		this.firstName = frstNm;
		this.lastName = lstNm;
		this.address = address;
		this.gender = gender;
        expirationDate = expDate;
		memID = id;
		hasBorrowed = new ArrayList<>();
		if (hasBorrowedID.get(0) == -1) {
			
		} else {
			for (int i = 0; i < hasBorrowedID.size(); i++) {
				hasBorrowed.add(LibraryManagementSystem.findBorrowedBook(hasBorrowedID.get(i)));
			}
		}
		
		dateExpired();
	}
	
	private void dateExpired() {
		Calendar cal = Calendar.getInstance();
		Date curDate = new Date();
        cal.setTime(curDate);
        cal.add(Calendar.YEAR, 1);
        expirationDate = cal.getTime();
	}

	public void setNextID(int nextID) {
		this.nextID = nextID;
	}
		public String getFirstname() 
	{
		return firstName;
	}
		public String getLastname() 
	{
		return lastName;
	}
	public int getAge() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int age = year - birthyear;
		return age;
	}

	public int getBirthyear() {
		return birthyear;
	}
	public String getGender() {
		if(!gender.isEmpty()) 
		{
			return gender;
		}
		else 
		{
			return null;
		}
	}

    public String getExpDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String toReturn = dateFormat.format(expirationDate);
        return toReturn;
    }

	public String getAddress() {
		return address;
	}
	public int getID() {
		return memID;
	}

	public void addBook (BorrowedBook bookIn) {
		hasBorrowed.add(bookIn);
	}

	public ArrayList<BorrowedBook> getBorrowed() {
		if (!hasBorrowed.isEmpty() && hasBorrowed != null) {
			return hasBorrowed;
		} else {
			return null;
		}
	}

    public double getTotalLateFees() {
        double toReturn = 0;
        if (!hasBorrowed.isEmpty() && hasBorrowed != null) {
            for (int i = 0; i < hasBorrowed.size(); i++) {
                toReturn += hasBorrowed.get(i).getLateFees();
            }
        }
        return toReturn;
    }

	public void renewMembership() {
		dateExpired();
	}

	private void extendMembership(int daysToAdd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(expirationDate);  

		calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
		Date newDate = calendar.getTime();
		expirationDate = newDate;
	}
	
	public boolean memexpired() {
		Calendar calendar = Calendar.getInstance();
		Date newDate = calendar.getTime();
		if(newDate.before(expirationDate)) {
			return false;
		}
		return true;
	}

}
