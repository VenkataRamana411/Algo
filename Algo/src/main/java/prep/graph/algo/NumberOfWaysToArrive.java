package prep.graph.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWaysToArrive {
    public static void main(String[] args) {
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        System.out.println(countPaths(7, roads));
    }

    public static int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        int shortestTime = Integer.MAX_VALUE;
        int result = 0;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[2], road[1]));
            adj.get(road[1]).add(new Pair(road[2], road[0]));
        }
        int[] diff = new int[n + 1];
        Arrays.fill(diff, Integer.MAX_VALUE);
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((x, y) -> y.distance - x.distance);
        priorityQueue.add(new Pair(0, 0));
        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.poll();
            int currDistance = curr.distance;
            int currNode = curr.node;
            for (Pair pair : adj.get(currNode)) {
                if (pair.distance + currDistance <= diff[pair.node]) {
                    diff[pair.node] = pair.distance + currDistance;
                    if (pair.node == n - 1) {
                        if (diff[n - 1] < shortestTime) {
                            result = 1;
                            shortestTime = diff[n - 1];
                        } else if (diff[n - 1] == shortestTime) {
                            result = (result  + 1) % mod;
                        }
                    } else {
                        priorityQueue.add(new Pair(diff[pair.node], pair.node));
                    }
                }
            }
        }
        return result;
    }

    private static class Pair {
        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
}
