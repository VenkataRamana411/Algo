package prep.graph.algo;

import striver.graph.Graph;
import striver.graph.Pair;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer[]>> adjacencyList = Graph.buildWeightedGraph(5, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}, {2, 5}, {2, 4}, {3, 5}, {4, 5}}, new int[]{4, 4, 2, 3, 6, 1, 2, 3});
        priorityQueueBased(adjacencyList,6,0);
        ArrayList<ArrayList<Pair>> adjacencyList2 = Graph.buildWeightedGraphPair(5, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}, {2, 5}, {2, 4}, {3, 5}, {4, 5}}, new int[]{4, 4, 2, 3, 6, 1, 2, 3});
        printPath(adjacencyList2,6,0,5);
    }

    /**
     * TC: O(E * log V)
     * SC: O(V)
    * */
    private static void priorityQueueBased(ArrayList<ArrayList<Integer[]>> adjacencyList,int V,int source){
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int[] dis = new int[V];
        //Initialize everything to MAX
        Arrays.fill(dis,Integer.MAX_VALUE);
        //Source to Source is always zero
        dis[source] = 0;
        priorityQueue.add(new Pair(0,source));
        while (!priorityQueue.isEmpty()){
            Pair curr = priorityQueue.poll();
            int currNode = curr.node;
            int currDistance = curr.distance;
            //Node 0 : {4,1},{4,2}
            //Loop through connected nodes if we have get better distance through a middle node
            for (int i = 0 ; i < adjacencyList.get(currNode).size(); i++){
                Integer adjNode = adjacencyList.get(currNode).get(i)[0];
                Integer adjDistance = adjacencyList.get(currNode).get(i)[1];
                //If currentNodeDistance + edgeWeight > actual Distance found till now then replace it with minimum
                if (currDistance + adjDistance < dis[adjNode]){
                    dis[adjNode] = currDistance + adjDistance;
                    priorityQueue.add(new Pair(dis[adjNode],adjNode));
                }
            }
        }
        System.out.println(Arrays.toString(dis));
    }

    private static void printPath(ArrayList<ArrayList<Pair>> adjacencyList,int V,int source,int destination){
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int[] dis = new int[V];
        int[] parent = new int[V];
        for (int i = 0; i < V; i++){
            Arrays.fill(dis,Integer.MAX_VALUE);
            parent[i] = i;
        }
        //Source to Source is always zero
        dis[source] = 0;
        priorityQueue.add(new Pair(0,source));
        while (!priorityQueue.isEmpty()){
            Pair curr = priorityQueue.poll();
            int currNode = curr.node;
            int currDistance = curr.distance;
            //Node 0 : {4,1},{4,2}
            //Loop through connected nodes if we have get better distance through a middle node
            for (Pair pair : adjacencyList.get(currNode)){
                int adjNode = pair.node;
                int adjDistance = pair.distance;
                //If currentNodeDistance + edgeWeight > actual Distance found till now then replace it with minimum
                if (currDistance + adjDistance < dis[adjNode]){
                    dis[adjNode] = currDistance + adjDistance;
                    priorityQueue.add(new Pair(dis[adjNode],adjNode));
                    parent[adjNode] = currNode;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dis[V-1] == Integer.MAX_VALUE){
            path.add(-1);
            System.out.println(path);
        }
        int node = V-1;
        while (parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(0);
        Collections.reverse(path);
        System.out.println(path);
    }
}
