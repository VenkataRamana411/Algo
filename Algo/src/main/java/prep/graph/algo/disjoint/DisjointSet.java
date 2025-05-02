package prep.graph.algo.disjoint;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    //Use either Size (preferably) or Rank
    public DisjointSet(int nodes) {
        for (int i = 0; i <= nodes; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    /**
     * Find ultimate parent, in case of child go till root and update for other nodes as well
     * */
    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    /**
     * If both parents are same no need to do anything
     * Otherwise add smaller part to bigger part. While doing so update size accordingly
     * */
    public void unionBySize(int u, int v) {
        int ulpU = findParent(u);
        int ulpV = findParent(v);

        if (ulpU == ulpV) {
            return;
        } else if (size.get(ulpU) < size.get(ulpV)) {
            size.set(ulpV, size.get(ulpV) + size.get(ulpU));
            parent.set(ulpU, ulpV);
        } else {
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
            parent.set(ulpV, ulpU);
        }
    }

    public void unionByRank(int u, int v) {
        int ulpU = findParent(u);
        int ulpV = findParent(v);
        if (ulpU == ulpV) {
            return;
        } else if (rank.get(ulpU) < rank.get(ulpV)) {
            parent.set(ulpU, ulpV);
        } else if (rank.get(ulpV) < rank.get(ulpU)) {
            parent.set(ulpV, ulpU);
        } else {
            parent.set(ulpV, ulpU);
            rank.set(ulpU, rank.get(ulpU) + 1);
        }
    }
}

class Main {
    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.unionBySize(1, 2);
        disjointSet.unionBySize(2, 3);
        disjointSet.unionBySize(4, 5);
        disjointSet.unionBySize(6, 7);
        disjointSet.unionBySize(5, 6);

        if (disjointSet.findParent(3) == disjointSet.findParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        disjointSet.unionBySize(3, 7);

        System.out.println(disjointSet.findParent(3) == disjointSet.findParent(7) ? "Same" : "Not Same");
    }
}
