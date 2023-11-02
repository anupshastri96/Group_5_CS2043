package LibraryManagementSystem;

public class Book {

    private String name;
    private String author;
    private static int nextId = 0000000;
    private final int bookId;
    private String genre;
    private String status;
    private int ageRating;
    private boolean isBorrowed;

    public Book(String nameIn, String authorIn, String genreIn, String statusIn, int ageRatingIn) {
        name = nameIn;
        author = authorIn;
        genre = genreIn;
        status = statusIn;
        ageRating = ageRatingIn;
        bookId = createID(genre, nextId);
        isBorrowed = false;
    }

    /*
     * toString overwrite
     */
    public String toString() {
        String s;
        s = "Name: " + getName() + "\n" +
            "Author: " + getAuthor() + "\n" +
            "Genre: " + getGenre() + "\n" +
            "Status: " + getStatus() + "\n" +
            "Age Rating: " + getAgeRating() + "\n" +
            "Book ID: " + getId() + "\n" +
            "Currently borrowed: " + getBorrowed() + "\n";
        
        return s;
    }


    private int createID(String g, int num) {
        int dewey;
        int fullId;

        if(g == "Philosophy & psychology") dewey = 100;
        else if(g == "Religion") dewey = 200;
        else if(g == "Social sciences") dewey = 300;
        else if(g == "Language") dewey = 400;
        else if(g == "Natural sciences & mathematics") dewey = 500;
        else if(g == "Technology (Applied sciences)") dewey = 600;
        else if(g == "The arts") dewey = 700;
        else if(g == "Literature & rhetoric") dewey = 800;
        else if(g == "Geography & history") dewey = 900;
        else dewey = 000;

        fullId = (num * 1000) + dewey;
        return fullId;
    }

    /* 
     * NAME METHODS 
     */
    public String getName() {
        return name;
    }

    public void changeName(String s) {
        name = s;
    }

    /* 
     * AUTHOR METHODS 
     */
    public String getAuthor() {
        return author;
    }

    public void changeAuthor(String s) {
        author = s;
    }

    /* 
     * GENRE METHODS 
     */
    public String getGenre() {
        return genre;
    }

    /* 
     * STATUS METHODS 
     */
    public String getStatus() {
        return status;
    }

    public void changeStatus(String s) {
        status = s;
    }

    /* 
     * AGE RATING METHODS 
     */
    public int getAgeRating() {
        return ageRating;
    }

    public void changeAgeRating(int n) {
        ageRating = n;
    }

    /* 
     * ID METHODS 
     */
    public int getId() {
        return bookId;
    }
    
    /* 
     * ISBORROWED METHODS 
     */
    public boolean getBorrowed() {
        return isBorrowed;
    }
    
    public void borrowBook() {
    	isBorrowed = true;
    }
    
    public void returnBook() {
    	isBorrowed = false;
    }

}
