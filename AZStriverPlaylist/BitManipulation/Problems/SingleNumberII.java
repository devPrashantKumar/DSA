package AZStriverPlaylist.BitManipulation.Problems;

public class SingleNumberII {
    /*
    * Time Complexity: O(32 * n) = O(n)
    * Space Complexity: O(1)
    */
    public static int singleNumber2(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int countOnes=0;
            for (int j = 0; j < nums.length; j++) {
                if((nums[j] & (1<<i))!=0) countOnes++;
            }
            if(countOnes%3==1) ans |= (1<<i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Single Frquency Number : " + singleNumber2(new int[] {2,2,2,1}));
        System.out.println("Single Frquency Number : " + singleNumber2(new int[] {4,1,1,2,2,1,2}));
        System.out.println("Single Frquency Number : " + singleNumber2(new int[] {1}));
        System.out.println("-------------------------------------------------");
    }
}
