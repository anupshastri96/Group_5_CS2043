import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable{
	private int birthyear;
	private String firstName;
	private String lastName;
	private String gender;
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
		
	}
	public Member(int birthyear, String frstNm, String lstNm, String gender, String address, int id, ArrayList<Integer> hasBorrowedID)  {
		this.birthyear = birthyear;
		this.firstName = frstNm;
		this.lastName = lstNm;
		this.address = address;
		this.gender = gender;
		memID = id;
		hasBorrowed = new ArrayList<>();
		if (hasBorrowedID.get(0) == -1) {
			
		} else {
			for (int i = 0; i < hasBorrowedID.size(); i++) {
				hasBorrowed.add(LibraryManagementSystem.findBorrowedBook(hasBorrowedID.get(i)));
			}
		}
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
		// Get actual year
		int year = 2023;
		int age = birthyear - year;
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

	

}
