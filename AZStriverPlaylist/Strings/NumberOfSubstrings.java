package AZStriverPlaylist.Strings;

import java.util.*;

public class NumberOfSubstrings {
    /*
     * TIme Complexity : O(n^2) , can be (n*nlogn) in worst case due to insertions
     * in set.
     * Space Complexity : O(n)
     */
    public static int substringCount(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i <= n - k; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < (i + k - 1); j++) {
                set.add(s.charAt(j));
            }
            for (int j = (i + k - 1); j < n; j++) {
                set.add(s.charAt(j));
                if (set.size() == k) {
                    count++;
                }
            }

        }

        return count;
    }

    /*
     * TIme Complexity : O(n^2) - more optimized in worst case also
     * Space Complexity : O(n)
     */
    public static int substringCountSimple(String s, int k) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            boolean[] map = new boolean[26];
            int distinctCnt = 0;

            for (int j = i; j < n; j++) {
                if (!map[s.charAt(j) - 'a']) {
                    map[s.charAt(j) - 'a'] = true;
                    distinctCnt++;
                }
                if (distinctCnt == k)
                    ans++;
            }
        }

        return ans;
    }

    // wrong solution - this problem is pending
    public static int substringCountOptimal(String s, int k) {
        int n = s.length();
        int[] charOccurenceCounter = new int[26];
        int count = 0;
        int distinct = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            int c = s.charAt(j);
            if (charOccurenceCounter[c - 'a'] == 0) {
                distinct++;
            }
            charOccurenceCounter[c - 'a']++;
            if (distinct == k)
                count++;
            if (distinct > k) {
                while (i <= j) {
                    char c2 = s.charAt(i);
                    charOccurenceCounter[c2 - 'a']--;
                    if (charOccurenceCounter[c2 - 'a'] == 0) {
                        distinct--;
                        count++;
                        break;
                    }
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        String input1 = "abc";
        int k1 = 2;
        System.out.println("Input : " + input1 + " Output : " + NumberOfSubstrings.substringCount(input1, k1));
        System.out.println("Input : " + input1 + " Output : " + NumberOfSubstrings.substringCountOptimal(input1, k1));

        String input2 = "aba";
        int k2 = 2;
        System.out.println("Input : " + input2 + " Output : " + NumberOfSubstrings.substringCount(input2, k2));
        System.out.println("Input : " + input2 + " Output : " + NumberOfSubstrings.substringCountOptimal(input2, k2));

        String input3 = "aa";
        int k3 = 1;
        System.out.println("Input : " + input3 + " Output : " + NumberOfSubstrings.substringCount(input3, k3));
        System.out.println("Input : " + input3 + " Output : " + NumberOfSubstrings.substringCountOptimal(input3, k3));

    }
}
