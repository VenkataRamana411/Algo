package LeetCode;

import java.util.Arrays;

public class AssignCookie {
    public static void main(String[] args) {
        int[] g =new int[]{1,2};
        int[] s = new int[]{1,2,3};
        System.out.println(findContentChildren(g,s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        for(int i = 0 , j = 0 ; i < g.length && j < s.length ; j++){
            if(g[i] <= s[j]){
                result++;
                i++;
            }
        }
        return result;
    }
}
