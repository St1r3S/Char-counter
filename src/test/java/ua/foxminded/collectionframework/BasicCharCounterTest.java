package ua.foxminded.collectionframework;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BasicCharCounterTest {

    BasicCharCounter basicCharCounter = new BasicCharCounter();
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
    void shouldVerifyCountHelloWorld() {
        assertEquals(testMap, basicCharCounter.count("Hello world!"));
    }

    @Test
    void shouldVerifyEmptyWord() {
        assertEquals(new LinkedHashMap<>(), basicCharCounter.count(""));
    }

    @Test
    void shouldVerifyThrowExceptionOnNull() {
        assertThrows(IllegalArgumentException.class, () -> basicCharCounter.count(null));
    }
}