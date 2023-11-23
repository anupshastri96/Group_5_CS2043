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
	
	private static ArrayList<Library> libraries;
	private static ArrayList<Member> members;
	private static ArrayList<Admin> admins;
	private static ArrayList<Integer> configInts;

	private static Library currentLibrary;
	private static int loginType;

	// Config Methods

	static void readConfig() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
			String line = reader.readLine();
			int buffer = 0;
			int count = 1;
			configInts = new ArrayList<Integer>();
			if (line != null) {
				for (int i = 0; i < line.length(); i++) {
             		if (line.charAt(i) == ',') {
						configInts.add(Integer.parseInt(line.substring(buffer,i)));
                	} else if (i == line.length()-1) {
						configInts.add(Integer.parseInt(line.substring(buffer + 1,line.length())));
                	}
					buffer = i;
            	}
			} else {
				//Add failsafe here
			}

			currentLibrary = findLibrary(configInts.get(0));
			Library fakeLibrary = new Library(configInts.get(1));
			Book fakeBook = new Book(configInts.get(2));
			Member fakeMember = new Member(configInts.get(3));
			BorrowedBook fakeBorrowedBook = new BorrowedBook(configInts.get(4));

		} catch(FileNotFoundException fnf) {
       		System.out.println("Config file is not there!");
        	System.exit(1);
    	} catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
	}

	static void writeConfig() {
		try {
			FileWriter writer = new FileWriter("config.txt");
        	PrintWriter printer = new PrintWriter(writer);
			printer.print(configInts.get(0) + "," + configInts.get(1) + "," + configInts.get(2) + "," + configInts.get(3) + "," + configInts.get(4));
			printer.close();

		} catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
	}

	// Library Methods

	static Library getCurrentLibrary() {
		return currentLibrary;
	}

	static ArrayList<Library> getAllLibraries() {
		return libraries;
	}

	static void addLibrary(Library libraryIn) {
		loginType = 1;
		if (loginType == 1) {
			boolean isTrue = false;
			for (int i = 0; i < libraries.size(); i++) {
				if (libraries.get(i).getID() == libraryIn.getID() || (libraryIn.getName().equals(libraries.get(i).getName()) && libraryIn.getAddress().equals(libraries.get(i).getAddress()))) {
					libraries.get(i).setNextID(libraries.get(i).getID() + 1);
					i = libraries.size();
					isTrue = true;
				}
			}
			if (!isTrue) {
				if (libraryIn.getName() == null ||  libraryIn.getAddress() == null) {

				} else {
					libraries.add(libraryIn);
					libraryWriteFile();
				}
			}
		}
	}
	
	static void removeLibrary(Library libraryIn) {
		if (loginType == 1) {
			for (int i = 0; i < libraries.size(); i++) {
				if (libraries.get(i).getID() == libraryIn.getID()) {
					libraries.remove(i);
					i = libraries.size();
					libraryWriteFile();
				}
			}
		}
	}
	
	static Library findLibrary(int libraryID) {
		for (int i = 0; i < libraries.size(); i++) {
			if (libraries.get(i).getID() == libraryID) {
				return libraries.get(i);
			}
		}
		return null;
	}

	static ArrayList<Library> findLibrary(ArrayList<Integer> libraryIDs) {
		ArrayList<Library> toReturn = new ArrayList<Library>();
		for (int i = 0; i < libraries.size(); i++) {
			for (int j = 0; j < libraryIDs.size(); j++) {
				if (libraries.get(i).getID() == libraryIDs.get(j)) {
					toReturn.add(libraries.get(i));
				}
			}
		}
		return toReturn;
	}
	
	static void libraryReadFile() {
		try {
			libraries = new ArrayList<Library>();
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

	static void libraryWriteFile() {
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

	static void changeCurrentLibrary(Library libraryIn) {
		currentLibrary = libraryIn;
		configInts.set(0, libraryIn.getID());
		writeConfig();
	}

	// Admin methods

	static void adminReadFile() {
		try {
			admins = new ArrayList<Admin>();
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

	static boolean checkAdmin(String enteredUser, String enteredPass) {
		for (int i = 0; i < admins.size(); i++) {
			if (enteredUser.equals(admins.get(i).getUsername()) && enteredPass.equals(admins.get(i).getPassword())) {
				loginType = 1;
				return true;
			}
		}
		return false;
	}

	public static void logOut() {
		loginType = 0;
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
		return toReturn;
	}

	static Member findMember(int memberID) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getID() == memberID) {
				return members.get(i);
			}
		}
		return null;
	}
	/* This will be completed when I get to it
	static Member findMember(String firstName, String lastName) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getID() == memberID) {
				return members.get(i);
			}
		}
		return null;
	}
	*/
	static ArrayList<Member> findMember(ArrayList<Integer> memberIDs) {
		ArrayList<Member> toReturn = new ArrayList<Member>();
		for (int i = 0; i < members.size(); i++) {
			for (int j = 0; j < memberIDs.size(); j++) {
				if (members.get(i).getID() == memberIDs.get(j)) {
					toReturn.add(members.get(i));
				}
			}
		}
		return toReturn;
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

	static void memberWriteFile() {
		try {
			FileWriter writer = new FileWriter("memberStorage.txt");
        	PrintWriter printer = new PrintWriter(writer);
			for (int i = 0; i < members.size(); i++) {
				printer.println(members.get(i).getID() + "," + members.get(i).getFirstname() + "," + members.get(i).getLastname() + "," + members.get(i).getGender() + "," + members.get(i).getBirthdate());
			}
			printer.close();

		} catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
	}
}
