package prep.graph.algo.disjoint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MakeLargeIsland {

    public static void main(String[] args) {

    }

    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int result = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        DS dsu = new DS(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {

                    for (int[] dir : directions) {
                        int adjRow = i + dir[0];
                        int adjCol = j + dir[1];
                        if (isValid(n, m, grid, adjRow, adjCol)) {
                            int adjNode = adjRow * m + adjCol;
                            int currNode = i * m + j;
                            if (dsu.findParent(currNode) != dsu.findParent(adjNode)) {
                                dsu.unionBySize(adjNode, currNode);
                            }
                            result = Math.max(result, dsu.size.get(0));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    for (int[] dir : directions) {
                        int adjRow = i + dir[0];
                        int adjCol = j + dir[1];
                        if (isValid(n, m, grid, adjRow, adjCol)) {
                            int adjNode = adjRow * m + adjCol;
                            hashSet.add(dsu.findParent(adjNode));
                        }
                    }
                    int curr = 1;
                    for (Integer node : hashSet) {
                        curr += dsu.size.get(node);
                    }

                    result = Math.max(result, curr);
                }
            }
        }
        return result;
    }

    private boolean isValid(int n, int m, int[][] grid, int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1;
    }

    private static class DS {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DS(int V) {
            for (int i = 0; i < V; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if (!parent.get(node).equals(node)) { // Avoid unnecessary recursion
                parent.set(node, findParent(parent.get(node))); // Direct compression
            }
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int up = findParent(u);
            int vp = findParent(v);

            if (up == vp) {
                return;
            } else if (size.get(up) < size.get(vp)) {
                size.set(vp, size.get(vp) + size.get(up));
                parent.set(up, vp);
            } else {
                size.set(up, size.get(up) + size.get(vp));
                parent.set(vp, up);
            }
        }
    }
}
