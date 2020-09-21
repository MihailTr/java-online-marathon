package academy.softserve.sprint04.task01;

/**
 * Create a createNotebook() method of the MyUtils class to create
 * a new map with name as key and phone list as value.
 * The method receives a map  with phone as key and name as value.
 * For example, for a given map {0967654321=Petro, 0677654321=Petro,
 * 0501234567=Ivan, 0970011223=Stepan, 0631234567=Ivan}
 * you should get
 * {Ivan=[0501234567, 0631234567], Petro=[0967654321, 0677654321], Stepan=[0970011223]}.
 * <p>
 * import java.util.ArrayList;
 * import java.util.HashMap;
 * import java.util.List;
 * import java.util.Map;
 * public class MyUtils {
 * // Code
 * public Map<String, List<String>> createNotebook(Map<String, String> phones) {
 * // Code
 * }
 * }
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {
    // Code
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        // Code
        Map<String, List<String>> newNote = new HashMap<>();
        newNote.clear();
        if (phones == null) {
            return null;
        }
        if (phones.size() == 0) {
            return newNote;
        }
//        for (Map.Entry<String, String> o:phones.entrySet()) {
//            if (o==null) return null;
//            if (o.getValue()==null){
//                List<String> expectedlist = new ArrayList<>();
//                expectedlist.add(o.getValue());
//                Map<String, List<String>> expected = new HashMap<>();
//                expected.put(o.getKey(), expectedlist);
//                return expected;
//            }
//            if (o.getKey()==null){
//                List<String> expectedlist = new ArrayList<>();
//                expectedlist.add(o.getKey());
//                Map<String, List<String>> expected = new HashMap<>();
//                expected.put(o.getValue(), expectedlist);
//                return expected;
//            }
//        }
        for (Map.Entry<String, String> o:phones.entrySet()) {
            List<String>number = new ArrayList<>();

            String tmp = o.getKey();
            if (!newNote.containsKey(o.getValue())) {
                number.add(o.getKey());
                newNote.put(o.getValue(), number);
            }else {
                List<String> current = newNote.get(o.getValue());
                current.add(tmp);
                newNote.put(o.getValue(), current);
            }
        }
        return newNote;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class task01 {
    public static void main(String[] args) {
        Map<String, String> example = new HashMap<>();
        example.put("0967654321", "Petro");
        example.put("0677654321", "Petro");
        example.put("0501234567", "Ivan");
        example.put("0970011223", "Stepan");
        example.put("0631234567", "Ivan");
        example.put(null, "Ivan");
        example.put("0501234567", null);
        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.createNotebook(example));
        Map<String, List<String>> test = myUtils.createNotebook(example);
        for (Map.Entry<String, List<String>> l: test.entrySet()){
            System.out.println(l.toString());
        }
    }
}
