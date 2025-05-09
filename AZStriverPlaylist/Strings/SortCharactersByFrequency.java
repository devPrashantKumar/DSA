package AZStriverPlaylist.Strings;

import java.util.*;

public class SortCharactersByFrequency {
    /*
     * Time complexity : O(nlogn)
     */
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

    /*
     * Time conplexity : O(n)
     * utilising buckets for sorting purpose
     */
    public static String frequencySortHashTable(String s) 
    {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[128];
        for(char c : s.toCharArray())
        {
            freq[c-'0']++;
        }

        for(int k = 0; k < s.length();)
        {
            int max = 0;
            int ind = 0;
            for(int j = 0; j < freq.length; j++)
            {
                if(freq[j] != 0 && freq[j] > max)
                {
                    max = freq[j];
                    ind = j;
                }
            }
            for(int i = 0; i < max; i++)
            {
                sb.append((char)('0'+ind));
            }
            freq[ind] = 0;
            k += max;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = "tree";
        System.out.println("Input : "+input1+" Output : "+SortCharactersByFrequency.frequencySort(input1));
        System.out.println("Input : "+input1+" Output : "+SortCharactersByFrequency.frequencySortHashTable(input1));

        String input2 = "cccbbaaaa";
        System.out.println("Input : "+input2+" Output : "+SortCharactersByFrequency.frequencySort(input2));
        System.out.println("Input : "+input2+" Output : "+SortCharactersByFrequency.frequencySortHashTable(input2));

        String input3 = "ccaabbb";
        System.out.println("Input : "+input3+" Output : "+SortCharactersByFrequency.frequencySort(input3));
        System.out.println("Input : "+input3+" Output : "+SortCharactersByFrequency.frequencySortHashTable(input3));

    }
}
