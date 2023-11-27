public class Member {
	private int birthdate;
	private String firstName;
	private String lastName;
	private String gender;
	private String address; //not used?
	private static int nextID = 0;
    private int memID;

	public Member(int ID) {
		nextID = ID;	
	}
	
	public Member(int birthyear, String frstNm, String lstNm, String gender, String address) 
	{
		this.birthdate = birthyear;
		this.firstName = frstNm;
		this.lastName = lstNm;
		this.gender = gender;
		this.address = address;
		memID = nextID;
        nextID++;
		
	}
	public Member(int birthyear, String frstNm, String lstNm, String gender, int id) 
	{
		this.birthdate = birthyear;
		this.firstName = frstNm;
		this.lastName = lstNm;
		this.gender = gender;
		memID = id;
		
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
		int year = 2023;
		int age = birthdate - year;
		return age;
	}

	public int getBirthdate() {
		return birthdate;
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
	public int getID() {
		return memID;
	}

}
