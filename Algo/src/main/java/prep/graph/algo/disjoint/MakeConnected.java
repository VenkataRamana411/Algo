package prep.graph.algo.disjoint;

import java.util.ArrayList;
import java.util.List;

public class MakeConnected {
    private String temp = "";
    public static void main(String[] args) {
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        System.out.println(makeConnected(6,connections));
    }

    //[0,1],[0,2],[0,3],[1,2],[1,3]
    public static int makeConnected(int n, int[][] connections) {

        int extraCables = 0;
        DS ds = new DS(n);
        for (int[] connection : connections){
            if (ds.findParent(connection[0]) != ds.findParent(connection[1])){
                ds.unionBySize(connection[0],connection[1]);
            }else {
                extraCables++;
            }
        }
        int uniqueSystems = 0;
        for (int i = 0; i < n; i++){
            if (ds.findParent(i) == i){
                uniqueSystems++;
            }
        }
        return extraCables >= uniqueSystems-1 ? uniqueSystems-1 : -1;
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
