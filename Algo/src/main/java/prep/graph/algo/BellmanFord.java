package prep.graph.algo;

import lld.patterns.decorator.Beverage;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    /**
     * Works only on Directed Graphs
     * Define both directions in case of UDG
     * Iterate over N-1 times to get final answer assuming source is the last edge to be computed
     * If distance getting reduced in Nth iteration that means there exists a negative cycle
    * */

    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };
        int[] dist = bellman_ford(V, edges, 0);
        System.out.println(Arrays.toString(dist));
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S] = 0;
        for (int i = 0; i < V-1; i++){
            for (ArrayList<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int distance = edge.get(2);
                if (dist[u] != Integer.MAX_VALUE && dist[u]+distance < dist[v]){
                    dist[v] = dist[u] + distance;
                }
            }
        }
        for (ArrayList<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int distance = edge.get(2);
            //If satisfied then there exists a negative edge
            if (dist[u] != Integer.MAX_VALUE && dist[u]+distance < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }

}
