import java.util.ArrayList;


public class SearchAlgorithm {

    private static ArrayList<Integer> toReturn;
    

    static ArrayList<Integer> getResults() {
        return toReturn;
    }
    
    // Make all of these not case sensitive
    static void librarySearch (String name, String address, String ID) {
        ArrayList<Library> libraries = LibraryManagementSystem.getAllLibraries();
        toReturn = new ArrayList<Integer>();
        boolean added = false;
        boolean canBeAdded = true;
        int smallestName = -1;
        int smallestAddress = -1;

        for (int i = 0; i < libraries.size(); i++) {
            
            if (name.length() < 1 && address.length() < 1 && ID.length() < 1) {
                toReturn.add(libraries.get(i).getID());
            } else {
                // First check
                if (ID.length() > 0) {
                    if (Integer.parseInt(ID) == libraries.get(i).getID()) {
                        toReturn.clear();
                        toReturn.add(libraries.get(i).getID());
                        i = libraries.size();
                    } else {
                        canBeAdded = false;
                    }
                } else {
                    // Second check
                    if (name.length() > libraries.get(i).getName().length()) {
                        canBeAdded = false;
                    } else {
                        smallestName = name.length();
                    }

                    if (smallestName > 0 && canBeAdded) {
                        for (int j = 0; j < smallestName; j++) {
                            if (name.charAt(j) != libraries.get(i).getName().charAt(j)) {
                                canBeAdded = false;
                                j = smallestName;
                            }
                        }
                        if (canBeAdded) {
                            toReturn.add(libraries.get(i).getID());
                            added = true;
                        }
                    }

                    // Third check
                    if (address.length() > libraries.get(i).getAddress().length()) {
                        canBeAdded = false;
                    } else {
                        smallestAddress = address.length();
                    }

                    if (smallestAddress > 0 && canBeAdded) {
                        for (int j = 0; j < smallestAddress; j++) {
                            if (address.charAt(j) != libraries.get(i).getAddress().charAt(j)) {
                                canBeAdded = false;
                                j = smallestAddress;
                                if (added) {
                                    toReturn.remove(toReturn.size() - 1);
                                }
                            }
                        }
                        if (canBeAdded) {
                            toReturn.add(libraries.get(i).getID());
                            added = true;
                        }
                    }

                }
                smallestName = -1;
                smallestAddress = -1;
                added = false;
                canBeAdded = true;

            }
        }

    }

    static void memberSearch (String firstname, String lastname, int gender, String ID) {
        ArrayList<Member> members = LibraryManagementSystem.getAllMembers();
        toReturn = new ArrayList<Integer>();
        boolean added = false;
        boolean canBeAdded = true;
        int smallestFirstname = -1;
        int smallestLastname = -1;
        int otherGender = -1;

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getGender().equals("Male")) {
                otherGender = 1;
            } else if (members.get(i).getGender().equals("Female")) {
                otherGender = 2;
            } else if (members.get(i).getGender().equals("Other")) {
                otherGender = 3;
            } else {
                otherGender = 0;
            }
            
