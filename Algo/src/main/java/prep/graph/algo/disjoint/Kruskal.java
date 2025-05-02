package prep.graph.algo.disjoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static void main(String[] args) {

    }

    private static int KruskalAlgo(ArrayList<ArrayList<Integer[]>> adjacencyList, int V) {
        List<Pair> edges = new ArrayList<>();
        //O(N+E)
        for (int i = 0; i < V; i++) {
            for (Integer[] adj : adjacencyList.get(i)) {
                edges.add(new Pair(adj[1], adj[0], i));
                //No need to add alternative edge as anyway it can be discarded by DisjointSet
            }
        }
        DisjointSet disjointSet = new DisjointSet(V);
        //Log(M)
        Collections.sort(edges);
        int mstWt = 0;
        for (Pair edge : edges) {
            if (disjointSet.findParent(edge.node) != disjointSet.findParent(edge.parent)) {
                mstWt += edge.weight;
                disjointSet.unionBySize(edge.node, edge.parent);
            }
        }
        return mstWt;
    }

}

class Pair implements Comparable<Pair> {
    int weight;
    int node;
    int parent;

    public Pair(int weight, int node, int parent) {
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }

    @Override
    public int compareTo(Pair pair) {
        return this.weight - pair.weight;
    }
}
