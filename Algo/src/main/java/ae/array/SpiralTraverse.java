package ae.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        System.out.println(spiralTraverse(array));
    }


    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int endRow = array.length , endCol = array[0].length;
        int startRow = 0 , startCol = 0;
        while (startCol < endCol){
            result.add(array[startRow][startCol++]);
        }
        startCol--;
        startRow++;
        while (startRow < endRow){
            result.add(array[startRow++][startCol]);
        }
        startRow--;
        startCol--;
        while (startCol >= 0){
            result.add(array[startRow][startCol--]);
        }
        startCol++;
        startRow--;
        while (startRow >= 1){
            result.add(array[startRow--][startCol]);
        }
        return result;
    }
}
