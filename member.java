public class Member {
	private int birthdate;
	private String firstName;
	private String lastName;
	private String gender;
	private static int nextID = 1;
    private final int id;
	
	public Member(int birthyear, String frstNm, String lstNm, String gender) 
	{
		this.birthdate = birthyear;
		this.firstName = frstNm;
		this.lastName = lstNm;
		this.gender = gender;
		id = nextID;
        nextID++;
		
	}
	public Member(int birthyear, String frstNm, String lstNm, String gender, int id) 
	{
		this.birthdate = birthyear;
		this.firstName = frstNm;
		this.lastName = lstNm;
		this.gender = gender;
		this.id = id;
		
	}
		public String getFirstname() 
	{
		return firstName;
	}
		public String getLastname() 
	{
		return lastName;
	}
	public int getAge() 
	{
		int year = 2023;
		int age = birthdate - year;
		return age;
	}
	public int getBirthdate() 
	{
		return birthdate;
	}
	public String getGender() 
	{
		if(!gender.isEmpty()) 
		{
			return gender;
		}
		else 
		{
			return null;
		}
	}
	public int getID() 
	{
		if(id >= 1) 
		{
			return id;
		}
		else 
		{
		
			return 0;
		}
		
	}

}
