package academy.softserve.sprint04.task03;

/**
 * Create a listMapCompare() method of the MyUtils class to compare the contents of a list of strings and the values of a map.
 * For example, for a given list
 * [aa, bb, aa, cc]
 * and map
 * {1=cc, 2=bb, 3=cc, 4=aa, 5=cc}
 * you should get true.
 *
 * import java.util.Set;
 * import java.util.HashSet;
 * import java.util.List;
 * import java.util.Map;
 * public class MyUtils {
 *     // Code
 *     public boolean listMapCompare(List<String> list, Map<String, String> map) {
 *         // Code
 *     }
 * }
 *
 */


import java.util.*;

public class MyUtils {
    // Code
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        // Code
        return list.containsAll(map.values());
    }
}

class task03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("aa");
        list.add("cc");

        Map<String, String> map =new HashMap<>();
        map.put("1", "cc");
        map.put("2", "bb");
        map.put("3", "cc");
        map.put("4", "aa");
        map.put("5", "cc");
        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.listMapCompare(list,map));
    }
}
