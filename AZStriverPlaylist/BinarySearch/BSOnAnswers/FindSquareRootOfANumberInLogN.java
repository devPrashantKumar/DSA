package AZStriverPlaylist.BinarySearch.BSOnAnswers;

public class FindSquareRootOfANumberInLogN {
    
    public static int floorSqrt(int n) {
        int left = 1;
        int right = n;
        int ans=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(mid == n/mid) return mid;
            if(mid >n/mid) right = mid-1;
            else {
                ans = mid;
                left = mid+1;
            }
        }
        return ans;   
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(36));
        System.out.println(floorSqrt(38));
        System.out.println(floorSqrt(48));
        System.out.println(floorSqrt(49));
        System.out.println(floorSqrt(1));
        System.out.println(floorSqrt(11));
    }
}
