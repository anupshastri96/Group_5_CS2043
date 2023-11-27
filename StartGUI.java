public class StartGUI {
    public static void main(String[] args) {

		// This is the class that should be ran whenever the GUI is opened.
		// ALWAYS CHECK STORAGE FILES BEFORE OPENING TO MAKE SURE THINGS LINE UP BECAUSE IF THEY ARENT THEN YOU WILL GET NULL POINTER EXCEPTIONS

		LibraryManagementSystem.libraryReadFile();
		LibraryManagementSystem.memberReadFile();
		LibraryManagementSystem.adminReadFile();
		LibraryManagementSystem.readConfig();

        GUILibraryStart start = new GUILibraryStart();

    }
}