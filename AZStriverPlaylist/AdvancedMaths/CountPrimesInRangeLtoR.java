package AZStriverPlaylist.AdvancedMaths;

import java.util.ArrayList;
import java.util.Arrays;

public class CountPrimesInRangeLtoR {
    public static ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
        int maxRight = queries.stream().max((a,b)->a[1]-b[1]).orElse(new int[]{0,0})[1];
        int[] seive = getSieve(maxRight);
        for(int i=3;i<seive.length;i++){
            seive[i] += seive[i-1]; 
        }
        ArrayList<Integer> result = new ArrayList<>();
        queries.stream().forEach(a->{
            result.add(seive[a[1]]-seive[a[0]-1]);
        });
        return result;
    }

    public static int[] getSieve(int n) {
        int[] primeArray = new int[n+1];
        Arrays.fill(primeArray, 1);

        for(int i=2;i<=n/i;i++){
            if(primeArray[i]==1){
                for(int j=i*i;j<=n;j=j+i){
                    primeArray[j]=0;
                }
            }
        }
        if(primeArray.length>1) primeArray[0]=0;
        if(primeArray.length>2) primeArray[1]=0;
        return primeArray;
    }

    public static void main(String[] args) {
        ArrayList<int[]> queries1 = new ArrayList<>();
        queries1.add(new int[]{2,5});
        queries1.add(new int[]{4,7});
        System.out.println("input : "+queries1);
        System.out.println("output : "+primesInRange(queries1));
        System.out.println("------------------------------------------------------");
        ArrayList<int[]> queries2 = new ArrayList<>();
        queries2.add(new int[]{1,7});
        queries2.add(new int[]{3,7});
        System.out.println("input : "+queries2);
        System.out.println("output : "+primesInRange(queries2));
        System.out.println("------------------------------------------------------");

    }
}
