package AZStriverPlaylist.AdvancedMaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorisationOfANumberQQueries {

    public static List<List<Integer>> primeFactors(int[] queries) {
        int max = Arrays.stream(queries).max().orElse(0);
        int[] spfArray = getSpfArray(max);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            List<Integer> factors = new ArrayList<>();
            int n = queries[i];
            while(n>1){
                factors.add(spfArray[n]);
                n /= spfArray[n];
            }
            result.add(factors);
        }
        return result;
    }

    public static int[] getSpfArray(int n){
        int[] spfArray = new int[n+1];
        for(int i=2;i<spfArray.length;i++){
            spfArray[i]=i;
        }
        for(int i=2;i<=spfArray.length/i;i++){
            if(spfArray[i]==i){
                for(int j=i*i;j<spfArray.length;j=j+i){
                    if(spfArray[j]==j) spfArray[j]=i;
                }
            }
        }
        return spfArray;
    }

    public static void main(String[] args) {
        int[] queries1 = {2, 3, 4, 5, 6};
        System.out.println("input : "+Arrays.toString(queries1));
        System.out.println("output : "+primeFactors(queries1));
        System.out.println("------------------------------------------------------");
        int[] queries2 = {7, 12, 18};
        System.out.println("input : "+Arrays.toString(queries2));
        System.out.println("output : "+primeFactors(queries2));
        System.out.println("------------------------------------------------------");
        int[] queries3 = {15,20};
        System.out.println("input : "+Arrays.toString(queries3));
        System.out.println("output : "+primeFactors(queries3));
        System.out.println("------------------------------------------------------");

    }
}
