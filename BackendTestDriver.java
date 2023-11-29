public class BackendTestDriver {

    public static void main(String[] args) {
        // Test case 1: Create an Admin instance with specific username and password
        Admin admin1 = new Admin("adminUser1", "adminPass1");
        System.out.println("Test Case 1:");
        System.out.println("Username: " + admin1.getUsername());
        System.out.println("Password: " + admin1.getPassword());
        System.out.println();

        // Test case 2: Create another Admin instance with different values
        Admin admin2 = new Admin("adminUser2", "adminPass2");
        System.out.println("Test Case 2:");
        System.out.println("Username: " + admin2.getUsername());
        System.out.println("Password: " + admin2.getPassword());
        System.out.println();

        // Test case 3: Change the username and password of admin2
        admin2.setUsername("newAdminUser2");
        admin2.setPassword("newAdminPass2");
        System.out.println("Test Case 3 (Updated):");
        System.out.println("Username: " + admin2.getUsername());
        System.out.println("Password: " + admin2.getPassword());
    }
}
