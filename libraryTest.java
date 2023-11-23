import java.util.ArrayList;
import java.util.Scanner;

public class libraryTest {
	static ArrayList<Library> liblist = new ArrayList<Library>();
	static Library placeholder = new Library("place", "1holder");
    public static void main(String[] args) {
/*
    	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter library quantity:");
        String number = myObj.nextLine();  // Read user input
        int libquant = Integer.valueOf(number);
        
       
        LibraryManagementSystem l1 = new LibraryManagementSystem(placeholder);
        
        
        libadd(libquant);
        lbmsadd(l1);
        
        
        Member m1 = new Member(2000, "First", "Last", "Male");
        Member m2 = new Member(2001, "First", "Last", "Female");


        l1.addMember(m1);
        l1.addMember(m2);
   */
    }
    private static void libadd(int quant) 
    {
    	for(int i = 0; i<quant;i++) {
    	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    	int num = i+1;
        System.out.println("Enter library name"+" "+num+":");

        String userName = myObj.nextLine();  // Read user input
        
        Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter street name"+" "+num+":");

        String useraddy = myObj.nextLine();  // Read user input
        Library lib1 = new Library(userName, useraddy);
        liblist.add(lib1);
        //System.out.println("Username is: " + userName);  // Output user input
        
    	
    	}
    	
    	
    }
    static void lbmsadd(LibraryManagementSystem l1) 
    {
    	//LibraryManagementSystem l1 = new LibraryManagementSystem(placeholder);
    	for(int i = 0; i<liblist.size();i++) {
    		l1.addLibrary(liblist.get(i));
    	}
    	
    	
    	
    }
}