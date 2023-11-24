public class Member {
	private int birthyear;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private static int nextID = 1;
    private int memID;

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
		
	}
	public Member(int birthyear, String frstNm, String lstNm, String gender, String address, int id) 
	{
		this.birthyear = birthyear;
		this.firstName = frstNm;
		this.lastName = lstNm;
		this.address = address;
		this.gender = gender;
		memID = id;
		
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

}
