package AZStriverPlaylist.BinarySearch.BSOn2DArray;

public class MatrixMedian {

    /*
    * Time Complexity: O(n log m log(maxValue - minValue))
    * Space Complexity: O(1)
    */
    public static int findMedian(int[][] matrix) {
        // it is given m and n both are odd
        int n = matrix.length;
        int m = matrix[0].length;
        int medianLeft = (m*n)/2;
        int left = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) left = Math.min(left,matrix[i][0]);
        int right = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) right = Math.max(right,matrix[i][m-1]);
        while(left<=right){
            int mid = left+(right-left)/2;
            int smallerElements = countSmallerElementsInMatrix(matrix,mid);
            if(smallerElements<=medianLeft) left = mid+1;
            else right = mid-1;
        }
        return left;
    }

    public static int countSmallerElementsInMatrix(int[][] matrix, int num) {
        int count=0;
        for(int i=0;i<matrix.length;i++){
            count += countSmallerElements(matrix, num, i);
        }
        return count;
    }

    public static int countSmallerElements(int[][] matrix, int num, int row) {
        int left=0;
        int right = matrix[0].length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(matrix[row][mid]>num) right=mid-1;
            else left = mid+1;
        }
        return left;
    }



    public static void main(String[] args) {
        int[][] nums1 = {{1,4,9},{2,5,6},{3,7,8}};
        int[][] nums2 = {{1,4,15},{2,5,6},{3,8,11}};
        int[][] nums3 = {{1,3,8},{2,3,4},{1,2,5}};

        System.out.println(findMedian(nums1));
        System.out.println(findMedian(nums2));
        System.out.println(findMedian(nums3));
    }
}
