package striver.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) throws IOException {
        int V = 3, E = 3, S = 2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{
            add(2);
            add(6);
        }};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{
            add(2);
            add(3);
        }};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{
            add(0);
            add(1);
        }};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{
            add(1);
            add(3);
        }};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{
            add(0);
            add(6);
        }};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>() {
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
        //add final values of adj here.
        Solution obj = new Solution();
        int[] res = obj.dijkstra(V, adj, S);

        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        ArrayList<ArrayList<Integer[]>> adjacency = Graph.buildWeightedGraph(5, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}, {2, 5}, {2, 4}, {3, 5}, {4, 5}}, new int[]{4, 4, 2, 3, 6, 1, 2, 3});
        int[] dijkstra2 = obj.dijkstra2(6, adjacency, 0);
        for (int i = 0; i < 6; i++) {
            System.out.print(dijkstra2[i] + " ");
        }
    }
}

class Solution {
    public int[] dijkstra(int vertices, ArrayList<ArrayList<ArrayList<Integer>>> adj, int source){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        pq.add(new Pair(0,0));
        while (!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0 ; i < adj.get(node).size(); i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (dis + edgeWeight < distance[adjNode]){
                    distance[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        return distance;
    }
    public int[] dijkstra2(int vertices, ArrayList<ArrayList<Integer[]>> adj, int source){
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        pq.add(new Pair(0,0));
        while (!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0 ; i < adj.get(node).size(); i++){
                int edgeWeight = adj.get(node).get(i)[1];
                int adjNode = adj.get(node).get(i)[0];
                if (dis + edgeWeight < distance[adjNode]){
                    distance[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        return distance;
    }
}
