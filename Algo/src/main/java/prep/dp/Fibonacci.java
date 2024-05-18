package prep.dp;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibRec(5));
        System.out.println(fibDP(30));
    }

    /**
     * TC: O(2^N)  ==> Branched power of depth
     * SC: O(1) - InMemory but O(N) - Auxiliary memory [Due to recursive stack] [Uses heap space]
    * */
    private static int fibRec(int n){
        if (n <=1 ){
            return n;
        }
        return fibRec(n-1) + fibRec(n-2);
    }

    /**
    *   TC:O(N)
     *  SC: O(N)
    * */
    private static int fibDP(int n){
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2 ; i <=n ; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
}
