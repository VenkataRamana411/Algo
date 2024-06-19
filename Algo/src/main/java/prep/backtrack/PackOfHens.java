package prep.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PackOfHens {
    public static void main(String[] args) {
        int[] eggs = {1, 7, 2, 0, 5, 6};
        int target =3;
//        for (int i = 0 ; i < eggs.length ; i++){
//            System.out.println("i="+i+" : "+helper(eggs,target,i));
//        }
        System.out.println(helper(eggs, target, 0));
        System.out.println(helper2(eggs, target, 0, new ArrayList<>()));
    }

    private static boolean helper(int[] eggs, int target, int index) {
        if (index >= eggs.length || target < 0) {
            return false;
        }
        //target -= eggs[index];
        if (target == 0) {
            return true;
        }
        return helper(eggs, target, index + 1)
                || helper(eggs, target - eggs[index], index + 1);
    }

    private static boolean helper2(int[] eggs, int target, int index, List<Integer> nums) {
        if (index >= eggs.length || target < 0) {
            return false;
        }
        nums.add(eggs[index]);
        target -= eggs[index];
        System.out.println(nums + " : " + " Target: " + target);
        if (target == 0) {
            return true;
        }
        boolean include = helper2(eggs, target, index + 1, nums);
        nums.remove(nums.size() - 1);
        boolean exclude = helper2(eggs, target + eggs[index], index + 1, nums);
        return include || exclude;
    }

}
