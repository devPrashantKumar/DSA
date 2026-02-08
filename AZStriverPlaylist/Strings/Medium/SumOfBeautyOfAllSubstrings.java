package AZStriverPlaylist.Strings.Medium;

public class SumOfBeautyOfAllSubstrings {

    /*
     * Time Complexity : O(n^3)
     */
    public static int beautySum(String s) {
        int n = s.length();
        int beauty = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int characterMap[] = new int[26];
                int minFrequency = Integer.MAX_VALUE;
                int maxFrequency = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    characterMap[s.charAt(k) - 'a']++;
                }
                for (int k = i; k <= j; k++) {
                    if (characterMap[s.charAt(k) - 'a'] < minFrequency) {
                        minFrequency = characterMap[s.charAt(k) - 'a'];
                    }
                    if (characterMap[s.charAt(k) - 'a'] > maxFrequency) {
                        maxFrequency = characterMap[s.charAt(k) - 'a'];
                    }
                }
                beauty += (maxFrequency - minFrequency);
            }
        }
        return beauty;
    }

    /*
     * Time Complexity : O(n^3)
     */
    public static int beautySumBetter(String s) {
        int n = s.length();
        int beauty = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int characterMap[] = new int[26];
                int minFrequency = Integer.MAX_VALUE;
                int maxFrequency = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    characterMap[s.charAt(k) - 'a']++;
                }
                for (int k = 0; k < 26; k++) {
                    if (characterMap[k] != 0 && characterMap[k] < minFrequency) {
                        minFrequency = characterMap[k];
                    }
                    if (characterMap[k] != 0 && characterMap[k] > maxFrequency) {
                        maxFrequency = characterMap[k];
                    }
                }
                beauty += (maxFrequency - minFrequency);
            }
        }
        return beauty;
    }

    /*
     * Time Complexity : O(n^2)
     */
    public static int beautySumOptimised(String s) {
        int n = s.length();
        int beauty = 0;
        for (int i = 0; i < n; i++) {
            int characterMap[] = new int[26];
            for (int j = i; j < n; j++) {
                int minFrequency = Integer.MAX_VALUE;
                int maxFrequency = Integer.MIN_VALUE;
                characterMap[s.charAt(j) - 'a']++;
                for (int k = 0; k < 26; k++) {
                    if (characterMap[k] != 0 && characterMap[k] < minFrequency) {
                        minFrequency = characterMap[k];
                    }
                    if (characterMap[k] != 0 && characterMap[k] > maxFrequency) {
                        maxFrequency = characterMap[k];
                    }
                }
                beauty += (maxFrequency - minFrequency);

            }

        }
        return beauty;
    }

    public static void main(String[] args) {
        String s1 = "aabcb";
        System.out.println("input : " + s1 + " output : " + beautySum(s1));
        System.out.println("input : " + s1 + " output : " + beautySumBetter(s1));
        System.out.println("input : " + s1 + " output : " + beautySumOptimised(s1));
        System.out.println("-----------------------------------------------------");

        String s2 = "aabcbaa";
        System.out.println("input : " + s2 + " output : " + beautySum(s2));
        System.out.println("input : " + s2 + " output : " + beautySumBetter(s2));
        System.out.println("input : " + s2 + " output : " + beautySumOptimised(s2));
        System.out.println("-----------------------------------------------------");
    }
}
