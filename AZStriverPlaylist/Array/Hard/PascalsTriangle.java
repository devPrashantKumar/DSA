package AZStriverPlaylist.Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> reList = new ArrayList<>();
        if(numRows==0) return reList;
        List<Integer> row = Arrays.asList(1);
        reList.add(row);
        for(int i=1;i<numRows;i++){
            List<Integer> prevList = reList.get(i-1);
            List<Integer> rowList = new ArrayList<>();
            rowList.add(1);
            for(int j=0;j<prevList.size()-1;j++){
                rowList.add(prevList.get(j)+prevList.get(j+1));
            }
            rowList.add(1);
            reList.add(rowList);
        } 
        return reList;
    }

    public static List<List<Integer>> generateOptimal(int numRows) {
        List<List<Integer>> reList = new ArrayList<>();
        
        for(int i=0;i<numRows;i++){
            reList.add(pascalRow(i));
        } 
        return reList;
    }

     /*
     * Each element is computed using the previous one based on the combination formula:
     *
     *   C(n, r) = C(n, r - 1) × (n - r + 1) / r
     *
     * Here:
     *   n = rowNum - 1
     *   r = i
     *
     * This avoids recomputing factorials and builds the row in O(n) time.
     */
    public static List<Integer> pascalRow(int rowNum) {
        List<Integer> reList = new ArrayList<>();
        int ans = 1;
        reList.add(ans);
        for(int i=1;i<=rowNum;i++){
            ans  *= (rowNum-i+1);
            ans /= (i);
            reList.add(ans);
        } 
        return reList;
    }
    
    public static void main(String[] args) {
        int input1 = 5;
        System.out.println("Input : "+input1+" Output : "+PascalsTriangle.generate(input1));
        System.out.println("Input : "+input1+" Output : "+PascalsTriangle.generateOptimal(input1));

        System.out.println("------------------------------------------------------");
        int input2 = 4;
        System.out.println("Input : "+input2+" Output : "+PascalsTriangle.generate(input2));
        System.out.println("Input : "+input2+" Output : "+PascalsTriangle.generateOptimal(input2));


    }
}