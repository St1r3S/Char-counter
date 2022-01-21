package ua.foxminded.collectionframework;

import java.util.Map;


public class BasicCacheCharCounter extends CacheCharCounterDecorator {
    
    public BasicCacheCharCounter(CharCounter counter, Map<String, Map<Character, Long>> stringCache) {
        super(counter, stringCache);
    }

    @Override
    public Map<Character, Long> count(String text) {
        return super.count(text);
    }


}
