package AZStriverPlaylist.Array.Hard;

import java.util.*;

public class MajorityElementII {
    /*
     * Time Complexity : O(2*n)
     * Space Complexity : O(n)
     */
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int oneThird = nums.length / 3;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if (entry.getValue() > oneThird) result.add(entry.getKey());
        }
        return result;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int oneThird = nums.length / 3;
        int highestFrequncy = Integer.MIN_VALUE;
        int secondHighestFrequncy = Integer.MIN_VALUE;
        int highestFrequncyElement = Integer.MIN_VALUE;
        int secondHighestFrequncyElement = Integer.MIN_VALUE;

        Map<Integer, Integer> hmap = new HashMap<>();
        for (int num : nums) {
            if (hmap.getOrDefault(num, 0) + 1 >= highestFrequncy) {
                if (num != highestFrequncyElement) {
                    secondHighestFrequncy = highestFrequncy;
                    secondHighestFrequncyElement = highestFrequncyElement;
                }
                highestFrequncy = hmap.getOrDefault(num, 0) + 1;
                highestFrequncyElement = num;

            } else if (hmap.getOrDefault(num, 0) + 1 > secondHighestFrequncy) {
                secondHighestFrequncy = hmap.getOrDefault(num, 0) + 1;
                secondHighestFrequncyElement = num;
            }
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        if (highestFrequncy > oneThird) result.add(highestFrequncyElement);
        if (secondHighestFrequncy > oneThird) result.add(secondHighestFrequncyElement);
        return result;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static List<Integer> majorityElement3(int[] nums) {
        Set<Integer> result = new HashSet<>();
        int oneThird = nums.length / 3;

        Map<Integer, Integer> hmap = new HashMap<>();
        for (int num : nums) {
            if (hmap.getOrDefault(num, 0) + 1 > oneThird) {
                result.add(num);
            }
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        return result.stream().toList();
    }

    /*
     * Time Complexity : O(nlogn)
     */
    // Woring Solution
    // public static List<Integer> majorityElement4(int[] nums) {
    // List<Integer> result = new ArrayList<>();
    // int oneThird = nums.length/3;
    // Arrays.sort(nums);
    // if(oneThird<nums.length) result.add(nums[oneThird]);
    // if(2*oneThird+1<nums.length) result.add(nums[2*oneThird+1]);
    // return result;
    // }

    /*
     * Time Complexity : O(n log n)
     * Space Complexity : O(log n) -> recursion stack used by Arrays.sort()
     */
    public static List<Integer> majorityElement4(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int oneThird = n / 3;
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count > oneThird) {
                    result.add(nums[i - 1]);
                }
                count = 1;
            }
        }

        // Check the last element's frequency
        if (count > oneThird) {
            result.add(nums[n - 1]);
        }
        return result;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static List<Integer> majorityElementOptimal(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int oneThird = nums.length / 3;
        int cnt1 = 0, ele1 = Integer.MIN_VALUE, cnt2 = 0, ele2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (cnt1 == 0 && num != ele2) {
                cnt1 = 1;
                ele1 = num;
            } else if (cnt2 == 0 && num != ele1) {
                cnt2 = 1;
                ele2 = num;
            } else if (num == ele1)
                cnt1++;
            else if (num == ele2)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == ele1) cnt1++;
            else if (num == ele2) cnt2++;
        }
        if (cnt1 > oneThird) result.add(ele1);
        if (cnt2 > oneThird)result.add(ele2);

        return result;
    }

    public static void main(String[] args) {
        int[] input1 = { 3, 2, 3 };
        System.out.println("Input : " + input1 + " Output : " + MajorityElementII.majorityElement(input1));
        System.out.println("Input : " + input1 + " Output : " + MajorityElementII.majorityElement2(input1));
        System.out.println("Input : " + input1 + " Output : " + MajorityElementII.majorityElement3(input1));
        System.out.println("Input : " + input1 + " Output : " + MajorityElementII.majorityElement4(input1));
        System.out.println("Input : " + input1 + " Output : " + MajorityElementII.majorityElementOptimal(input1));

        System.out.println("------------------------------------------------------");
        int[] input2 = { 1 };
        System.out.println("Input : " + input2 + " Output : " + MajorityElementII.majorityElement(input2));
        System.out.println("Input : " + input2 + " Output : " + MajorityElementII.majorityElement2(input2));
        System.out.println("Input : " + input2 + " Output : " + MajorityElementII.majorityElement3(input2));
        System.out.println("Input : " + input2 + " Output : " + MajorityElementII.majorityElement4(input2));
        System.out.println("Input : " + input2 + " Output : " + MajorityElementII.majorityElementOptimal(input2));

        System.out.println("------------------------------------------------------");
        int[] input3 = { 1, 2 };
        System.out.println("Input : " + input3 + " Output : " + MajorityElementII.majorityElement(input3));
        System.out.println("Input : " + input3 + " Output : " + MajorityElementII.majorityElement(input3));
        System.out.println("Input : " + input3 + " Output : " + MajorityElementII.majorityElement3(input3));
        System.out.println("Input : " + input3 + " Output : " + MajorityElementII.majorityElement4(input3));
        System.out.println("Input : " + input3 + " Output : " + MajorityElementII.majorityElementOptimal(input3));

    }
}
