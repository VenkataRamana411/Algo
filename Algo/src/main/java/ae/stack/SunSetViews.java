package ae.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SunSetViews {
    public static void main(String[] args) {
        System.out.println(sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "east"));
        System.out.println(sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "west"));
    }

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        int n = buildings.length;
        Stack<Integer> buildingStack = new Stack<>();
        if (direction.equals("east")) {
            buildingStack.push(n - 1);
            for (int i = n - 2; i >= 0; i--) {
                if (buildings[i]> buildings[buildingStack.peek()]){
                    buildingStack.push(i);
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            while (!buildingStack.isEmpty()){
                result.add(buildingStack.pop());
            }
            return result;
        }else {
            buildingStack.push(0);
            for (int i = 1; i < n; i++) {
                if (buildings[i]> buildings[buildingStack.peek()]){
                    buildingStack.push(i);
                }
            }
            return new ArrayList<Integer>(buildingStack);
        }
    }
}
