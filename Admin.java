public class Admin {
	
	private String username;
	private String password;
	
	public Admin(String userIn, String passIn) {
		username = userIn;
		password = passIn;
	}
	public void setUsername(String usernameIn){
		usernameIn = username;
	}

	public void setPassword(String passwordIn){
		passwordIn = password;
	}
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
    
}