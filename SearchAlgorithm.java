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

<<<<<<< HEAD
    static void memberSearch (String firstname, String lastname, String gender, String address, String ID) {
=======
    static void memberSearch (String firstname, String lastname, String gender, String ID) {
>>>>>>> main
        ArrayList<Library> members = LibraryManagementSystem.getAllMembers();
        toReturn = new ArrayList<Integer>();
        boolean added = false;
        boolean canBeAdded = true;
        int smallestFirstname = -1;
        int smallestLastname = -1;
        int smallestGender = -1;
<<<<<<< HEAD
        int smallestAddress = -1;
=======
>>>>>>> main

        for (int i = 0; i < members.size(); i++) {
            
            if (firstname.length() < 1 && lastname.length() && gender.length() && address.length() < 1 && ID.length() < 1) {
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
                    if (gender.length() > members.get(i).getGender().length()) {
                        canBeAdded = false;
                    } else {
                        smallestGender = gender.length();
                    }

                    if (smallestGender > 0 && canBeAdded) {
                        for (int j = 0; j < smallestGender; j++) {
                            if (gender.charAt(j) != members.get(i).getGender().charAt(j)) {
                                canBeAdded = false;
                                j = smallestGender;
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

<<<<<<< HEAD
                    // Fifth check
                    if (address.length() > members.get(i).getAddress().length()) {
                        canBeAdded = false;
                    } else {
                        smallestAddress = address.length();
                    }

                    if (smallestAddress > 0 && canBeAdded) {
                        for (int j = 0; j < smallestAddress; j++) {
                            if (address.charAt(j) != members.get(i).getAddress().charAt(j)) {
                                canBeAdded = false;
                                j = smallestAddress;
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

=======
>>>>>>> main
                }
                smallestFirstname = -1;
                smallestLastname = -1;
                smallestGender = -1;
<<<<<<< HEAD
                smallestAddress = -1;
=======
>>>>>>> main
                added = false;
                canBeAdded = true;

            }
        }

    }
}