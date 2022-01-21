package ua.foxminded.collectionframework;

import java.util.HashMap;
import java.util.Map;

public class CharCounterApp {
    public static void main(String[] args) {
        String text = "Hello world!";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            stringBuilder.append(text + " ");
        }
        long l = System.currentTimeMillis();
        CharCounter charCounter = new CacheCharCounterDecorator(new BasicCharCounter(), new HashMap<>());
        Formatter formatter = new Formatter();
        Map<Character, Long> result = charCounter.count(stringBuilder.toString());
        String formatted = formatter.apply(result);
        System.out.append("Input string length - ").println(stringBuilder.length());
        System.out.println(formatted);
        System.out.println(System.currentTimeMillis() - l + "ms");

        l = System.currentTimeMillis();
        result = charCounter.count(stringBuilder.toString());
        formatted = formatter.apply(result);
        System.out.append("Input string length - ").println(stringBuilder.length());
        System.out.println(formatted);
        System.out.println(System.currentTimeMillis() - l + "ms");
    }
}
