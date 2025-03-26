package prep.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0,2}, {1, 2}, {2,0},{2,3},{3,3}};
        List<List<Integer>> adj = adjacencyList(4, edges);
        bfs(4,adj,1);

        System.out.println("-------------------------------------");
        int[][] edgesDisconnected = {{0, 1}, {0,2}, {1, 2}, {2,0},{2,3},{3,3},{5,4}};
        List<List<Integer>> adjDis = adjacencyList(6, edgesDisconnected);
        System.out.println(adjDis);
        boolean[] vis = new boolean[6];
        for (int i = 0; i < vis.length; i++){
            if (!vis[i]){
                bfsDis(adjDis,i,vis);
            }
        }
    }

    /**
     * TC: O(V+E)
     * SC:O(V)
    * */
    private static void bfs(int V,List<List<Integer>> adj,int source){
        boolean[] vis = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        vis[source] = true;
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            System.out.println(node);
           for (int next : adj.get(node)){
               if (!vis[next]){
                   queue.add(next);
                   vis[next] = true;
               }
           }
        }
    }

    /**
     * TC: O(V+E)
     * SC:O(V)
     * */
    private static void bfsDis(List<List<Integer>> adj, int source, boolean[] vis){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        vis[source] = true;
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            System.out.println(node);
            for (int next : adj.get(node)){
                if (!vis[next]){
                    queue.add(next);
                    vis[next] = true;
                }
            }
        }
    }
    private static List<List<Integer>> adjacencyList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }
}
