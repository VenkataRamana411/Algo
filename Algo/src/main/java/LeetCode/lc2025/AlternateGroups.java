package LeetCode.lc2025;

public class AlternateGroups {
    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,1,0},3));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, left = 0, prevCol = colors[0], result = 0;
        for(int right = 1; right < n; right++){
            if (colors[right%n] != prevCol){
                if (right-left+1 == k){
                    result++;
                    left++;
                }
            }else {
                left = right;
            }
            prevCol = colors[right%n];
        }
        return result;
    }
}
