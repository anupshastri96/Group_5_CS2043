public class Main {
    public static void main(String[] args) {

		// This is the class that should be ran whenever the GUI is opened.

		LibraryManagementSystem.libraryReadFile();
		LibraryManagementSystem.memberReadFile();
		LibraryManagementSystem.adminReadFile();
		LibraryManagementSystem.readConfig();

        GUILibraryStart start = new GUILibraryStart();

    }
}