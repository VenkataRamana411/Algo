package LeetCode;

public class FindJudge {
    public static void main(String[] args) {
        int[][] trust = {{1,3},{2,3},{2,1}};
        System.out.println(findJudge(3,trust));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] result = new int[n+1];
        for(int[] set : trust){
            result[set[0]] = -1;
            if (result[set[1]] != -1){
                result[set[1]]++;
            }
        }
        for(int i = 0 ; i < result.length ; i++){
            if(result[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
