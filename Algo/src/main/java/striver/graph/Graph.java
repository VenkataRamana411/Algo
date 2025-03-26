package striver.graph;

import java.util.ArrayList;

public class Graph {
    public static void main(String[] args) {
        buildGraph(5,new int[][]{{1,2},{1,3},{2,4},{3,4},{2,5},{4,5}});
        buildWeightedGraph(5,new int[][]{{1,2},{1,3},{2,4},{3,4},{2,5},{4,5}},new int[]{1,2,3,4,5,6});
        buildWeightedGraph(5,new int[][]{{0,1},{0,2},{1,2},{2,3},{2,5},{2,4},{3,5},{4,5}},new int[]{4,4,2,3,6,1,2,3});
    }

    private static void buildGraph(int n, int[][] edges){
        /** 1 based index **/
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); //one directed graph don't have this step
        }
        System.out.println(adj);
    }

    public static ArrayList<ArrayList<Integer[]>> buildWeightedGraph(int n, int[][] edges, int[] weights){
        /** 1 based index **/
        ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>();
        for (int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        int i = 0;
        for (int[] edge : edges){
            adj.get(edge[0]).add(new Integer[]{edge[1],weights[i]});
            adj.get(edge[1]).add(new Integer[]{edge[0],weights[i]}); //one directed graph don't have this step
            i++;
        }
        return adj;
    }

    public static ArrayList<ArrayList<Pair>> buildWeightedGraphPair(int n, int[][] edges, int[] weights){
        /** 1 based index **/
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        int i = 0;
        for (int[] edge : edges){
            adj.get(edge[0]).add(new Pair(weights[i],edge[1]));
            adj.get(edge[0]).add(new Pair(weights[i],edge[0])); //one directed graph don't have this step
            i++;
        }
        return adj;
    }

//    public static ArrayList<ArrayList<ArrayList<Integer>>> buildWeightedGraphList(int n, int[][] edges, int[] weights){
//        /** 1 based index **/
//        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
//        for (int i = 0 ; i <= n ; i++){
//            adj.add(new ArrayList<>());
//        }
//        int i = 0;
//        for (int[] edge : edges){
//            adj.get(edge[0]).add(new ArrayList<Integer>(){{add(edge[1]); add(weights[i]);}});
//            adj.get(edge[0]).add(new ArrayList<Integer>(){{add(edge[1]); add(weights[i]);}});
//            i++;
//        }
//        System.out.println(adj);
//        return adj;
//    }

}
