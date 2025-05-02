package prep.graph.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2},{0,2,1},{1,2,1},{2,4,2},{2,3,2},{4,3,1}};
        // Create the adjacency list (ArrayList of ArrayLists of Integer[] for node connections)
        ArrayList<ArrayList<Integer[]>> adjacencyList = new ArrayList<>();

        // Initialize the adjacency list with empty ArrayLists
        for (int i = 0; i < 5; i++) { // 5 nodes in the graph
            adjacencyList.add(new ArrayList<>());
        }

        // Process the matrix and fill the adjacency list
        for (int[] edge : matrix) {
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];

            // Add the edge from node1 to node2
            adjacencyList.get(node1).add(new Integer[] {node2, weight});

            // Add the edge from node2 to node1 (since it's an undirected graph)
            adjacencyList.get(node2).add(new Integer[] {node1, weight});
        }
        prims(adjacencyList);
    }

    /**
     * Maintain PQ with weight,node & Parent along with visited array
     * Works as Greedy
     * TC: O(E)
    * */
    private static void prims(ArrayList<ArrayList<Integer[]>> adjacencyList){
        //PQ ensure we will get minimumSpanningTree
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        boolean[] vis = new boolean[5];
        priorityQueue.add(new Pair(0,0,-1));
        int result = 0;
        List<Integer[]> mst = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            Pair curr = priorityQueue.poll();
            int currentNode = curr.node;
            //If visited skip it as it's already been in MST
            if (vis[currentNode]) {
                continue;
            }
            vis[currentNode] = true;
            //Skip for root where parent is -1
            if (curr.parent != -1){
                result += curr.weight;
                mst.add(new Integer[]{currentNode,curr.parent});
            }
            for (Integer[] edge  :adjacencyList.get(currentNode)){
                Integer node = edge[0];
                Integer distance = edge[1];
                if (!vis[node]){
                    priorityQueue.add(new Pair(distance,node, currentNode));
                }
            }
        }
        System.out.println(result);
        System.out.println(mst);
    }

    private static class Pair{
        int weight;
        int node;
        int parent;
        public Pair(int weight, int node, int parent) {
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }
}
