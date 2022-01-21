package ua.foxminded.collectionframework;

import java.util.Map;

public interface CharCounter {
    Map<Character, Long> count(String text);
}
