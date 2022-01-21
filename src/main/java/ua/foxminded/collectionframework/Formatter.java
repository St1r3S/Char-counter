package ua.foxminded.collectionframework;

import java.util.Map;
import java.util.stream.Collectors;

public class Formatter {
    public String apply(Map<Character, Long> calculations) {
        String resultAsString = calculations.keySet().stream()
                .map(key -> "\"" + key + "\" - " + calculations.get(key) + "\n")
                .collect(Collectors.joining());
        return resultAsString.trim();
    }
}
