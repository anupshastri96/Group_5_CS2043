public class test {
    public static void main(String[] args) {
        Library lib1 = new Library("library1", "123 Street");
        Library lib2 = new Library("library2", "124 Street");
        Library lib3 = new Library("library3", "125 Street");
        Library lib5 = new Library("library5", "127 Street");
        LibraryManagementSystem l1 = new LibraryManagementSystem(lib1);

        l1.addLibrary(lib5);
        l1.addLibrary(lib1);
        l1.addLibrary(lib2);
        l1.addLibrary(lib3);
        
    }
}