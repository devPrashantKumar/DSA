package AZStriverPlaylist.Greedy;

import java.util.*;

public class AssignCookies {

    public static int findContentChildren(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);

        int i=0,j=0;
        while(i<greed.length && j<cookies.length){
            if(greed[i]<=cookies[j]) i++;
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] greed1 = { 1,2,3 };
        int[] cookies1 = { 1,1 };
        System.out.println("Input : " + Arrays.toString(greed1)+" " + Arrays.toString(cookies1));
        System.out.println("output : " + AssignCookies.findContentChildren(greed1,cookies1));
        
        int[] greed2 = { 1,2 };
        int[] cookies2 = { 1,2,3 };
        System.out.println("Input : " + Arrays.toString(greed2)+" " + Arrays.toString(cookies2));
        System.out.println("output : " + AssignCookies.findContentChildren(greed2,cookies2));
    }
}
