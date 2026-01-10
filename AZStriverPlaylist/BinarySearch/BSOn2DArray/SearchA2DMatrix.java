package AZStriverPlaylist.BinarySearch.BSOn2DArray;

public class SearchA2DMatrix {

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
    public static boolean searchMatrixBetter(int[][] matrix, int target) {
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
    * Time Complexity O(log(m*n))
     */
    public static boolean searchMatrixOptimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = (m*n)-1;

        while(start<=end){
            int mid = start+((end-start)/2);
            if(matrix[mid/m][mid%m]==target) return true;
            else if(matrix[mid/m][mid%m]>target) end = mid-1;
            else start = mid+1;
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

        System.out.println(SearchA2DMatrix.searchMatrixBruteForce(nums1,target1));
        System.out.println(SearchA2DMatrix.searchMatrixBetter(nums1,target1));
        System.out.println(SearchA2DMatrix.searchMatrixOptimal(nums1,target1));

        System.out.println("---------------------------------------------");
        System.out.println(SearchA2DMatrix.searchMatrixBruteForce(nums2,target2));
        System.out.println(SearchA2DMatrix.searchMatrixBetter(nums2,target2));
        System.out.println(SearchA2DMatrix.searchMatrixOptimal(nums2,target2));

        System.out.println("---------------------------------------------");
        System.out.println(SearchA2DMatrix.searchMatrixBruteForce(nums3,target3));
        System.out.println(SearchA2DMatrix.searchMatrixBetter(nums3,target3));
        System.out.println(SearchA2DMatrix.searchMatrixOptimal(nums3,target3));

    }
}
