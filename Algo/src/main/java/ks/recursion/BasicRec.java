package ks.recursion;

public class BasicRec {
    public static void main(String[] args) {
        /*System.out.println(printFibonacci(7));
        int[] nums = new int[]{3, 4, 6, 7, 9, 12, 16, 17};
        System.out.println(binarySearch(nums, 0, nums.length - 1, 107));
        System.out.println(linearSearch(nums, 0, 107));*/
        System.out.println(numberOfSteps(8,0));
    }

    private static int printFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return printFibonacci(n - 1) + printFibonacci(n - 2);
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, high, target);
        }
    }

    private static int linearSearch(int[] nums, int index, int target) {
        if (index == nums.length) {
            return -1;
        }
        if (nums[index] == target) {
            return index;
        }
        return linearSearch(nums, index + 1, target);
    }

    private static int printN(int n) {
        if (n == 0) {
            return n;
        }
        System.out.println(n);
        return printN(n - 1);
    }

    private static void printNReverse(int n) {
        if (n == 0) {
            return;
        }
        printNReverse(n - 1);
        System.out.println(n);
    }

    private static int factorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorial(n - 1);
    }

    private static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    private static int productOfDigits(int n) {
        if (n == 0) {
            return 1;
        }
        return (n % 10) * productOfDigits(n / 10);
    }

    private static int reverseNumber(int n, int result) {
        if (n == 0) {
            return result;
        }
        result = (result * 10) + (n % 10);
        return reverseNumber(n/10,result);
    }
    private static int countZeros(int n , int result){
        if (n == 0){
            return result;
        }
        if (n % 10 == 0){
            result++;
        }
        return countZeros(n/10,result);
    }
    private static int numberOfSteps(int n , int result){
        if (n == 0){
            return result;
        }
        result++;
        if (n % 2 == 0){
            return numberOfSteps(n/2,result);
        }
        return numberOfSteps(n-1,result);
    }
}
