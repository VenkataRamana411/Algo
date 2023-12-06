package prep.array;

public class FindTwoMax {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 12, 210, 56, 14, 4};
        helper(arr);
        helper2(arr);
    }

    private static void helper(int[] arr) {
        if (arr.length <= 2) {
            System.out.println("Invalid input");
            return;
        }
        int max_1 = arr[0], max_2 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= max_1) {
                max_2 = max_1;
                max_1 = arr[i];
            } else if (arr[i] > max_2) {
                max_2 = arr[i];
            }
        }
        System.out.println("Max-1 : " + max_1);
        System.out.println("Max-2 : " + max_2);
    }

    private static void helper2(int[] arr) {
        if (arr.length <= 3) {
            System.out.println("Invalid input");
            return;
        }
        int max_1 = arr[0], max_2 = arr[0], max_3 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            if (temp >= max_1) {
                max_3 = max_2;
                max_2 = max_1;
                max_1 = temp;
            } else if (temp >= max_2) {
                max_3 = max_2;
                max_2 = temp;
            } else if (temp > max_3) {
                max_3 = temp;
            }
        }

        System.out.println("Max-1 : " + max_1);
        System.out.println("Max-2 : " + max_2);
        System.out.println("Max-3 : " + max_3);

    }
}
