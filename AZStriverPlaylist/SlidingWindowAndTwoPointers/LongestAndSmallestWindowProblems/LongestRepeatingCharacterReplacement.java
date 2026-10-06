package AZStriverPlaylist.SlidingWindowAndTwoPointers.LongestAndSmallestWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxCountElementOccurence = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, i = 0;
        for (; i < s.length(); i++) {
            int occurence = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), occurence);
            if (occurence > maxCountElementOccurence) {
                maxCountElementOccurence = occurence;
            }
            int otherElementOccurence = i - j + 1 - maxCountElementOccurence;
            if (otherElementOccurence > k) {
                maxLen = Math.max(maxLen, i - j);
                // if (maxLen == i - j) {
                //     System.out.println(s.substring(j, i));
                // }
                while (otherElementOccurence > k) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    j++;
                    maxCountElementOccurence = 0;
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        if (entry.getValue() > maxCountElementOccurence)
                            maxCountElementOccurence = entry.getValue();
                    }
                    otherElementOccurence = i - j + 1 - maxCountElementOccurence;
                }
            }
        }
        maxLen = Math.max(maxLen, i - j);
        // if (maxLen == i - j) {
        //     System.out.println("here2"+s.substring(j, i));
        // }
        return maxLen;
    }


    public static int characterReplacement2(String s, int k) {
        int maxLen = 0;
        int maxCountElementOccurence = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, i = 0;
        for (; i < s.length(); i++) {
            int occurence = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), occurence);
            if (occurence > maxCountElementOccurence) {
                maxCountElementOccurence = occurence;
            }
            int otherElementOccurence = i - j + 1 - maxCountElementOccurence;
            while (otherElementOccurence > k) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                j++;
                maxCountElementOccurence = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > maxCountElementOccurence)
                        maxCountElementOccurence = entry.getValue();
                }
                otherElementOccurence = i - j + 1 - maxCountElementOccurence;
            }
            maxLen = Math.max(maxLen, i - j+1);
        }
        return maxLen;
    }
    
    // non-shrinking / lazy sliding window approach.
    public static int characterReplacement3(String s, int k) {
        int maxLen = 0;
        int maxCountElementOccurence = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, i = 0;
        for (; i < s.length(); i++) {
            int occurence = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), occurence);
            if (occurence > maxCountElementOccurence) {
                maxCountElementOccurence = occurence;
            }
            int otherElementOccurence = i - j + 1 - maxCountElementOccurence;
            if (otherElementOccurence > k) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                j++;
                maxCountElementOccurence = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > maxCountElementOccurence)
                        maxCountElementOccurence = entry.getValue();
                }
                otherElementOccurence = i - j + 1 - maxCountElementOccurence;
            }
            if(otherElementOccurence<=k)
                maxLen = Math.max(maxLen, i - j+1);
        }
        return maxLen;
    }

    // non-shrinking / lazy sliding window approach.
    public static int characterReplacement4(String s, int k) {
        int maxLen = 0;
        int maxCountElementOccurence = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, i = 0;
        for (; i < s.length(); i++) {
            int occurence = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), occurence);
            if (occurence > maxCountElementOccurence) {
                maxCountElementOccurence = occurence;
            }
            int otherElementOccurence = i - j + 1 - maxCountElementOccurence;
            //length-maxFrequency = k
            //k is constant , so if we want to increase length , we need to increase max frequency
            if (otherElementOccurence > k) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                j++;
            }
            if(otherElementOccurence<=k)
                maxLen = Math.max(maxLen, i - j+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String stringInput2 = "AABABBA";
        int k2 = 1;
        String stringInput3 = "ABAB";
        int k3 = 2;

        System.out.println("Input String : " + stringInput2 + " Output : "+ characterReplacement(stringInput2, k2));
        System.out.println("Input String : " + stringInput2 + " Output : "+ characterReplacement2(stringInput2, k2));
        System.out.println("Input String : " + stringInput2 + " Output : "+ characterReplacement3(stringInput2, k2));
        System.out.println("Input String : " + stringInput2 + " Output : "+ characterReplacement4(stringInput2, k2));

        System.out.println("---------------------------------------------------------");
        System.out.println("Input String : " + stringInput3 + " Output : "+ characterReplacement(stringInput3, k3));
        System.out.println("Input String : " + stringInput3 + " Output : "+ characterReplacement2(stringInput3, k3));
        System.out.println("Input String : " + stringInput3 + " Output : "+ characterReplacement3(stringInput3, k3));
        System.out.println("Input String : " + stringInput3 + " Output : "+ characterReplacement4(stringInput3, k3));

    }
}
