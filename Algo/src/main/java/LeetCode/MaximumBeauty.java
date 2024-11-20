package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MaximumBeauty {
    public static void main(String[] args) {
//        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
//        int[] queries = {1,2,3,4,5,6};
        int[][] items2= {{193,732},{781,962},{864,954},{749,627},{136,746},{478,548},{640,908},{210,799},{567,715},{914,388},{487,853},{533,554},{247,919},{958,150},{193,523},{176,656},{395,469},{763,821},{542,946},{701,676}};
        int[] queries2 = {885,1445,1580,1309,205,1788,1214,1404,572,1170,989,265,153,151,1479,1180,875,276,1584};
        System.out.println(Arrays.toString(maximumBeauty(items2, queries2)));
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        int[] temp = Arrays.copyOf(queries,queries.length);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Arrays.sort(items,(a,b) -> a[0]-b[0]);
        Arrays.sort(temp);
        int prev = 0;
        for (int[] item : items){
            if (prev > item[1]){
                item[1] = prev;
            }else {
                prev = item[1];
            }
        }
        for (int i = items.length-1 , j = temp.length-1; j >= 0 && i >= 0;){
            while (j >= 0 && items[i][0] <= temp[j]){
                hashMap.put(temp[j],items[i][1]);
                j--;
            }
            i--;
        }
        for (int i = 0; i < queries.length; i++){
            result[i] = hashMap.getOrDefault(queries[i],0);
        }
        return result;
    }
}
