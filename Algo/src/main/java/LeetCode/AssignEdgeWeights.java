package LeetCode;

import java.util.*;

public class AssignEdgeWeights {
    public static void main(String[] args) {

    }

    public int assignEdgeWeights(int[][] edges) {
        int[] depthArray = new int[100001];
        int maxDepth = -1;
        for (int[] edge : edges) {
            depthArray[edge[1]] = depthArray[edge[0]] + 1;
            if (depthArray[edge[1]] > maxDepth) {
                maxDepth = depthArray[edge[1]];
            }
        }
        maxDepth--;
        int mod = 1_000_000_007, base = 2;
        long res = 1;
        while (maxDepth > 0) {
            if (maxDepth % 2 == 1) res = (res * base) % mod;
            base = (int) (((long) base * base) % mod);
            maxDepth /= 2;
        }
        return (int) res;
        //return (int) Math.pow(2, curr - 1);
        //return curr;
    }
    //        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        for (int depth : depthArray){
//            hashMap.putIfAbsent(depth)
//        }

    public int assignEdgeWeights2(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int maxDepth = 0;
        boolean[] visited = new boolean[n + 1];
        int[] depth = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int node : graph.get(currNode)) {
                if (!visited[node]) {
                    visited[node] = true;
                    depth[node] = depth[currNode] + 1;
                    maxDepth = Math.max(maxDepth, depth[node]);
                    queue.add(node);
                }
            }
        }
        maxDepth--;
        int mod = 1_000_000_007, base = 2;
        long res = 1;
        while (maxDepth > 0) {
            if (maxDepth % 2 == 1) res = (res * base) % mod;
            base = (int) (((long) base * base) % mod);
            maxDepth /= 2;
        }
        return (int) res;
    }

    private int power(int base, int exp, int mod) {
        long res = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * b) % mod;
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) res;
    }


}
