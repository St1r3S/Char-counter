package ua.foxminded.collectionframework;

import java.util.LinkedHashMap;
import java.util.Map;

public class BasicCharCounter implements CharCounter {

    private final Map<Character, Long> charCountMap = new LinkedHashMap<>();

    @Override
    public Map<Character, Long> count(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text can't be null!");
        }
        char[] strArray = text.toCharArray();
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1L);
            }
        }
        return charCountMap;
    }
}
