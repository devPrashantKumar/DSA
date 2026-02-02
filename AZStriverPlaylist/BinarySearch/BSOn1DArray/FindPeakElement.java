package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int n =  nums.length;
        int left = 0;
        int right = n-1;
        int[] output = makeDecision(nums, left, right);
        return output[1];
    }

    public static int[] makeDecision(int[] nums, int left, int right) {
        int n =  nums.length;
        if(left<0 || left>=n || right<0 || right>=n || right<left) return  new int[]{0,0};
        int mid = left+(right-left)/2;
        int prev = (mid-1<0) ? Integer.MIN_VALUE : nums[mid-1];
        int next = (mid+1>=n) ? Integer.MIN_VALUE : nums[mid+1];

        int[] leftHalf=null,rightHalf=null;
        if(nums[mid]>prev){
            if(nums[mid]>next) return new int[]{1,mid};
            leftHalf = makeDecision(nums, left, mid-2);
            if(nums[mid]==next){    
                rightHalf = makeDecision(nums, mid+2, right);
            }
            else{
                rightHalf = makeDecision(nums, mid+1, right);
            }
        }else if(nums[mid]==prev){
            leftHalf = makeDecision(nums, left, mid-2);
            if(nums[mid]==next || nums[mid]>next) rightHalf = makeDecision(nums, mid+2, right);
            else rightHalf = makeDecision(nums, mid+1, right);
        }else{
            leftHalf = makeDecision(nums, left, mid-1);
            if(nums[mid]==next || nums[mid]>next) rightHalf = makeDecision(nums, mid+2, right);
            else rightHalf = makeDecision(nums, mid+1, right);
        }

        if(leftHalf[0]==1) return leftHalf;
        if(rightHalf[0]==1) return rightHalf;
        return new int[]{0,0};
    }
        

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
