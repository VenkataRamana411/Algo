package prep.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperaturesOptimized(temperatures)));
        System.out.println(Arrays.toString(dailyTemperaturesTutor(temperatures)));
    }

    public static int[] dailyTemperaturesTutor(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int idx = -1;
        for (int i = 0; i < temperatures.length; i++) {
            //Check if stack is not empty and see weather current value is greater than value in the peek
            //In this case we need to update current index to index stored on stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                idx = stack.pop();
                result[idx] = i-idx;
            }
            stack.add(i);
        }
        return result;
    }

    public static int[] dailyTemperaturesOptimized(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int hottest = -1;
        for (int i = temperatures.length - 1; i >= 0; i--) {
            //Am I the hottest, if yes update. If not find out
            if (temperatures[i] >= hottest) {
                hottest = temperatures[i];
                continue;
            }
            // Why 1 because we need to start comparing from right neighbour
            int days = 1;
            //Use result of neighbour to quickly find the hottest
            while (temperatures[i + days] <= temperatures[i]) {
                days += result[i + days];
            }
            result[i] = days;
        }
        return result;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.empty()) {
                result[i] = stack.peek() - i;
            }
            stack.push(i);

        }
        return result;
    }

}
