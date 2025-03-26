package prep.graph.algo;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlights {
    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(findCheapestPrice(4,flights,0,3,1));
    }

    public static int findCheapestPrice(int n,int[][] flights,int src,int dst,int k){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[2],flight[1],0));
        }
        int[] diff = new int[n+1];
        Arrays.fill(diff,Integer.MAX_VALUE);
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((x,y) -> y.distance- x.distance);
        priorityQueue.add(new Pair(0,src,0));
        diff[src] = 0;
        while (!priorityQueue.isEmpty()){
            Pair curr = priorityQueue.poll();
            int distance = curr.distance;
            int currNode = curr.node;
            int stops = curr.stops;
            for (Pair pair : adj.get(currNode)){
                if (distance + pair.distance < diff[pair.node] && stops <= k){
                    diff[pair.node] = pair.distance + distance;
                    priorityQueue.add(new Pair(diff[pair.node],pair.node,stops + 1));
                }
            }
        }
        return diff[dst];
    }

    public static class Pair{
        int distance;
        int node;
        int stops;

        public Pair(int distance, int node, int stops) {
            this.distance = distance;
            this.node = node;
            this.stops = stops;
        }
    }
}
