package LeetCode.lc2025;

import java.util.Arrays;

public class FindRepeats {
    public static void main(String[] args) {
        int[][] input = {{1,3},{2,2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(input)));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] freq = new int[(row*col)+1];
        freq[0] = -1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                freq[grid[i][j]] += 1;
            }
        }
        int[] result = new int[2];
        for(int i = 1; i < freq.length; i++){
            if(freq[i] == 2){
                result[0] = i;
            }else if(freq[i] == 0){
                result[1] = i;
            }
        }
        return result;
    }
}
