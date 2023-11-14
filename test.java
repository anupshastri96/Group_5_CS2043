public class test {
    public static void main(String[] args) {


        Library lib1 = new Library("library1", "123 Street");
        Library lib2 = new Library("library2", "124 Street");
        Library lib3 = new Library("library3", "125 Street");
        Library lib4 = new Library("library4", "126 Street");
        Library lib5 = new Library("library5", "127 Street");
        Library lib6 = new Library("library6", "128 Street");
        Library lib7 = new Library("library7", "129 Street");
        Library lib8 = new Library("library8", "130 Street");
        Library lib9 = new Library("library9", "131 Street");
        Library lib10 = new Library("library10", "132 Street");
        
        Member m1 = new Member(2000, "First", "Last", "Male");
        Member m2 = new Member(2001, "First", "Last", "Female");
        
        LibraryManagementSystem l1 = new LibraryManagementSystem(lib1);

        l1.addLibrary(lib1);
        l1.addLibrary(lib2);
        l1.addLibrary(lib3);
        l1.addLibrary(lib4);
        l1.addLibrary(lib5);
        l1.addLibrary(lib6);
        l1.addLibrary(lib7);
        l1.addLibrary(lib8);
        l1.addLibrary(lib9);
        l1.addLibrary(lib10); 

        l1.addMember(m1);
        l1.addMember(m2);
        
    }
}