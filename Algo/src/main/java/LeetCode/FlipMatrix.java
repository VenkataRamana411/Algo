package LeetCode;

public class FlipMatrix {
    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }

    public static int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0, j = 0, result = 0;
        for (; i < m; i++) {
            if (grid[i][j] == 0) {
                for (; j < n; j++) {
                    if (grid[i][j] == 0) {
                        grid[i][j] = 1;
                    } else {
                        grid[i][j] = 0;
                    }
                }
                j = 0;
            }
        }
        int countZero = 0, countOne = 1;
        for (; j < n; j++) {
            for (i = 0; i < m; i++) {
                if (grid[i][j] == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            if (countZero > countOne) {
                for (i = 0; i < m; i++) {
                    if (grid[i][j] == 0) {
                        grid[i][j] = 1;
                    } else {
                        grid[i][j] = 0;
                    }
                }
            }
            countZero = 0;
            countOne = 0;
        }

        for (i = 0; i < m; i++) {
            StringBuilder num = new StringBuilder();
            for (j = 0; j < n; j++) {
                num.append(grid[i][j]);
            }
            result += Integer.parseInt(num.toString(), 2);
        }
        return result;
    }
}
