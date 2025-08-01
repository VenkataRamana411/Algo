package prep.graph;

import java.util.*;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        TopologicalSortBFS topologicalSort = new TopologicalSortBFS();
        int[][] edges = new int[][]{{5,0},{4,0},{5,2},{2,3},{3,1},{4,1}};
        System.out.println(Arrays.toString(topologicalSort.topSort(edges,6)));
        int[][] edges2 = new int[][]{{0,1},{0,2},{2,3},{3,4}};
        System.out.println(Arrays.toString(topologicalSort.topSort(edges2,5)));
    }

    /**
     * TC: O(V+E)
     * SC: O(N)
    * */
    private int[] topSort(int[][] edges,int V){
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++){
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < inDegree.length; i++){ //InDegree of 0 Means no more dependencies
            if (inDegree[i] == 0){
                priorityQueue.add(i);
            }
        }
        int[] result = new int[V];
        int k = 0;
        while (!priorityQueue.isEmpty()){
            Integer currNode = priorityQueue.poll();
            result[k++] = currNode;
            for (int node : adjacencyList.get(currNode)){
                inDegree[node]--;
                if (inDegree[node] == 0){  //Iterate and reduce inDegree to zero to add it into sorted order
                    priorityQueue.add(node);
                }
            }
        }
        return result;
    }

}
