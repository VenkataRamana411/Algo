package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFarmland {
    public static void main(String[] args) {
        int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
        System.out.println(Arrays.deepToString(findFarmland(land)));
    }

    public static int[][] findFarmland(int[][] land) {
        List<int[]> resultList = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        for (int row = 0 ; row < m ; row++){
            for (int col = 0 ; col < n ; col++){
                if (land[row][col] == 1){
                    int[] ans = new int[4];
                    ans[0] = row;
                    ans[2] = col;
                    dfsHelper(land,row,col,m,n,ans);
                    resultList.add(ans);
                }
            }
        }
        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
    private static void dfsHelper(int[][] land,int row,int col,int m,int n,int[] ans){
        if (row < 0 || row >= m || col < 0 || col >= n || land[row][col] == 0){
            return;
        }
        if (land[row][col] == 1){
            ans[1] = Math.max(ans[1],row);
            ans[3] = Math.max(ans[3],col);
        }
        land[row][col] = 0;
        //dfsHelper(land,row-1,col,m,n,ans);
        dfsHelper(land,row+1,col,m,n,ans);
        //dfsHelper(land,row,col-1,m,n,ans);
        dfsHelper(land,row,col+1,m,n,ans);
    }
}
