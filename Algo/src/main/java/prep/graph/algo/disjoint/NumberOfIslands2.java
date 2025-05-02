package prep.graph.algo.disjoint;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    public static void main(String[] args) {
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1}, {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}};
        NumberOfIslands2 islands2 = new NumberOfIslands2();
        System.out.println(islands2.numberOfIslands(4, 5, operators));
    }

    public List<Integer> numberOfIslands(int n, int m, int[][] operators) {
        List<Integer> result = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        DisjointSet dsu = new DisjointSet(m * n);
        dsu.size.get(0);
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int[] operator : operators) {
            int row = operator[0], col = operator[1];
            if (!visited[row][col]) {
                visited[row][col] = true;
                int node = row * m + col;
                count++;
                for (int[] dir : directions) {
                    int adjRow = row + dir[0];
                    int adjCol = col + dir[1];
                    if (isValid(visited, adjRow, adjCol, n, m)) {
                        int adjNode = adjRow * m + adjCol;
                        if (dsu.findParent(node) != dsu.findParent(adjNode)) {
                            dsu.unionBySize(node, adjNode);
                            count--;
                        }
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private boolean isValid(boolean[][] visited, int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n && visited[row][col];
    }
}
