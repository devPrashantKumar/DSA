package AZStriverPlaylist.Strings.Easy;

import java.util.HashMap;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> hmap1 = new HashMap<>();
        HashMap<Character, Character> hmap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hmap1.containsKey(s.charAt(i))) {
                hmap1.put(s.charAt(i), t.charAt(i));
            } else {
                if (hmap1.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }

            if (!hmap2.containsKey(t.charAt(i))) {
                hmap2.put(t.charAt(i), s.charAt(i));
            } else {
                if (hmap2.get(t.charAt(i)) != s.charAt(i))
                    return false;
            }
        }
        return true;

    }

    public static boolean isIsomorphicSimple(String s, String t) {
        int[] indexS = new int[300];
        int[] indexT = new int[300];
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if ((indexS[s.charAt(i)] == 0 && indexT[t.charAt(i)] != 0)
                    || (indexS[s.charAt(i)] != 0 && indexT[t.charAt(i)] == 0)) {
                return false;
            }

            if ((indexS[s.charAt(i)] != 0 && indexT[t.charAt(i)] != 0)
                    && (indexS[s.charAt(i)] != t.charAt(i) || s.charAt(i) != indexT[t.charAt(i)])) {
                return false;
            }

            indexS[s.charAt(i)] = t.charAt(i);
            indexT[t.charAt(i)] = s.charAt(i);
        }
        return true;
    }

    public static boolean isIsomorphicOptimal(String s, String t) {
        int[] indexS = new int[300];
        int[] indexT = new int[300];

        int len = s.length();
        if (len != t.length()) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false;
            }
            indexS[s.charAt(i)] = i + 1;
            indexT[t.charAt(i)] = i + 1;
            // indexS[s.charAt(i)] = s.charAt(i);
            // indexT[t.charAt(i)] = s.charAt(i);
        }

        return true;
    }

    public static void main(String[] args) {
        String sInput1 = "egg";
        String tInput1 = "add";
        System.out.println(
                "Input : " + sInput1 + "," + tInput1 + " Output : " + IsomorphicStrings.isIsomorphic(sInput1, tInput1));
        System.out.println(
                "Input : " + sInput1 + "," + tInput1 + " Output : "
                        + IsomorphicStrings.isIsomorphicSimple(sInput1, tInput1));
        System.out.println(
                "Input : " + sInput1 + "," + tInput1 + " Output : "
                        + IsomorphicStrings.isIsomorphicOptimal(sInput1, tInput1));

        String sInput2 = "foo";
        String tInput2 = "bar";
        System.out.println(
                "Input : " + sInput2 + "," + tInput2 + " Output : " + IsomorphicStrings.isIsomorphic(sInput2, tInput2));
        System.out.println(
                "Input : " + sInput2 + "," + tInput2 + " Output : "
                        + IsomorphicStrings.isIsomorphicSimple(sInput2, tInput2));
        System.out.println(
                "Input : " + sInput2 + "," + tInput2 + " Output : "
                        + IsomorphicStrings.isIsomorphicOptimal(sInput2, tInput2));

        String sInput3 = "paper";
        String tInput3 = "title";
        System.out.println(
                "Input : " + sInput3 + "," + tInput3 + " Output : " + IsomorphicStrings.isIsomorphic(sInput3, tInput3));
        System.out.println(
                "Input : " + sInput3 + "," + tInput3 + " Output : " + IsomorphicStrings.isIsomorphicSimple(sInput3, tInput3));
        System.out.println(
                "Input : " + sInput3 + "," + tInput3 + " Output : "
                        + IsomorphicStrings.isIsomorphicOptimal(sInput3, tInput3));
    }
}
