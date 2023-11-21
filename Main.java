public class Main {
    public static void main(String[] args) {

		LibraryManagementSystem.libraryReadFile();
		LibraryManagementSystem.memberReadFile();
		LibraryManagementSystem.adminReadFile();
		LibraryManagementSystem.readConfig();

        LibraryStart start = new LibraryStart();

    }
}