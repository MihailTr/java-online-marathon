package academy.softserve.sprint07.task05;

/**
 * Let the key of Map is project name and value contains list of participants.
 * Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted stream of all participants without duplication.
 * Please ignore null or empty strings, extra spaces and case sensitivity.
 * Throw NullPointerException if map is null.
 * For example, for a given map
 * {"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
 * you should get
 * ["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]
 *
 * import java.util.Map;
 * import java.util.stream.Stream;
 *
 * public class MyUtils {
 *    public Stream<String> nameList(Map<String, Stream<String>> map) {
 *         // Code
 *     }
 * }
 */
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyUtils {
    public Stream<String> nameList(Map<String, Stream<String>> map) {
        // Code
        if (map.isEmpty()) {
            throw new NullPointerException();
        }

        return map.values()
                .stream()
                .flatMap(Function.identity())
                .filter(s -> s != null && !s.trim().isEmpty())
                .map(spaces -> spaces.replaceAll("\\s", ""))
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase())
                .distinct()
                .sorted();
    }
}