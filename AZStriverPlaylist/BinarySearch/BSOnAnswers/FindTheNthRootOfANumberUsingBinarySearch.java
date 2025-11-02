package AZStriverPlaylist.BinarySearch.BSOnAnswers;

public class FindTheNthRootOfANumberUsingBinarySearch {
    
    public static int NthRoot(int N, int M) {
        int left = 1;
        int right = M;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double power = Math.pow(mid, N);
            //if (power == (double) M)
            if (Math.abs(power - M) < 1e-9)
                return mid;
            if (power > (double) M)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return ans;
    }

    public static int NthRoot2(int N, int M) {
        int left = 1, right = M;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int check = power(mid, N, M);
            if (check == 1)
                return mid;
            else if (check == 2)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    private static int power(int base, int exp, int limit) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
            if (result > limit)
                return 2; // overflow case
        }
        if (result == limit)
            return 1;
        return result < limit ? 0 : 2;
    }

    public static void main(String[] args) {
        System.out.println(NthRoot(3, 27));
        System.out.println(NthRoot(4, 69));
        System.out.println(NthRoot(4, 16));
        System.out.println(NthRoot(5, 3125));
        System.out.println(NthRoot(2, 10));
        System.out.println("------------------------------------");
        System.out.println(NthRoot2(3, 27));
        System.out.println(NthRoot2(4, 69));
        System.out.println(NthRoot2(4, 16));
        System.out.println(NthRoot2(5, 3125));
        System.out.println(NthRoot2(2, 10));
        System.out.println("------------------------------------");
    }
}
