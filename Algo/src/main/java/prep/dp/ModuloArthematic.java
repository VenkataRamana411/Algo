package prep.dp;

public class ModuloArthematic {
    public static void main(String[] args) {
        System.out.println(solve(5, 11));
    }

    private static int solve(int n, int p) {
        if (n > p){
            return 0;
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = ((res % p) * (i % p)) % p;
        }
        return res;
    }
}
