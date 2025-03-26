package prep.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Representation {
    public static void main(String[] args) {
        int[] vertices = {0, 1, 2, 3, 4};
        int[][] edges = {{0, 1}, {1, 2}, {0, 3}, {1,4},{3,4}};
        adjacencyMatrix(vertices,edges);
        adjacencyList(vertices,edges);
    }

    private static void adjacencyMatrix(int[] vertices, int[][] edges) {
        int v = vertices.length;
        int[][] adj = new int[v][v];
        for (int[] edge : edges){
            adj[edge[0]][edge[1]] = 1;
            adj[edge[1]][edge[0]] = 1;
        }
        System.out.println(Arrays.deepToString(adj));
    }

    public static void adjacencyList(int[] vertices, int[][] edges) {
        int v = vertices.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            //adj.get(edge[1]).add(edge[0]);
        }
        System.out.println(adj);
    }
}
