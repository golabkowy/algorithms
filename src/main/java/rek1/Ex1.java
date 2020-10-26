package rek1;

import java.util.*;
import java.util.stream.Collectors;


public class Ex1 {

    public static char maximumOccurringCharacter(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = text.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (map.get(charArr[i]) == null) {
                map.put(charArr[i], 1);
            } else {
                map.replace(charArr[i], map.get(charArr[i]) + 1);
            }
        }

        Optional<Map.Entry<Character, Integer>> maxEntry = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue)
                );

        Integer max_val = maxEntry.get().getValue();

        Map<Integer, List<Character>> temp = map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        return 'a';
    }

    public static void main(String[] args) {
        maximumOccurringCharacter("aaaaaaaafffggghhhjjjkkktttthhhhhgggeeeeee");
    }
}
