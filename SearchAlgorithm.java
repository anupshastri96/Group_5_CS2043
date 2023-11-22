import java.util.ArrayList;


public class SearchAlgorithm {
    // All search algorithms should go in here.

    private static ArrayList<Integer> toReturn;
    

    static ArrayList<Integer> getResults() {
        return toReturn;
    }
    

    static void librarySearch (String name, String address, String ID) {
        ArrayList<Library> libraries = LibraryManagementSystem.getAllLibraries();
        toReturn = new ArrayList<Integer>();
        boolean added = false;
        boolean canBeAdded = true;
        int smallestName = -1;
        int smallestAddress = -1;

        for (int i = 0; i < libraries.size(); i++) {
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
                } else if (name.length() < libraries.get(i).getName().length()) {
                    smallestName = name.length();
                } else {
                    smallestName = name.length();
                }

                if (smallestName > 0 && canBeAdded) {
                    for (int j = 0; j < smallestName; j++) {
                        if (name.charAt(j) != libraries.get(i).getName().charAt(j)) {
                            canBeAdded = false;
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
                } else if (address.length() < libraries.get(i).getAddress().length()) {
                    smallestAddress = address.length();
                } else {
                    smallestAddress = address.length();
                }

                if (smallestAddress > 0 && canBeAdded && !added) {
                    for (int j = 0; j < smallestAddress; j++) {
                        if (address.charAt(j) != libraries.get(i).getAddress().charAt(j)) {
                            canBeAdded = false;
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