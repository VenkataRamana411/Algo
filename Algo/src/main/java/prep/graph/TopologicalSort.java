package prep.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        int[][] edges = new int[][]{{5,0},{4,0},{5,2},{2,3},{3,1},{4,1}};
        System.out.println(Arrays.toString(topologicalSort.topSort(edges)));
//        int[][] edges2 = new int[][]{{0,1},{0,2},{2,3},{3,4}};
//        System.out.println(Arrays.toString(topologicalSort.topSort(edges2)));
    }

    /**
     * TC: O(V+E)
     * SC: O(N)
    * */
    private int[] topSort(int[][] edges){
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int V = edges.length;
        for (int i = 0; i < V; i++){
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
        }
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>(); // Stack to store LIFO order
        for (int i = 0; i< V; i++){ // Iterate node by node
            if (vis[i] == 0){
                dfs(adjacencyList,stack,vis,i);
            }
        }
        int[] result = new int[V];
        int k = 0;
        while (!stack.isEmpty()){
            result[k++] = stack.pop();
        }
        return result;
    }

    /**
     * Mark, Iterate then Push to Stack in DFS
    * */
    private void dfs(List<List<Integer>> adjacencyList, Stack<Integer> stack, int[] vis, int currNode){
        vis[currNode] = 1;
        for (int node : adjacencyList.get(currNode)){
            if (vis[node] == 0){
                dfs(adjacencyList,stack,vis,node);
            }
        }
        stack.add(currNode);
    }
}
