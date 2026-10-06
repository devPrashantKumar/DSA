package AZStriverPlaylist.SlidingWindowAndTwoPointers.LongestAndSmallestWindowProblems;

public class MinimumWindowSubsequence {

    
    /*
    * Time Complexity : O(n^2)
    */
    public static String minWindow(String s1, String s2) {
        int sIndex=-1;
        int minLength=Integer.MAX_VALUE;
        if(s1.length()<s2.length() || s2.isEmpty()) return "";
        for(int i=0;i<s1.length()-s2.length()+1;i++){
            int k=0;
            for(int j=i;j<s1.length();j++){
                if(s1.charAt(j)==s2.charAt(k)) k++;
                if(k==s2.length()){
                    if(j-i+1<minLength){
                        sIndex = i;
                        minLength=j-i+1;
                    }
                    break;
                }
            }
        }
        return (sIndex==-1) ? "" : s1.substring(sIndex, sIndex+minLength);
    }

    /*
    * Time Complexity : O(n)
    */
    public static String minWindow2(String s1, String s2) {
        int sIndex=-1;
        int minLength=Integer.MAX_VALUE;
        if(s1.length()<s2.length() || s2.isEmpty()) return "";
        int j=0;
        int k=0;
        while(j<s1.length()){
            if(s1.charAt(j)==s2.charAt(k)) k++;
            if(k==s2.length()){
                k--;
                int i=j;
                while(k>=0){
                    if(s1.charAt(i)==s2.charAt(k)) k--;
                    i--;
                }
                if(j-i<minLength){
                    sIndex = i+1;
                    minLength=j-i;
                }
                k=0;
                j=i+1;
            }
            j++;
        }
        return (sIndex==-1) ? "" : s1.substring(sIndex, sIndex+minLength);
    }

    public static void main(String[] args) {
        String s1 = "abcdebdde";
        String t1 = "bde";
        
        System.out.println("Input String : " + s1 + " Output : "+ minWindow(s1, t1));
        System.out.println("Input String : " + s1 + " Output : "+ minWindow2(s1, t1));

        System.out.println("---------------------------------------------------------");
        String s2 = "jmeqsiwvaovvnbstl";
        String t2 = "u";

        System.out.println("Input String : " + s2 + " Output : "+ minWindow(s2, t2));
        System.out.println("Input String : " + s2 + " Output : "+ minWindow2(s2, t2));

        System.out.println("---------------------------------------------------------");
        String s3 = "geeksforgeeks";
        String t3 = "eksrg";

        System.out.println("Input String : " + s3 + " Output : "+ minWindow(s3, t3));
        System.out.println("Input String : " + s3 + " Output : "+ minWindow2(s3, t3));
        
        System.out.println("---------------------------------------------------------");
        String s4 = "jkjjjkjkjkjjjkkjjkjkkkjkkkkj";
        String t4 = "jkjkj";

        System.out.println("Input String : " + s4 + " Output : "+ minWindow(s4, t4));
        System.out.println("Input String : " + s4 + " Output : "+ minWindow2(s4, t4));


    }
}
