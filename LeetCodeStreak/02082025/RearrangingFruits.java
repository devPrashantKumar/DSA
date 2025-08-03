import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangingFruits {

    public long minCost(int[] basket1, int[] basket2) {
        long minCost=0;
        int n= basket1.length;
        Arrays.sort(basket1);
        Arrays.sort(basket2);
        List<Integer> basket1Extra = new ArrayList<>();
        List<Integer> basket2Extra = new ArrayList<>();
        int i=0,j=0;
        while(i<n && j<n){
            if(basket1[i]==basket2[j]){
                i++;j++;
            }
            else if(basket1[i]<basket2[j]){
                if(i+1<n && basket1[i]==basket1[i+1]){
                    basket1Extra.add(basket1[i]);
                    i+=2;
                }
                else return -1;
            }else{
                if(j+1<n && basket2[j]==basket2[j+1]){
                    basket2Extra.add(basket2[j]);
                    j+=2;
                }
                else return -1;
            }
        }
        while(j<n){
            if(j+1<n && basket2[j]==basket2[j+1]){
                basket2Extra.add(basket2[j]);
                j+=2;
            }
            else return -1;
        }
        while(i<n){
            if(i+1<n && basket1[i]==basket1[i+1]){
                basket1Extra.add(basket1[i]);
                i+=2;
            }
            else return -1;
        }

        System.out.println("basket1Extra"+basket1Extra);
        System.out.println("basket2Extra"+basket2Extra);

        for(int k=0;k<basket1Extra.size();k++){
            minCost += Math.min(basket1Extra.get(k), basket2Extra.get(basket2Extra.size()-1-k));
        }
        return minCost;   
    }
    public static void main(String[] args) {
        
    }
}