package AZStriverPlaylist.Array.Medium;

import java.util.*;

class TwoSum {
    static class ListElement{
        int value;
        int index;

        public ListElement(int value,int index){
            this.value = value;
            this.index = index;
        }
        @Override
        public String toString() {
            return "{"+this.index+","+this.value+"}";
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        List<ListElement>  elementList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            elementList.add(new ListElement(nums[i],i));
        }
        elementList.sort((e1,e2)->{
            if(e1.value!=e2.value) return e1.value-e2.value;
            else return e1.index-e2.index;
        });

        //System.out.println(elementList.toString());
        int startIndex=0;
        int endIndex=elementList.size()-1;
        while(startIndex<endIndex){
            int sum  = elementList.get(startIndex).value+elementList.get(endIndex).value;
            if(sum==target) {
                if(elementList.get(startIndex).index<elementList.get(endIndex).index)
                return new int[]{elementList.get(startIndex).index,elementList.get(endIndex).index};
                else return new int[]{elementList.get(endIndex).index,elementList.get(startIndex).index};
            }
            else if(sum<target) startIndex++;
            else endIndex--;
        }
        return new int[]{};
    }

    public static int[] twoSumOptimal(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            } 
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums1 = { 3,4,5,6 };
        int target1 = 7;
        int[] nums2 = { 4,5,6 };
        int target2 = 10;
        int[] nums3 = { -1,-2,-3,-4,-5 };
        int target3 = -8;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums1) +" , "+ target1);
        System.out.println("Output : " +Arrays.toString(TwoSum.twoSum(nums1,target1)));
        System.out.println("Output : " +Arrays.toString(TwoSum.twoSumOptimal(nums1,target1)));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums2) +" , "+ target2);
        System.out.println("Output : " + Arrays.toString(TwoSum.twoSum(nums2,target2)));
        System.out.println("Output : " + Arrays.toString(TwoSum.twoSumOptimal(nums2,target2)));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums3) +" , "+ target3);
        System.out.println("Output : " + Arrays.toString(TwoSum.twoSum(nums3,target3)));
        System.out.println("Output : " + Arrays.toString(TwoSum.twoSumOptimal(nums3,target3)));

        System.out.println("---------------------------------------------------");
    }
}