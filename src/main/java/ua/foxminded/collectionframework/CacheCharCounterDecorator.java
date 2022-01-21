package ua.foxminded.collectionframework;

import java.util.Map;

public class CacheCharCounterDecorator implements CharCounter {

    private final CharCounter counter;
    private final Map<String, Map<Character, Long>> stringCache;

    public CacheCharCounterDecorator(CharCounter counter, Map<String, Map<Character, Long>> stringCache) {
        this.counter = counter;
        this.stringCache = stringCache;
    }

    @Override
    public Map<Character, Long> count(String text) {
        if (checkIfCached(text)) {
            return stringCache.get(text);
        }
        Map<Character, Long> mapToAdd = counter.count(text);
        cache(text, mapToAdd);
        return mapToAdd;
    }

    private Boolean checkIfCached(String text) {
        return stringCache.containsKey(text);
    }

    private void cache(String text, Map<Character, Long> map) {
        stringCache.put(text, map);
    }
}
