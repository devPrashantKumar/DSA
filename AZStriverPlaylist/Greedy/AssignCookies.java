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

    public static int findContentChildren2(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);

        int i=greed.length-1,j=cookies.length-1;
        while(i>=0 && j>=0){
            if(greed[i]<=cookies[j]) j--;
            i--;
        }
        return cookies.length-(j+1);
    }

    public static void main(String[] args) {
        int[] greed1 = { 1,2,3 };
        int[] cookies1 = { 1,1 };
        System.out.println("Input : " + Arrays.toString(greed1)+" " + Arrays.toString(cookies1));
        System.out.println("output : " + AssignCookies.findContentChildren(greed1,cookies1));
        System.out.println("output : " + AssignCookies.findContentChildren2(greed1,cookies1));

        int[] greed2 = { 1,2 };
        int[] cookies2 = { 1,2,3 };
        System.out.println("Input : " + Arrays.toString(greed2)+" " + Arrays.toString(cookies2));
        System.out.println("output : " + AssignCookies.findContentChildren(greed2,cookies2));
        System.out.println("output : " + AssignCookies.findContentChildren2(greed2,cookies2));

    }
}
