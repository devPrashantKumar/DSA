package AZStriverPlaylist.Greedy.Hard;

public class Candy {

   public static int candy(int[] ratings) {
        if(ratings.length==0) return 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0]=1;
        right[ratings.length-1]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }
            else {
                left[i]=1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right[i] = right[i+1]+1;
            }
            else {
                right[i] = 1;
            }
        }

        int totalCandy=0;
        for(int i=0;i<ratings.length;i++){
            totalCandy += Math.max(left[i], right[i]);
        }
        return totalCandy;
    }
    public static void main(String[] args) {
        System.out.println("Output 1 : "+candy(new int[]{1,0,5}));
        System.out.println("-----------------------------------------");
        System.out.println("Output 1 : "+candy(new int[]{1,2,2}));
    }
}
