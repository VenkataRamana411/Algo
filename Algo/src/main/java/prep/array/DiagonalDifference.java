package prep.array;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        matrix.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        matrix.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(9);
        list3.add(8);
        list3.add(9);
        matrix.add(list3);
        System.out.println("Diagonal Difference is : " + helper(matrix));
    }

    static int helper(List<List<Integer>> matrix) {
        int row = matrix.size();
        int col = matrix.get(0).size();
        int primaryDiagonal = 0, secondaryDiagonal = 0;
        for (int i = 0, j = col - 1; i < row && j >= 0; i++, j--) {
            primaryDiagonal += matrix.get(i).get(i);
            secondaryDiagonal += matrix.get(i).get(j);
        }
        return Math.abs(primaryDiagonal - secondaryDiagonal);
    }
}
