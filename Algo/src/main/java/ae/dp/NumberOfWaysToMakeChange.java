package ae.dp;

public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(10,new int[]{1,5,10,25}));
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        int[] dpWays = new int[n+1];
        dpWays[0] = 1;
        for (int denom : denoms){
            for (int i = denom ; i <= n ; i++){
                dpWays[i] += dpWays[i-denom];
            }
        }
        return dpWays[n];
    }
}
