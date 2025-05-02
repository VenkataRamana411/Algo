package target.stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemp(new int[]{65, 70, 68, 60, 55, 75, 80, 74})));
        System.out.println(Arrays.toString(dailyTemp(new int[]{65, 70, 68, 60, 55, 62, 80, 74})));
    }

    private static int[] dailyTemp(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int idx = -1;
        for (int i = 0; i < temperatures.length; i++) {
            //Check if stack is not empty and see weather current value is greater than value in the peek
            //In this case we need to update current index to index stored on stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.add(i);
        }
        return result;
    }
}
