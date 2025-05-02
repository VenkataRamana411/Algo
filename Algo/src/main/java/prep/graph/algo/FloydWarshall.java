package prep.graph.algo;

import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {
        //int[][] matrix = {{0,2,-1,-1},{1,0,3,-1},{-1,-1,0,-1},{3,5,4,0}};
        int[][] matrix = {{0,1,43},{1,0,6},{-1,-1,0}};
        shortDistance(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    /**
     * TC: O(n^3)
     *
     * Basic concept: Take  each node and iterate over it for every other node
     * Reach A to B via C ==> A-> C + C -> B  < A -> B
     * Check if any value is less than 0 to confirm negative cycle
     * Dijkstra can be used by applying on every other node for better performance only if there are no negative edges
    * */
    public static void shortDistance(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == -1){
                    matrix[i][j] = 100000;
                }else if (i == j){
                    matrix[i][i] = 0;
                }
            }
        }
        for (int via = 0; via < n; via++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 100000) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
