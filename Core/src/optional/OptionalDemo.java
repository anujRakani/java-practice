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

        String str = "test string";
        String derivedStr1 = Optional.ofNullable(str).orElse("other value");
        str = null;
        String derivedStr2 = Optional.ofNullable(str).orElse("other value");
        System.out.println(derivedStr1 + " || " + derivedStr2);


        OptionalDemoSample ods1 = new OptionalDemoSample("ods1");
        OptionalDemoSample ods2 = new OptionalDemoSample("ods2");

        OptionalDemoSample derivedODS1 = Optional.ofNullable(ods1).orElse(ods2);
        ods1 = null;
        OptionalDemoSample derivedODS2 = Optional.ofNullable(ods1).orElse(ods2);
        System.out.println(derivedODS1 + " || " + derivedODS2);
    }
}

class OptionalDemoSample {
    private String name;

    public OptionalDemoSample(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OptionalDemoSample{" +
                "name='" + name + '\'' +
                '}';
    }
}
