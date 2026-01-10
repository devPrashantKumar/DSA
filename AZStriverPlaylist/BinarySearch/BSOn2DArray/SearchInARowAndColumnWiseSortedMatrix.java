package AZStriverPlaylist.BinarySearch.BSOn2DArray;

public class SearchInARowAndColumnWiseSortedMatrix {

    /*
    * Time Complexity O(m*n)
    */
    public static boolean searchMatrixBruteForce(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==target) return true;
            }
        }
        return false;
    }

    /*
    * Time Complexity O(n * log(m))
    */
    public static boolean searchMatrixBetterRowWise(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            int start = 0;
            int end = matrix[i].length-1;

            while(start<=end){
                int mid = start+((end-start)/2);
                if(matrix[i][mid]==target) return true;
                else if(matrix[i][mid]>target) end = mid-1;
                else start = mid+1;
            }
        }
        return false;
    }

    /*
    * Time Complexity O(m * log(n))
    */
    public static boolean searchMatrixBetterColumnWise(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        for(int i=0;i<matrix[0].length;i++){
            int start = 0;
            int end = matrix.length-1;

            while(start<=end){
                int mid = start+((end-start)/2);
                if(matrix[mid][i]==target) return true;
                else if(matrix[mid][i]>target) end = mid-1;
                else start = mid+1;
            }
        }
        return false;
    }

    /*
    * Time Complexity O(log(m+n))
    */
    public static boolean searchMatrixOptimal(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int row=0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target) col--;
            else row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target1 = 3;
        int[][] nums2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target2 = 13;
        int[][] nums3 = {{1,3}};
        int target3 = 1;

        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixBruteForce(nums1,target1));
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixBetterRowWise(nums1,target1));
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixBetterColumnWise(nums1,target1));
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixOptimal(nums1,target1));

        System.out.println("---------------------------------------------");
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixBruteForce(nums2,target2));
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixBetterRowWise(nums2,target2));
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixBetterColumnWise(nums2,target2));
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixOptimal(nums2,target2));

        System.out.println("---------------------------------------------");
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixBruteForce(nums3,target3));
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixBetterRowWise(nums3,target3));
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixBetterColumnWise(nums3,target3));
        System.out.println(SearchInARowAndColumnWiseSortedMatrix.searchMatrixOptimal(nums3,target3));

    }
}
