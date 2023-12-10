package prep.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        //System.out.println(generate(6));
        bruteForce(6);
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(rowGenerator(i));
        }
        return result;
    }

    private static List<Integer> rowGenerator(int row) {
        List<Integer> rowElements = new ArrayList<>();
        rowElements.add(1);
        int ans = 1;
        for (int i = 0; i < row; i++) {
            ans = ans * (row - i);
            ans = ans / (i + 1);
            rowElements.add(ans);
        }
        return rowElements;
    }
    /**
    * TC: O(N2)
     * SC: O(N*R)
    * */

    private static void bruteForce(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = result.get(result.size() - 1);
            List<Integer> tempRow = new ArrayList<>();
            tempRow.add(1);
            for (int j = 0, k = 1; k < lastRow.size(); j++, k++) {
                tempRow.add(lastRow.get(j) + lastRow.get(k));
            }
            tempRow.add(1);
            result.add(tempRow);
        }
        System.out.println(result);
    }
}
