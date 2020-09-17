package academy.softserve.sprint03;

/**
 * Suppose we have the next class:
 * NameList class
 * <p>
 * Create public inner class named Iterator inside NameList class that correspond the next class diagram:
 * <p>
 * * For correct passing of all tests don't use print and println methods in your code.
 * <p>
 * class NameList {
 * private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};
 * <p>
 * public Iterator getIterator() {
 * return new Iterator();
 * }
 * <p>
 * // Write your code here
 * <p>
 * }
 */

class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    // Write your code here
    public class Iterator {
        private int counter = 0;

        private Iterator() {
        }

        public boolean hasNext() {
            if (names.length == 0) {
                return false;
            }
            if (counter < names.length) {
                return true;
            } else {
                return false;
            }
        }

        public String next() {
            return names[counter++];
        }
    }
}

public class task02 {
    public static void main(String[] args) {
        System.out.println(new NameList().getIterator().toString());
    }
}
