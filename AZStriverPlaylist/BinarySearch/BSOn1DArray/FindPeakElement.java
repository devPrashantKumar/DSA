package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class FindPeakElement {

    /*
    * Time Complexity : O(n)
    */
    public static int findPeakElementBruteForce(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int prev = (i-1<0) ? Integer.MIN_VALUE : nums[i-1];
            int next = (i+1>=n) ? Integer.MIN_VALUE : nums[i+1];
            if(prev < nums[i] && nums[i] > next) return i;
        }
        return -1;
    }


    /*
    * Time Complexity : O(n) using recursion // refer masters theorem for complexity analysis
    */
    public static int findPeakElement(int[] nums) {
        int n =  nums.length;
        int left = 0;
        int right = n-1;
        Integer output = makeDecision(nums, left, right);
        return output==null ? -1 : output;
    }

    public static Integer makeDecision(int[] nums, int left, int right) {
        int n =  nums.length;
        if(left<0 || left>=n || right<0 || right>=n || right<left) return null;
        int mid = left+(right-left)/2;
        int prev = (mid-1<0) ? Integer.MIN_VALUE : nums[mid-1];
        int next = (mid+1>=n) ? Integer.MIN_VALUE : nums[mid+1];

        Integer leftHalf=null;
        Integer rightHalf=null;
        if(nums[mid]>prev){
            if(nums[mid]>next) return mid;
            leftHalf = makeDecision(nums, left, mid-2);
            if(leftHalf!=null) return leftHalf;
            if(nums[mid]==next){    
                rightHalf = makeDecision(nums, mid+2, right);
            }
            else{
                rightHalf = makeDecision(nums, mid+1, right);
            }
        }else if(nums[mid]==prev){
            leftHalf = makeDecision(nums, left, mid-2);
            if(leftHalf!=null) return leftHalf;
            if(nums[mid]==next || nums[mid]>next) rightHalf = makeDecision(nums, mid+2, right);
            else rightHalf = makeDecision(nums, mid+1, right);
        }else{
            leftHalf = makeDecision(nums, left, mid-1);
            if(leftHalf!=null) return leftHalf;
            if(nums[mid]==next || nums[mid]>next) rightHalf = makeDecision(nums, mid+2, right);
            else rightHalf = makeDecision(nums, mid+1, right);
        }

        if(rightHalf!=null) return rightHalf;
        return null;
    }

    /*
    * Time Complexity : O(log n)
    */
    public static int findPeakElementUsingBinarySearch(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int left = 1;
        int right = n-2;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) return mid;
            // trying to find mid se kaun chota hai
            else if(nums[mid-1]<nums[mid]) left = mid+1;
            else if(nums[mid]>nums[mid+1]) right = mid-1;
            else right = mid-1;
        }
        return -1;
    }

    public static int findPeakElementUsingBinarySearch2(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int left = 1;
        int right = n-2;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) return mid;
            // trying to find mid se kaun bda hai
            else if(nums[mid-1]>nums[mid]) right = mid-1;
            else if(nums[mid]<nums[mid+1]) left = mid+1;
            // it is given in problem no consecutive elements are equal
        }
        return -1;
    }
        

    public static void main(String[] args) {
        System.out.println(findPeakElementBruteForce(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElementUsingBinarySearch(new int[]{1,2,3,1}));
        System.out.println(findPeakElementUsingBinarySearch2(new int[]{1,2,3,1}));

        System.out.println("-----------------------------------------------");
        System.out.println(findPeakElementBruteForce(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElementUsingBinarySearch(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElementUsingBinarySearch2(new int[]{1,2,1,3,5,6,4}));

    }
}
