package AZStriverPlaylist.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        StringBuilder str = new StringBuilder();
        HashMap<Character, Integer> hmap = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        // char c = s.charAt(i);
        // hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        // }
        s.chars().forEach(c -> {
            char ch = (char) c; // Cast int to char
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        });

        // List<Map.Entry<Character, Integer>> lhset = hmap.entrySet().stream()
        // .sorted(Comparator.comparing(Map.Entry<Character,
        // Integer>::getValue).reversed())
        // .collect(Collectors.toCollection(ArrayList::new));
        // for (Map.Entry<Character, Integer> element : lhset) {
        // Character key = element.getKey();
        // for (int k = 0; k < element.getValue(); k++) {
        // str.append(key);
        // }
        // }

        hmap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed())
                .forEach(entry -> {
                    char key = entry.getKey();
                    int count = entry.getValue();
                    str.append(String.valueOf(key).repeat(count));
                });
        return str.toString();
    }

    public static void main(String[] args) {
        String input1 = "tree";
        System.out.println("Input : "+input1+" Output : "+SortCharactersByFrequency.frequencySort(input1) );
        String input2 = "cccbbaaaa";
        System.out.println("Input : "+input2+" Output : "+SortCharactersByFrequency.frequencySort(input2) );
        String input3 = "ccaabbb";
        System.out.println("Input : "+input3+" Output : "+SortCharactersByFrequency.frequencySort(input3) );
    }
}
