package AZStriverPlaylist.Array.Hard;

import java.util.*;

public class ThreeSum {

    /*
     * Time Complexity : O(n^3)
     * Space Complexity : O(1)
     */
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplets = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplets.sort((a, b) -> a - b);
                        result.add(triplets);
                    }
                }
            }

        }
        return result.stream().toList();
    }

    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(n)
     */
    public static List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> hset = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (hset.contains(-(nums[i] + nums[j]))) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j]));
                    triplets.sort((a, b) -> a - b);
                    result.add(triplets);
                }
                hset.add(nums[j]);
            }
        }
        return result.stream().toList();
    }

    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(n)
     */
    public static List<List<Integer>> threeSumBetter_2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        HashSet<Integer> hset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (hset.contains(-(nums[i] + nums[j]))) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j]));
                    triplets.sort((a, b) -> a - b);
                    result.add(triplets);
                }

            }
            hset.add(nums[i]);
        }
        return result.stream().toList();
    }

    /*
     * Time Complexity : O(n log n)+ O(n^2)
     * Space Complexity : O(1)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int lastUsed = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != lastUsed) {
                int firstElement = nums[i];
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == (-firstElement)) {
                        result.add(List.of(firstElement, nums[start], nums[end]));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1])
                            start++;
                        while (end > start && nums[end] == nums[end + 1])
                            end--;
                    } else if (nums[start] + nums[end] < (-firstElement)) {
                        start++;
                    } else {
                        end--;
                    }
                }
                lastUsed = nums[i];
            }
        }
        return result;
    }

    /*
     * Time Complexity : O(n log n)+ O(n^2)
     * Space Complexity : O(1)
     */
    public static List<List<Integer>> threeSum_2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int firstElement = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == (-firstElement)) {
                    result.add(List.of(firstElement, nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (end > start && nums[end] == nums[end + 1]) end--;
                } else if (nums[start] + nums[end] < (-firstElement)) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        int[] nums2 = { 0, 1, 1 };
        int[] nums3 = { 0, 0, 0 };
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output : " + ThreeSum.threeSumBruteForce(nums1));
        System.out.println("Output : " + ThreeSum.threeSumBetter(nums1));
        System.out.println("Output : " + ThreeSum.threeSumBetter_2(nums1));
        System.out.println("Output : " + ThreeSum.threeSum(nums1));
        System.out.println("Output : " + ThreeSum.threeSum_2(nums1));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output : " + ThreeSum.threeSumBruteForce(nums2));
        System.out.println("Output : " + ThreeSum.threeSumBetter(nums2));
        System.out.println("Output : " + ThreeSum.threeSumBetter_2(nums2));
        System.out.println("Output : " + ThreeSum.threeSum(nums2));
        System.out.println("Output : " + ThreeSum.threeSum_2(nums2));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("Output : " + ThreeSum.threeSumBruteForce(nums3));
        System.out.println("Output : " + ThreeSum.threeSumBetter(nums3));
        System.out.println("Output : " + ThreeSum.threeSumBetter_2(nums3));
        System.out.println("Output : " + ThreeSum.threeSum(nums3));
        System.out.println("Output : " + ThreeSum.threeSum_2(nums3));

        System.out.println("---------------------------------------------------");
    }
}