            if (firstname.length() < 1 && lastname.length() < 1 && gender == 0 && ID.length() < 1) {
                toReturn.add(members.get(i).getID());
            } else {
                // First check
                if (ID.length() > 0) {
                    if (Integer.parseInt(ID) == members.get(i).getID()) {
                        toReturn.clear();
                        toReturn.add(members.get(i).getID());
                        i = members.size();
                    } else {
                        canBeAdded = false;
                    }
                } else {
                    // Second check
                    if (firstname.length() > members.get(i).getFirstname().length()) {
                        canBeAdded = false;
                    } else {
                        smallestFirstname = firstname.length();
                    }

                    if (smallestFirstname > 0 && canBeAdded) {
                        for (int j = 0; j < smallestFirstname; j++) {
                            if (firstname.charAt(j) != members.get(i).getFirstname().charAt(j)) {
                                canBeAdded = false;
                                j = smallestFirstname;
                            }
                        }
                        if (canBeAdded) {
                            toReturn.add(members.get(i).getID());
                            added = true;
                        }
                    }

                    // Third check
                    if (lastname.length() > members.get(i).getLastname().length()) {
                        canBeAdded = false;
                    } else {
                        smallestLastname = lastname.length();
                    }

                    if (smallestLastname > 0 && canBeAdded) {
                        for (int j = 0; j < smallestLastname; j++) {
                            if (lastname.charAt(j) != members.get(i).getLastname().charAt(j)) {
                                canBeAdded = false;
                                j = smallestLastname;
                                if (added) {
                                    toReturn.remove(toReturn.size() - 1);
                                }
                            }
                        }
                        if (canBeAdded) {
                            toReturn.add(members.get(i).getID());
                            added = true;
                        }
                    }

                    // Fourth check
                    if (gender != otherGender) {
                        canBeAdded = false;
                        if (added) {
                            toReturn.remove(toReturn.size() - 1);
                        }
                    } else {
                        if (canBeAdded) {
                            toReturn.add(members.get(i).getID());
                            added = true;
                        }
                    }



                }
                smallestFirstname = -1;
                smallestLastname = -1;
                otherGender = -1;
                added = false;
                canBeAdded = true;

            }
        }

    }

/*
    static void bookSearch (String name, String author, int gender, String ID) {
        ArrayList<Book> books = LibraryManagementSystem.getCurrentLibrary().getAllBooks();
        toReturn = new ArrayList<Integer>();
        boolean added = false;
        boolean canBeAdded = true;
        int smallestFirstname = -1;
        int smallestLastname = -1;
        int otherGender = -1;

        for (int i = 0; i < books.size(); i++) {
            if (firstname.length() < 1 && lastname.length() < 1 && gender == 0 && ID.length() < 1) {
                toReturn.add(members.get(i).getID());
            } else {
                // First check
                if (ID.length() > 0) {
                    if (Integer.parseInt(ID) == members.get(i).getID()) {
                        toReturn.clear();
                        toReturn.add(members.get(i).getID());
                        i = members.size();
                    } else {
                        canBeAdded = false;
                    }
                } else {
                    // Second check
                    if (firstname.length() > members.get(i).getFirstname().length()) {
                        canBeAdded = false;
                    } else {
                        smallestFirstname = firstname.length();
                    }

                    if (smallestFirstname > 0 && canBeAdded) {
                        for (int j = 0; j < smallestFirstname; j++) {
                            if (firstname.charAt(j) != members.get(i).getFirstname().charAt(j)) {
                                canBeAdded = false;
                                j = smallestFirstname;
                            }
                        }
                        if (canBeAdded) {
                            toReturn.add(members.get(i).getID());
                            added = true;
                        }
                    }

                    // Third check
                    if (lastname.length() > members.get(i).getLastname().length()) {
                        canBeAdded = false;
                    } else {
                        smallestLastname = lastname.length();
                    }

                    if (smallestLastname > 0 && canBeAdded) {
                        for (int j = 0; j < smallestLastname; j++) {
                            if (lastname.charAt(j) != members.get(i).getLastname().charAt(j)) {
                                canBeAdded = false;
                                j = smallestLastname;
                                if (added) {
                                    toReturn.remove(toReturn.size() - 1);
                                }
                            }
                        }
                        if (canBeAdded) {
                            toReturn.add(members.get(i).getID());
                            added = true;
                        }
                    }

                    // Fourth check
                    if (gender != otherGender) {
                        canBeAdded = false;
                        if (added) {
                            toReturn.remove(toReturn.size() - 1);
                        }
                    } else {
                        if (canBeAdded) {
                            toReturn.add(members.get(i).getID());
                            added = true;
                        }
                    }



                }
                smallestFirstname = -1;
                smallestLastname = -1;
                otherGender = -1;
                added = false;
                canBeAdded = true;

            }
        }

    } */
}