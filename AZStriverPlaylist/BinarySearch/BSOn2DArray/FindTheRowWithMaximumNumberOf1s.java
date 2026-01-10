package AZStriverPlaylist.BinarySearch.BSOn2DArray;

public class FindTheRowWithMaximumNumberOf1s {

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

    public static void main(String[] args) {
        int[][] nums1 = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        int[][] nums2 = {{0,0}, {0, 0}};
        int[][] nums3 = {{0, 0, 1}, {0, 1, 1}, {0, 1, 1}};
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1s(nums2));
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1s(nums1)); 
        System.out.println(FindTheRowWithMaximumNumberOf1s.rowWithMax1s(nums3));
        System.out.println("---------------------------------------------");
    }
}
