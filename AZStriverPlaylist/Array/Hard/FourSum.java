package AZStriverPlaylist.Array.Hard;

import java.util.*;

public class FourSum {

    /*
    * Time Complexity : O(n^4)
    * Space Complexity : O(1)
    */
    public static List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    for(int l=k+1;l<nums.length;l++){
                        if(0L+nums[i]+nums[j]+nums[k]+nums[l]==target){
                            List<Integer> quadruplets = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                            quadruplets.sort((a,b)->a-b);
                            result.add(quadruplets);
                        }
                    }
                }
            }
            
        }
        return result.stream().toList();
    }

    /*
    * Time Complexity : O(n^3)
    * Space Complexity : O(n)
    */
    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                HashSet<Long> hset = new HashSet<>();
                for(int k=j+1;k<nums.length;k++){
                    long sum3 = (long) nums[i] + nums[j] + nums[k];
                    long needed = (long) target - sum3;
                    if(hset.contains(needed)){
                        List<Integer> quadruplets = Arrays.asList(nums[i],nums[j],nums[k],(int)(needed));
                        quadruplets.sort(Integer::compareTo);
                        result.add(quadruplets);
                    }
                    hset.add(0L+nums[k]);
                }
            }
        }
        return result.stream().toList();
    }

    /*
    * Time Complexity : O(n log n)+ O(n^3)
    * Space complexity : O(1)
    */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int start = j+1;
                int end = nums.length-1;
                while(start<end){
                    if(0L+nums[start]+nums[end]==target-(nums[i]+nums[j]+0L)){
                        result.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        start++;
                        end--;
                        while(start<end && nums[start]==nums[start-1]) start++;
                        while(start<end && nums[end]==nums[end+1]) end--;
                    }
                    else if(0L+nums[start]+nums[end]<target-(nums[i]+nums[j]+0L)){
                        start++;
                    }else{
                        end--;
                    }
                }

            }
        }
        return result;
        
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,0,-1,0,-2,2 };
        int target1 = 0;
        int[] nums2 = { 2,2,2,2,2 };
        int target2 = 8;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output : " +FourSum.fourSumBruteForce(nums1,target1));
        System.out.println("Output : " +FourSum.fourSumBetter(nums1,target1));
        System.out.println("Output : " +FourSum.fourSum(nums1,target1));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output : " + FourSum.fourSumBruteForce(nums2,target2));
        System.out.println("Output : " + FourSum.fourSumBetter(nums2,target2));
        System.out.println("Output : " + FourSum.fourSum(nums2,target2));

    }
}
