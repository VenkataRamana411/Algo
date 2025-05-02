package prep.graph.algo.disjoint;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
        System.out.println(findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    public static int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        DS disjointSet = new DS(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    disjointSet.unionBySize(i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            if (disjointSet.findParent(i) == i) {
                result++;
            }
        }
        return result;
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
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findParent(parent.get(node));
            parent.set(node, ulp);
            return ulp;
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
