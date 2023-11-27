import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
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
			} 
			if (findLibrary(configInts.get(0)) == null) {
				Library failSafe = new Library("Failsafe Activated", "0", -1, -1, -1);
				currentLibrary = failSafe;
			} else {
				currentLibrary = findLibrary(configInts.get(0));
			}

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

	static void changeConfigInts(int index) {
		configInts.set(index, configInts.get(index) + 1);
		writeConfig();
	}

	// Library Methods

	static Library getCurrentLibrary() {
		return currentLibrary;
	}

	static ArrayList<Library> getAllLibraries() {
		return libraries;
	}

	static void addLibrary(Library libraryIn, boolean reading) {
		if (!reading) {
			boolean isTrue = false;
			for (int i = 0; i < libraries.size(); i++) {
				if (libraries.get(i).getID() == libraryIn.getID() || (libraryIn.getName().equals(libraries.get(i).getName()) && libraryIn.getAddress().equals(libraries.get(i).getAddress()))) {
					libraryIn.setNextID(libraryIn.getID());
					i = libraries.size();
					isTrue = true;
				}
			}
			if (!isTrue) {
				if (libraryIn.getName() == null ||  libraryIn.getAddress() == null) {

				} else {
					libraries.add(libraryIn);
					changeConfigInts(1);
					libraryWriteFile();
				}
			}
		} else {
			boolean isSame = false;
			for (int i = 0; i < libraries.size(); i++) {
				if (libraries.get(i).getID() == libraryIn.getID() || (libraryIn.getName().equals(libraries.get(i).getName()) && libraryIn.getAddress().equals(libraries.get(i).getAddress()))) {
					isSame = true;
				}
			}
			if (!isSame) {
				libraries.add(libraryIn);
				
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
			int count = 1;
			String currentName = "";
			String currentAddress = "";
			int currentNumBooks = -1;
			int currentNumBorrowedBooks = -1;
			int currentID = -1;
			while (line != null ) {
           	 	for (int i = 0; i < line.length(); i++) {
             	  	if (line.charAt(i) == ',') {
						if (count == 1) {
							currentID = Integer.parseInt(line.substring(0,i));
						} else if (count == 2) {
							currentName = line.substring(buffer + 1,i);
						} else if (count == 3) {
							currentAddress = line.substring(buffer + 1,i);
						} else if (count == 4) {
							currentNumBooks = Integer.parseInt(line.substring(buffer + 1,i));
						}
                    	buffer = i;
						count++;
                	} else if (i == line.length()-1) {
						currentNumBorrowedBooks = Integer.parseInt(line.substring(buffer + 1,line.length()));
                	}
            	}
				Library addLibrary = new Library(currentName, currentAddress, currentNumBooks, currentNumBorrowedBooks, currentID);
				libraries.add(addLibrary);
				buffer = -1;
				count = 1;
            	line = reader.readLine();
			
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
				printer.println(libraries.get(i).getID() + "," + libraries.get(i).getName() + "," + libraries.get(i).getAddress() + "," + libraries.get(i).getNumBooks() + "," + libraries.get(i).getNumBorrowedBooks());
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


	// Member methods

	static void addMember(Member memberIn) {
		boolean isTrue = false;
		if (members.size() > 0) {
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i).getID() == memberIn.getID() || (memberIn.getFirstname().equals(members.get(i).getFirstname()) && memberIn.getLastname().equals(members.get(i).getLastname()) && memberIn.getAddress().equals(members.get(i).getAddress()) && memberIn.getBirthyear() == (members.get(i).getBirthyear()))) {
					i = members.size();
					isTrue = true;
					memberIn.setNextID(memberIn.getID());
				}
			}
		}
		if (!isTrue) {
			members.add(memberIn);
			memberWriteFile();
			changeConfigInts(3);
		}
	}

	static Member findMember(int memberID) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getID() == memberID) {
				return members.get(i);
			}
		}
		return null;
	}

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

	static ArrayList<Member> getAllMembers() {
		return members;
	}
	

	static void memberReadFile() {
		
		try {
			members = new ArrayList<Member>();
			BufferedReader reader = new BufferedReader(new FileReader("memberStorage.txt"));
			String line = reader.readLine();
			int buffer = -1;
			int count = 1;
			int currentBirthdate = -1;
			String currentFirstname = "";
			String currentLastname = "";
			String currentGender = "";
			String currentAddress = "";
			ArrayList<Integer> borrowedID = new ArrayList<>();
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
						} else if (count == 5) {
							currentAddress = line.substring(buffer + 1,i);
						} else if (count == 6) {
							currentBirthdate = Integer.parseInt(line.substring(buffer + 1,i));
						} else {
							borrowedID.add(Integer.parseInt(line.substring(buffer + 1,i)));
						}
        	            buffer = i;
						count++;
        	        } else if (i == line.length()-1) {
						borrowedID.add(Integer.parseInt(line.substring(buffer + 1,line.length())));
        	        }
        	    }
				Member addMember = new Member(currentBirthdate, currentFirstname, currentLastname, currentGender, currentAddress, currentID, borrowedID);
				members.add(addMember);
				buffer = -1;
				count = 1;
        	    line = reader.readLine();
        	}

		} catch(FileNotFoundException fnf) {
            System.out.println("Member storage file is not there!");
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
			String toPrint = "";
			for (int i = 0; i < members.size(); i++) {
				toPrint = (members.get(i).getID() + "," + members.get(i).getFirstname() + "," + members.get(i).getLastname() + "," + members.get(i).getGender() + "," + members.get(i).getAddress() + "," + members.get(i).getBirthyear());
				if (members.get(i).getBorrowed() != null && !members.get(i).getBorrowed().isEmpty()) {
					for (int j = 0; j < members.get(i).getBorrowed().size(); j++) {
						toPrint += ("," + members.get(i).getBorrowed().get(j).getId());
					}
				} else {
					toPrint += (",-1");
				}
				
				printer.println(toPrint);
			}
			printer.close();

		} catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
	}

	// Book methods

	static void bookWriteFile() {
		try {
        	FileOutputStream fos = new FileOutputStream("bookStorage.bin");
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i=0; i<libraries.size(); i++) {
				for (int j = 0; j < libraries.get(i).getNumBooks(); j++) {
					oos.writeObject(libraries.get(i).getBook(j));
				}
			}
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}

		static void borrowedBookWriteFile() {
		try {
        	FileOutputStream fos = new FileOutputStream("borrowedBookStorage.bin");
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i=0; i<libraries.size(); i++) {
				ArrayList<BorrowedBook> borrowedBooks = libraries.get(i).getAllBorrowedBooks();
				if (!borrowedBooks.isEmpty() && borrowedBooks.size() > 0) {
					for (int j = 0; j < borrowedBooks.size(); j++) {
						oos.writeObject(borrowedBooks.get(j));
					}
				}
			}
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}

	

	static Book checkAllBooks(Book bookIn) {
		for (int i = 0; i < libraries.size(); i++) {
			for (int j = 0; j < libraries.get(i).getNumBooks(); j++) {
				if (libraries.get(i).getBook(j).getId() == bookIn.getId() || (libraries.get(i).getBook(j).getName().equals(bookIn.getName()) && libraries.get(i).getBook(j).getAuthor().equals(bookIn.getAuthor()) && (libraries.get(i).getBook(j).getDewey() == bookIn.getDewey()))) {
					return libraries.get(i).getBook(j);
				}
			}
		}
		return null;
	}

	// Analytics methods

	static Library getMostDewey(int deweyIn) {
		int highestAmount = 0;
		int currentAmount = 0;
		Library highestLibrary = new Library("None", "None", -1, -1, -1);
		for (int i = 0; i < libraries.size(); i++) {
			for (int j = 0; j < libraries.get(i).getAllBooks().size(); j++) {
				if (libraries.get(i).getAllBooks().get(j).getDewey() == deweyIn) {
					currentAmount++;
				}
			}
			if (currentAmount > highestAmount) {
				highestLibrary = libraries.get(i);
			}
			currentAmount = 0;
		}
		return highestLibrary;
	}

	static int getAveAge(int deweyIn) {
		int ageTotal = 0;
		int count = 0;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getBorrowed() != null) {
				for (int j = 0; j < members.get(i).getBorrowed().size(); j++) {
					if (members.get(i).getBorrowed().get(j).getDewey() == deweyIn) {
						ageTotal += members.get(i).getAge();
						count++;
					}
				}
			}
		}
		if (count != 0) {
			return (ageTotal / count);
		} else {
			return 0;
		}
	}

	static String getTopGender(int deweyIn) {
		int maleTotal = 0;
		int femaleTotal = 0;
		int otherTotal = 0;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getBorrowed() != null) {
				for (int j = 0; j < members.get(i).getBorrowed().size(); j++) {
					if (members.get(i).getBorrowed().get(j).getDewey() == deweyIn) {
						if (members.get(i).getGender().equals("Male")) {
							maleTotal++;
						} else if (members.get(i).getGender().equals("Female")) {
							femaleTotal++;
						} else if (members.get(i).getGender().equals("Other")) {
							otherTotal++;
						}
					}
				}
			}
		} // Temporary checks
		if (maleTotal == 0 && femaleTotal == 0 && otherTotal == 0) {
			return ("no one");
	 	} else if (maleTotal > femaleTotal && maleTotal > otherTotal) {
			return ("males");
		} else if (femaleTotal > maleTotal && femaleTotal > otherTotal) {
			return ("females");
		} else if (otherTotal > maleTotal && otherTotal > femaleTotal) {
			return ("other genders");
		} else if (maleTotal == femaleTotal && otherTotal < maleTotal) {
			return ("males and females");
		} else if (otherTotal == maleTotal && otherTotal < femaleTotal) {
			return ("males and other genders");
		} else if (femaleTotal == otherTotal && otherTotal > maleTotal) {
			return ("female and other genders");
		} else {
			return ("all genders");
		}
	}

	
}
