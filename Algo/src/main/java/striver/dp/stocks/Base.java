package striver.dp.stocks;

public class Base {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int profit = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            profit = Math.max(profit,arr[i]-min);
            min = Math.min(arr[i],min);
        }
        System.out.println(profit);
    }


}
