package AZStriverPlaylist.Greedy;

public class FindMinimumNumberOfCoins {
    public static int minimuCoins(int value){
        int coins=0;
        int[] coinDenomination = {1000,500, 100, 50, 20, 10, 5, 2, 1};
        for(int i=0;i<coinDenomination.length;i++){
            coins += value/coinDenomination[i];
            value %= coinDenomination[i];
        }
        return coins;
    }
    public static void main(String[] args) {
        System.out.println("Minimum Coins Required : "+FindMinimumNumberOfCoins.minimuCoins(70));
        System.out.println("Minimum Coins Required : "+FindMinimumNumberOfCoins.minimuCoins(121));
    }
}
