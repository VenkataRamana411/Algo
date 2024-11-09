package ae.stack;

import java.util.Arrays;
import java.util.Stack;

public class CollidingAsteroids {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(collidingAsteroids(new int[]{-3, 5, -8, 6, 7, -4, -7})));
    }

    public static int[] collidingAsteroids(int[] asteroids) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        boolean lastDir = asteroids[0] > 0;
        for (int i = 1; i < asteroids.length; i++) {
            boolean currDir = asteroids[i] > 0;
            if (lastDir != currDir) {
                stack.push(asteroids[i]);
            } else {
                int curr = Math.abs(asteroids[i]);
                int top = Math.abs(stack.peek());
                if (curr > top) {
                    stack.pop();
                    stack.push(asteroids[i]);
                    lastDir = currDir;
                } else if (curr == top) {
                    stack.pop();
                    lastDir = stack.peek() > 0;
                }
            }
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
}
