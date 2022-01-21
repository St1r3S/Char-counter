package ua.foxminded.collectionframework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.AtLeast;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class CacheCharCounterDecoratorTest {

    @InjectMocks
    CacheCharCounterDecorator cacheCharCounterDecorator;
    @Mock
    BasicCharCounter charCounter;
    @Mock
    Map<String, Map<Character, Long>> cache;


    private final String keyMeaning = "Hello world!";
    private final Map<Character, Long> testMap = new LinkedHashMap<Character, Long>() {{
        put('H', 1L);
        put('e', 1L);
        put('l', 3L);
        put('o', 2L);
        put(' ', 1L);
        put('w', 1L);
        put('r', 1L);
        put('d', 1L);
        put('!', 1L);
    }};

    @Test
    void shouldVerifyCacheEmpty() {
        when(charCounter.count(keyMeaning)).thenReturn(testMap);
        when(cache.containsKey(keyMeaning)).thenReturn(false);

        assertEquals(testMap, cacheCharCounterDecorator.count(keyMeaning));
        verify(charCounter).count(keyMeaning);
        verify(cache, atLeastOnce()).put(keyMeaning, testMap);
    }

    @Test
    void shouldVerifyCacheFilled() {
        when(cache.containsKey(keyMeaning)).thenReturn(true);
        when(cache.get(keyMeaning)).thenReturn(testMap);

        assertEquals(testMap, cacheCharCounterDecorator.count(keyMeaning));
        verify(charCounter, never()).count(keyMeaning);
        verify(cache, times(1)).get(keyMeaning);
    }
}
