package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("A", "ABC");
        testMap.put("B", "BCD");

        // This returns "it is null" as testMap::get can take Map input and returns null output
        System.out.println(Optional.ofNullable(testMap).map(testMap::get).orElse("it is null"));

        Optional<Map<String, String>> optionalMap = Optional.ofNullable(testMap);
        System.out.println(optionalMap.isPresent());
    }
}
