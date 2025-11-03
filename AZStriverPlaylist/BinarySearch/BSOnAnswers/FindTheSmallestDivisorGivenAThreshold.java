package AZStriverPlaylist.BinarySearch.BSOnAnswers;

public class FindTheSmallestDivisorGivenAThreshold {

    public static int smallestDivisor(int[] nums, int threshold) {
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums){
            maxNum = Math.max(maxNum,num);
        }
        int left=1;
        int right=maxNum+1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(checkDivision(nums,threshold,mid)) right=mid-1;
            else left = mid+1;
        }
        return left;
    }

    public static boolean checkDivision(int[] nums, int threshold, int divisor){
        int count=0;
        for(int num: nums){
            count += ((num+divisor-1)/divisor);
            if (count>threshold) return false;
        }
        return (count<=threshold);
    }

    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[] {1,2,5,9 }, 6));
        System.out.println(smallestDivisor(new int[] { 44,22,33,11,1 }, 5));
    }
}
