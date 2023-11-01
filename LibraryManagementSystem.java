import java.util.ArrayList;
public class LibraryManagementSystem {
// This could end up just being added to the main class instead.
	
	private ArrayList<Libary> libraries;
	private ArrayList<Member> members;
	private ArrayList<Admin> admins;
	private int loginType;
	private Library currentLibrary;
	
	// Only the current library should be a parameter because everything else should be read in through a file.
	public LibraryManagementSystem(Library currentLibrary) {
		
		//Either helper methods will be used or it will all be done here to actually take the data from the text files and put it in the arrays.
		libraries = new ArrayList<Library>();
		members = new ArrayList<Member>();
		admins = new ArrayList<Admin>();
		
		
		// Something should be implemented to check if the current library is in the system.
		this.currentLibrary = currentLibrary;
		
	}
	
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
			}
		}
	}
	
	private void removeLibrary(Member memberIn) {
		if (loginType == 1) {
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i).getID() == memberIn.getID()) {
					members.remove(i);
					i = members.size();
				}
			}
		}
	}
}
