package AZStriverPlaylist.Greedy.Easy;

import java.util.Arrays;

public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        int fiveDollar = 0;
        int tenDollar = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveDollar++;
            } else if (bill == 10) {
                if (fiveDollar == 0) return false;
                fiveDollar--;
                tenDollar++;
            } else { // bill == 20
                if (tenDollar > 0 && fiveDollar > 0) {
                    tenDollar--;
                    fiveDollar--;
                } else if (fiveDollar >= 3) {
                    fiveDollar -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean lemonadeChange2(int[] bills) {
        int fiveDollar = 0;
        int tenDollar = 0;

        for (int originalBill : bills) {
            int bill = originalBill;
            bill -= 5;
            if(bill>=10 && tenDollar!=0){
                tenDollar--;
                bill -=10;
            }
            while(bill>=5 && fiveDollar!=0){
                fiveDollar--;
                bill -=5;
            }
            if(bill!=0) return false;
            if (originalBill == 5) fiveDollar++;
            if (originalBill == 10) tenDollar++;
        }

        return true;
    }

    public static boolean lemonadeChange3(int[] bills) {
        int fiveDollar = 0;
        int tenDollar = 0;

        for (int originalBill : bills) {
            int bill = originalBill;
            bill -= 5;
            if(bill>=10){
                if(tenDollar!=0){
                    tenDollar--;
                }
                else if(fiveDollar>=2){
                    fiveDollar -=2;
                } 
                else return false;
                bill -=10;
            }
            if(bill>=5 && fiveDollar!=0){
                fiveDollar--;
                bill -=5;
            }
            if(bill!=0) return false;
            if (originalBill == 5) fiveDollar++;
            if (originalBill == 10) tenDollar++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills1 = {5, 5, 5, 10, 20};
        System.out.println("Input: " + Arrays.toString(bills1));
        System.out.println("Output: " + lemonadeChange(bills1));
        System.out.println("Output: " + lemonadeChange2(bills1));
        System.out.println("Output: " + lemonadeChange3(bills1));

        System.out.println("----------------------------------------------");
        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println("Input: " + Arrays.toString(bills2));
        System.out.println("Output: " + lemonadeChange(bills2));
        System.out.println("Output: " + lemonadeChange2(bills2));
        System.out.println("Output: " + lemonadeChange3(bills2));

    }
}
