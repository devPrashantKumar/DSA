package AZStriverPlaylist.Array.Easy;

public class LinearSearch {
    /*
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static Integer linearSearch(Integer[] arr, Integer data){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(data)){
                return arr[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,5,2,9,4,7,3};
        System.out.println("Element found 3 - "+LinearSearch.linearSearch(arr, 3));
        System.out.println("Element found 13 - "+LinearSearch.linearSearch(arr, 13));
    }
}
