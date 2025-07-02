package AZStriverPlaylist.StackAndQueues;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeDigits(String str, int k){
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<str.length();i++){
            int number = str.charAt(i)-'0';
            if(k==0 || stk.isEmpty() || number>=stk.peek()) stk.push(number);
            else{
                while(k!=0 && !stk.isEmpty() && number<stk.peek()){
                    stk.pop(); k--;
                }
                stk.push(number);
            }
            
        }
        while(k!=0 && !stk.isEmpty()){
            stk.pop(); k--;
        }
        StringBuilder ans = new StringBuilder();
        while(!stk.isEmpty()){
            ans.insert(0,stk.pop());
        }
        while(ans.indexOf("0")==0) ans.deleteCharAt(0);
        if(ans.length()==0) ans.append(0);
        return ans.toString();
    }
    public static void main(String[] args) {
        String stringInput1 = "1432219";
        int k1 = 3;
        String stringInput2 = "10200";
        int k2=1;
        String stringInput3 = "10";
        int k3=2;

        System.out.println("Input String : " + stringInput1 + " Output : " + RemoveKDigits.removeDigits(stringInput1,k1));
        System.out.println("Input String : " + stringInput2 + " Output : " + RemoveKDigits.removeDigits(stringInput2,k2));
        System.out.println("Input String : " + stringInput3 + " Output : " + RemoveKDigits.removeDigits(stringInput3,k3));
    }
}
