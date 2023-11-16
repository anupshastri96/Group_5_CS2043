import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Scanner;

public class LibraryManagementSystem {
// This could end up just being added to the main class instead.
	
	private ArrayList<Library> libraries;
	private ArrayList<Member> members;
	private ArrayList<Admin> admins;
	private int loginType;
	private Library currentLibrary;
	private Scanner fileScan;
	
	// Only the current library should be a parameter because everything else should be read in through a file.
	public LibraryManagementSystem(Library currentLibrary) {
		
		libraries = new ArrayList<Library>();
		members = new ArrayList<Member>();
		admins = new ArrayList<Admin>();
		
		loginType = 1;

		this.libraryReadFile();
		this.memberReadFile();
		this.adminReadFile();

		this.checkStartupLibrary(currentLibrary);
		
	}
	// Library Methods

	public void addLibrary(Library libraryIn) {
		if (loginType == 1) {
			boolean isTrue = false;
			for (int i = 0; i < libraries.size(); i++) {
				if (libraries.get(i).getID() == libraryIn.getID()) {
					i = libraries.size();
					isTrue = true;
				}
			}
			if (!isTrue) {
				if (libraryIn.getName() == null ||  libraryIn.getAddress() == null) {

				} else {
					libraries.add(libraryIn);
					this.libraryWriteFile();
				}
			}
		}
	}
	
	private void removeLibrary(Library libraryIn) {
		if (loginType == 1) {
			for (int i = 0; i < libraries.size(); i++) {
				if (libraries.get(i).getID() == libraryIn.getID()) {
					libraries.remove(i);
					i = libraries.size();
				}
			}
		}
	}
	
	private void libraryReadFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("libraryStorage.txt"));
			String line = reader.readLine();
			int buffer = -1;
			boolean first = true;
			String currentName = "";
			String currentAddress = "";
			int currentID = -1;
			while (line != null) {
           	 	for (int i = 0; i < line.length(); i++) {
             	  	if (line.charAt(i) == ',') {
						if (first) {
							currentID = Integer.parseInt(line.substring(0,i));
							first = false;
						} else {
							currentName = line.substring(buffer + 1,i);
						} 
                    	buffer = i;
                	} else if (i == line.length()-1) {
						currentAddress = line.substring(buffer + 1,line.length());
                	}
            	}
				if (currentName == null || currentAddress == null || currentID == -1) {

				} else {
					Library addLibrary = new Library(currentName, currentAddress, currentID);
					libraries.add(addLibrary);
					buffer = -1;
					first = true;
            		line = reader.readLine();
				}
        	}

		} catch(FileNotFoundException fnf) {
            System.out.println("Library storage file is not there!");
            System.exit(1);
        } catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
	}

	private void libraryWriteFile() {
		try {
			FileWriter writer = new FileWriter("libraryStorage.txt");
        	PrintWriter printer = new PrintWriter(writer);
			for (int i = 0; i < libraries.size(); i++) {
				printer.println(libraries.get(i).getID() + "," + libraries.get(i).getName() + "," + libraries.get(i).getAddress());
			}
			printer.close();

		} catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
	}

	private void checkStartupLibrary(Library libraryIn) {
		int libraryID = libraryIn.getID();
		boolean inSystem = false;
		for (int i = 0; i < libraries.size(); i++) {
			if (libraryID == libraries.get(i).getID()) {
				inSystem = true;
			} 
		}
		if (!inSystem) {
			this.addLibrary(libraryIn);
		}
		this.currentLibrary = libraryIn;
	}

	// Admin methods

	private void adminReadFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("adminStorage.txt"));
			String line = reader.readLine();
			int buffer = -1;
        	String currentUsername = "";
			String currentPassword = "";

			while (line != null) {
        	    for (int i = 0; i < line.length(); i++) {
        	        if (line.charAt(i) == ',') {
						currentUsername = line.substring(0,i);
        	            buffer = i;
        	        } else if (i == line.length()-1) {
        	            currentPassword = line.substring(buffer + 1,line.length());
        	        }
        	    }
				Admin addAdmin = new Admin(currentUsername, currentPassword);
				admins.add(addAdmin);
				buffer = -1;
        	    line = reader.readLine();
        	}

		} catch(FileNotFoundException fnf) {
            System.out.println("Admin storage file is not there!");
            System.exit(1);
        } catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
	}

	// Checks if entered username and password are in the system.
	private boolean checkAdmin(String enteredUser, String enteredPass) {
		// Do this later
		return false;
	}

	// Member methods

	public void addMember(Member memberIn) {
		if (loginType == 1) {
			boolean isTrue = false;
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i).getID() == memberIn.getID()) {
					i = members.size();
					isTrue = true;
				}
			}
			if (!isTrue) {
				members.add(memberIn);
				this.memberWriteFile();
			}
		}
	}
	
	private void removeMember(Member memberIn) {
		if (loginType == 1) {
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i).getID() == memberIn.getID()) {
					members.remove(i);
					i = members.size();
				}
			}
		}
	}

	private void memberReadFile() {
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader("memberStorage.txt"));
			String line = reader.readLine();
			int buffer = -1;
			int count = 1;
			int currentBirthdate = -1;
			String currentFirstname = "";
			String currentLastname = "";
			String currentGender = "";
			int currentID = -1;

			while (line != null) {
        	    for (int i = 0; i < line.length(); i++) {
        	        if (line.charAt(i) == ',') {
						if (count == 1) {
							currentID = Integer.parseInt(line.substring(0,i));
						} else if (count == 2) {
							currentFirstname = line.substring(buffer + 1,i);
						} else if (count == 3) {
							currentLastname = line.substring(buffer + 1,i);
						} else if (count == 4) {
							currentGender = line.substring(buffer + 1,i);
						} 
        	            buffer = i;
						count++;
        	        } else if (i == line.length()-1) {
						currentBirthdate = Integer.parseInt(line.substring(buffer + 1,line.length()));
        	        }
        	    }
				Member addMember = new Member(currentBirthdate, currentFirstname, currentLastname, currentGender, currentID);
				members.add(addMember);
				buffer = -1;
				count = 1;
        	    line = reader.readLine();
        	}

		} catch(FileNotFoundException fnf) {
            System.out.println("Admin storage file is not there!");
            System.exit(1);
        } catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
		
	}

	private void memberWriteFile() {
		try {
			FileWriter writer = new FileWriter("memberStorage.txt");
        	PrintWriter printer = new PrintWriter(writer);
			for (int i = 0; i < members.size(); i++) {
				printer.println(members.get(i).getID() + "," + members.get(i).getBirthdate() + "," + members.get(i).getFirstname() + "," + members.get(i).getLastname() + "," + members.get(i).getGender());
			}
			printer.close();

		} catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
	}
}
