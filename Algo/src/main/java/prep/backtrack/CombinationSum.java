package prep.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {7,2,6,5};
        int target = 16;
        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        //helper(candidates, 0,target,new ArrayList<>(), result);
        backTrack(candidates, 0,target,new ArrayList<>(), result);
        System.out.println(result);
        return result;
    }

    private static void helper(int[] candidates,int index, int target, List<Integer> combination, List<List<Integer>> result) {
        if (index == candidates.length || target < 0){
            return;
        }
        if (target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        if (candidates[index] <= target){
            combination.add(candidates[index]);
            helper(candidates,index,target-candidates[index],combination,result);
            combination.remove(combination.size()-1);
        }
        helper(candidates,index+1,target,combination,result);
    }

    private static void backTrack(int[] candidates,int index, int target, List<Integer> combination, List<List<Integer>> result) {
        if (target < 0){
            return;
        }else if (target == 0){
            result.add(new ArrayList<>(combination));
        }else {
            for (int i = index ; i < candidates.length; i++){
                combination.add(candidates[i]);
                backTrack(candidates,i,target-candidates[i],combination,result);
                combination.remove(combination.size()-1);
            }
        }
    }
}
