package AZStriverPlaylist.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class MajorityElement {

    //brute force
    public static int findMajorityElementBruteForce(int[] arr){
        int majorityElement=-1;
        int maxElementCount=0;
        for(int i=0;i<arr.length;i++){
            int count=0;
            int element=arr[i];
            if(arr[i]==-1) continue;
            for(int j=i;j<arr.length;j++){
                if(arr[j]==element){
                count++;
                arr[j]=-1;
                }
            }
            if(count>maxElementCount){
                maxElementCount=count;
                majorityElement=element;
            }
        }
        return majorityElement;
    }

    // better approch
    public static int findMajorityElementUsingHashMap(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>arr.length/2) return entry.getKey();
        }
        return -1;
    }

    // optimal approch (Moore's Voting Algorithm)
    public static int findMajorityElementUsingMooresVotingAlgo(int[] arr) {
        return -1;
    }
    
    public static void main(String[] args) {
        int[] input1 = {3,2,3};
        int[] input12 = {3,2,3};

        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+MajorityElement.findMajorityElementBruteForce(input1));
        System.out.println("Input : "+Arrays.toString(input12)+" Output : "+MajorityElement.findMajorityElementUsingHashMap(input12));
        System.out.println("Input : "+Arrays.toString(input12)+" Output : "+MajorityElement.findMajorityElementUsingMooresVotingAlgo(input12));

        System.out.println("------------------------------------------------------");
        int[] input2 = {2,2,1,1,1,2,2};
        int[] input22 = {2,2,1,1,1,2,2};

        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+MajorityElement.findMajorityElementBruteForce(input2));
        System.out.println("Input : "+Arrays.toString(input22)+" Output : "+MajorityElement.findMajorityElementUsingHashMap(input22));
        System.out.println("Input : "+Arrays.toString(input22)+" Output : "+MajorityElement.findMajorityElementUsingMooresVotingAlgo(input22));

    }
}
