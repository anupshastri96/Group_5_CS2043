import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException; 
import java.to.PrintWriter;
import java.util.Scanner;

public class LibraryManagementSystem {
// This could end up just being added to the main class instead.
	
	private ArrayList<Libary> libraries;
	private ArrayList<Member> members;
	private ArrayList<Admin> admins;
	private int loginType;
	private Library currentLibrary;
	private Scanner fileScan;
	
	// Only the current library should be a parameter because everything else should be read in through a file.
	public LibraryManagementSystem(Library currentLibrary) {
		try {
			libraries = new ArrayList<Library>();
			members = new ArrayList<Member>();
			admins = new ArrayList<Admin>();
			
			BufferedReader reader = new BufferedReader(new FileReader("libraryStorage.txt"));
			this.libraryReadFile();

			reader = new BufferedReader(new FileReader("memberStorage.txt"));
			this.memberReadFile();

			reader = new BufferedReader(new FileReader("adminStorage.txt"));
			this.adminReadFile();

		} catch(FileNotFoundException fnf) {
            System.out.println("One of the storage files are missing.");
            System.exit(1);
        }
		
		
		// Something should be implemented to check if the current library is in the system.
		this.currentLibrary = currentLibrary;
		
	}
	// Library Methods

	private void addLibrary(Library libraryIn) {
		if (loginType == 1) {
			boolean isTrue = false;
			for (int i = 0; i < libraries.size(); i++) {
				if (libraries.get(i).getID() == libraryIn.getID()) {
					i = libraries.size();
					isTrue = true;
				}
			}
			if (!isTrue) {
				libraries.add(libraryIn);
				this.libraryWriteFile();
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
		String line = reader.readLine();
		int buffer = -1;
		boolean first = true;
		String currentName = "";
		String currentAddress = "";
		int currentID = "";

		while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
					if (first) {
						currentName = line.substring(0,i);
						first = false;
					} else {
						currentAddress = line.substring(buffer,i);
					} 
                    buffer = i;
                } else if (i == line.length()-1) {
                    currentID = (int)line.substring(buffer,line.length());
                }
            }
			Library addLibrary = new Library(currentName, currentAddress, currentID);
			libraries.add(addLibrary);
			buffer = -1;
			first = true;
            line = reader.readLine();
        }
	}

	private void libraryWriteFile() {
		FileWriter writer = new FileWriter("libraryStorage.txt");
        PrintWriter printer = new PrintWriter(writer);
		for (int i = 0; i < libraries.size(); i++) {
			printer.println(libraries.get(i).getName() + "," + libraries.get(i).getAddress() + "," + libraries.get(i).getID());
		}
	}

	// Admin methods

	private void adminReadFile() {
		String line = reader.readLine();
		int buffer = -1;
        String currentUsername = "";
		String currentPassword = "";

		while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
					currentUsername = line.substring(0,i);
					first = false;
                    buffer = i;
                } else if (i == line.length()-1) {
                    currentPassword = (int)line.substring(buffer,line.length());
                }
            }
			Library addLibrary = new Library(currentName, currentAddress, currentID);
			libraries.add(addLibrary);
			buffer = -1;
            line = reader.readLine();
        }
	}

	// Checks if entered username and password are in the system.
	private boolean checkAdmin(String enteredUser, String enteredPass) {
		// Do this later
	}

	// Member methods

	private void addMember(Member memberIn) {
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
						currentBirthdate = (int)line.substring(0,i);
					} else if (count == 2) {
						currentFirstname = line.substring(buffer,i);
					} else if (count == 3) {
						currentLastname = line.substring(buffer,i);
					} else if (count == 4) {
						currentGender = line.substring(buffer,i);
					} 
                    buffer = i;
                } else if (i == line.length()-1) {
                    currentID = (int)line.substring(buffer,line.length());
                }
            }
			Member addMember = new Member(currentBirthdate, currentFirstname, currentLastname, currentGender, currentID);
			members.add(addMember);
			buffer = -1;
			count = 1;
            line = reader.readLine();
        }
	}

	private void memberWriteFile() {
		FileWriter writer = new FileWriter("memberStorage.txt");
        PrintWriter printer = new PrintWriter(writer);
		for (int i = 0; i < members.size(); i++) {
			printer.println(members.get(i).getBirthdate() + "," + members.get(i).getFirstname() + "," + members.get(i).getLastname() + "," + members.get(i).getGender() + "," + members.get(i).getID());
		}
	}
}
