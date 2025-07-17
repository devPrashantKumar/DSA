package AZStriverPlaylist.Greedy;

import java.util.*;

public class FractionalKnapsack {
  static class Pair {
    int index;
    double valueWeightRatio;
    
    Pair(int index, double valueWeightRatio){
      this.index=index;
      this.valueWeightRatio=valueWeightRatio;
    }
    
    @Override
    public String toString() {
        return index + ": " + valueWeightRatio;
    }
  }

    public static double fractionalKnapsack(int[] values, int[] weights, int W) {
      double maxValue=0;
      Pair[] valuePerWeight = new Pair[values.length];
      for(int i=0;i<values.length;i++){
        valuePerWeight[i] = new Pair(i, (double)values[i]/weights[i]);
      }
      Arrays.sort(valuePerWeight, (s1, s2) ->{
        if(s2.valueWeightRatio - s1.valueWeightRatio>0) return 1;
        else if(s2.valueWeightRatio - s1.valueWeightRatio==0) return 0;
        else return -1;
      } );
      System.out.println(Arrays.toString(valuePerWeight));
      
      int i=0;
      while(W>0 && i<valuePerWeight.length){
        if(weights[valuePerWeight[i].index]<=W){
          W -= weights[valuePerWeight[i].index];
          maxValue += values[valuePerWeight[i].index];
        } 
        else{
          maxValue += valuePerWeight[i].valueWeightRatio*W;
          W=0;
        }
        i++;
      }
      return maxValue;
    }

    public static void main(String[] args) {
        int[] value1 = { 60, 100, 120 };
        int[] weight1 = { 10, 20, 30 };
        int w1 = 50;
        System.out.println("Input : " + Arrays.toString(value1)+" " + Arrays.toString(weight1));
        System.out.println("output : " + FractionalKnapsack.fractionalKnapsack(value1,weight1,w1));
        
        int[] value2 = { 60, 100 };
        int[] weight2 = {10, 20 };
        int w2 = 50;
        System.out.println("Input : " + Arrays.toString(value2)+" " + Arrays.toString(weight2));
        System.out.println("output : " + FractionalKnapsack.fractionalKnapsack(value2,weight2,w2));
        
        int[] value3 = { 10, 20, 30 };
        int[] weight3 = {5,10,15 };
        int w3 = 100;
        System.out.println("Input : " + Arrays.toString(value3)+" " + Arrays.toString(weight3));
        System.out.println("output : " + FractionalKnapsack.fractionalKnapsack(value3,weight3,w3));
    }
}
