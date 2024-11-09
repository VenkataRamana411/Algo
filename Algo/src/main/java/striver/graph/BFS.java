package striver.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{1,6},{2,3},{2,4},{6,7},{6,9},{4,5},{7,8},{8,5}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i <= edges.length ; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
       // bfsHelper(9,adj);
        boolean[] vis = new boolean[edges.length + 1];
        //vis[1] = true;
        dfsHelper(vis,1,adj);
    }
    private static void bfsHelper(int n,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[n + 1];
        vis[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            System.out.println(node);
            for (Integer curr : adj.get(node)){
                if (!vis[curr]){
                    queue.add(curr);
                    vis[curr] = true;
                }
            }
        }
    }
    private static void dfsHelper(boolean[] vis,int node,ArrayList<ArrayList<Integer>> adj){
        if (vis[node]){
            return;
        }
        vis[node] = true;
        System.out.println(node);
        for (int curr: adj.get(node)){
            if (!vis[curr]){
                dfsHelper(vis,curr,adj);
            }
        }
    }
}
