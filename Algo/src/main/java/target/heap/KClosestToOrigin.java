package target.heap;

import java.util.*;

public class KClosestToOrigin {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{3, 3}, {5, -1}, {-2, -4},{-4, 2}}, 3)));
    }

    public static int[][] kClosest(int[][] points, int k) {

        //K is initial capacity
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])); //K is initial capacity

        for(int[] point: points) {
            pq.add(point);
            if(pq.size() > k) pq.poll();
        }
        return pq.toArray(new int[0][0]);


//        TreeMap<Double,Integer> map = new TreeMap<>();
//        for(int i = 0; i < points.length; i++){
//            double d = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
//            if (map.containsKey(d)){
//                map.put(d+i,i);
//            }else {
//                map.put(d,i);
//            }
//        }
//        int[][] result = new int[k][2];
//        int j = 0;
//        for (Map.Entry<Double,Integer> entry : map.entrySet()){
//            int index = entry.getValue();
//            result[j][0] = points[index][0];
//            result[j][1] = points[index][1];
//            j++;
//            if (j == k){
//                break;
//            }
//        }
//        return result;
    }
}
