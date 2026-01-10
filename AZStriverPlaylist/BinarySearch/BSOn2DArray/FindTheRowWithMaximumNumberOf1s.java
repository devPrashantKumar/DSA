package AZStriverPlaylist.BinarySearch.BSOn2DArray;

public class FindTheRowWithMaximumNumberOf1s {

    /*
    * Time Complexity : O(n^2)
    */
    public static int rowWithMax1sBruteForce(int[][] mat) {
        for(int col=0;col<mat[0].length;col++){
            for(int row=0;row<mat.length;row++){
                if(mat[row][col]==1){
                    return row;
                }
            }
        }
        return -1;
    }

    /*
    * Time Complexity : O(n^2)
    */
    public static int rowWithMax1sBruteForce2(int[][] mat) {
        int index = -1;
        int maxCount=0;

        for(int row=0;row<mat.length;row++ ){
            int count=0;
            for(int col=0;col<mat[row].length;col++){
                if(mat[row][col]==1) count++;
            }
            if(count>maxCount){
                maxCount=count;
                index = row;
            } 
        }
        return index;
    }

    /*
    * Time Complexity : O(n log n)
    */
    public static int rowWithMax1s(int[][] mat) {
        int rowIndex=-1;
        int left=0;
        int right=mat[0].length-1;
        while(left<=right){
            boolean found=false;
            int mid = (left+(right-left)/2);


            for(int row=0;row<mat.length;row++){
                if(mat[row][mid]==1){
                    rowIndex=row;
                    found=true;
                    break;
                }
            }
            if(found){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return rowIndex;
    }

    /*
    * Time Complexity : O(n log n)
    */
    public static int rowWithMax1s2(int[][] mat) {
        int maxIndex = -1;
        int maxCount=0;
        
        for(int row=0;row<mat.length;row++ ){
            int left=0;
            int right=mat[row].length-1;
            int index = mat[row].length;

            while(left<=right){
                int mid = (left+(right-left)/2);
                if(mat[row][mid]>=1){
                    index = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            
            int count = mat[row].length-index;
            if(count>maxCount){
                maxCount=count;
                maxIndex=row;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        int[][] nums1 = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        int[][] nums2 = {{0,0}, {0, 0}};
        int[][] nums3 = {{0, 0, 1}, {0, 1, 1}, {0, 1, 1}};
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1sBruteForce(nums1));
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1sBruteForce2(nums1)); 
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1s(nums1));
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1s2(nums1));

        System.out.println("---------------------------------------------");
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1sBruteForce(nums2));
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1sBruteForce2(nums2)); 
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1s(nums2));
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1s2(nums2));

        System.out.println("---------------------------------------------");
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1sBruteForce(nums3));
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1sBruteForce2(nums3)); 
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1s(nums3));
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1s2(nums3));

        System.out.println("---------------------------------------------");
    }
}
