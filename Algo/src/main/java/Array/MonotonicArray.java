package Array;

public class MonotonicArray {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[] {-1, -5,-10, -1100, -1100, -1101, -1102, -9001}));
    }

    public static boolean isMonotonic(int[] array) {
        boolean isNotIncreasing = true;
        boolean isNotDecreasing = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                isNotDecreasing = false;
            }
            if (array[i] > array[i - 1]) {
                isNotIncreasing = false;
            }
        }

        return isNotDecreasing || isNotIncreasing;
    }
}
