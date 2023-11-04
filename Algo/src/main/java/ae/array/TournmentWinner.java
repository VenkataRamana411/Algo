package ae.array;

import java.util.*;

public class TournmentWinner {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> input = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("HTML");
        strings1.add("C#");
        input.add(strings1);
        ArrayList<String> strings2 = new ArrayList<>();
        strings2.add("HTML");
        strings2.add("Python");
        input.add(strings2);
        ArrayList<String> strings3 = new ArrayList<>();
        strings3.add("Python");
        strings3.add("HTML");
        input.add(strings3);
        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);
        System.out.println(tournamentWinner(input,results));
    }
    private static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        Map<String,Integer> result = new HashMap<>();
        int index = 0;
        String ans = "";
        for (ArrayList list : competitions){
            String team1 = (String) list.get(0);
            String team2 = (String) list.get(1);
            if (!result.containsKey(team1)){
                result.put(team1,0);
            }
            if (!result.containsKey(team2)){
                result.put(team2,0);
            }
            if (results.get(index++) == 1){
                result.compute(team1,(k, v) -> v + 3);
                if (result.get(team1) > result.getOrDefault(ans,0)){
                    ans = team1;
                }
            }else {
                result.compute(team2,(k, v) -> v + 3);
                if (result.get(team2) > result.getOrDefault(ans,0)){
                    ans = team2;
                }
            }
        }
        return ans;
    }
}
