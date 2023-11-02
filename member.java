package lib;
public class member {
	private int birthdate;
	private String firstName;
	private String lastName;
	private String gender;
	private int id;
	
	public member(int birthyear, String frstNm, String lstNm, String gender,int id ) 
	{
		this.birthdate = birthyear;
		this.firstName = frstNm;
		this.lastName = lstNm;
		this.gender = gender;
		this.id = id;
		
	}
	public int getAge() 
	{
		int year = 2023;
		int age = birthdate - year;
		return age;
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
