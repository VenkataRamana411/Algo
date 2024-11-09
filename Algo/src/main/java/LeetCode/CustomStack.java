package LeetCode;

import java.util.Arrays;

public class CustomStack {
    int[] stack;
    int top = 0, size = 0;

    public CustomStack(int maxSize) {
        stack = new int[maxSize+1];
        Arrays.fill(stack,-1);
        size = maxSize;
    }

    public void push(int x) {
        if(top != size){
            stack[top++] = x;
        }
    }

    public int pop() {
        top--;
        if(top < 0 || stack[top] == -1){
            return -1;
        }
        int temp = stack[top];
        stack[top] = -1;
        return temp;
    }

    public void increment(int k, int val) {
        int idx = 0;
        while(k > 0 && idx < size){
            stack[idx] = stack[idx]+val;
            k--;
            idx++;
        }
    }
    static class Test{
        public static void main(String[] args) {
            CustomStack customStack = new CustomStack(3);
            customStack.push(1);
            customStack.push(2);
            System.out.println(customStack.pop());
            customStack.push(2);
            customStack.push(3);
            customStack.push(4);
            customStack.increment(5,100);
            customStack.increment(2,100);
            System.out.println(customStack.pop());
            System.out.println(customStack.pop());
            System.out.println(customStack.pop());
            System.out.println(customStack.pop());
        }
    }
}

