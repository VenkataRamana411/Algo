package prep.array;

import java.util.Arrays;

public class PrimeAndSeive {
    public static void main(String[] args) {
        System.out.println(primeHelper(41));
        System.out.println(primeHelper(231));
        seive(20);
        sexyPrime(35);
    }

    /**
     * Euclid Theorem - For every non-prime, a factor should always present between the range of [2,sqrt(N)]
     * TC: O(sqrt(N))
     * SC: O(1)
     */
    private static boolean primeHelper(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * TC: O(N * log(log N)) every time we are dividing input log n of log times
     */
    private static void seive(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int p = i * i; p <= n; p += i) {
                    primes[p] = false;
                }
            }
        }

        for (int j = 2; j < n; j++) {
            if (primes[j]) {
                System.out.println(j + " is Prime");
            }
        }
    }


    private static void sexyPrime(int n) {
        boolean[] primes = new boolean[n + 7];
        Arrays.fill(primes, true);

        for (int i = 2; i * i <= n + 6; i++) {
            if (primes[i]) {
                for (int p = i * i; p <= n + 6; p += i) {
                    primes[p] = false;
                }
            }
        }

        for (int j = 2; j + 6 < n; j++) {
            if (n % j == 0) {
                if (primes[j] && primes[j + 6]) {
                    System.out.println(j + " is sexy Prime factor");
                }
            }

        }
    }
}

