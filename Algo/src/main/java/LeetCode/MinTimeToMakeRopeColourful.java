package LeetCode;

public class MinTimeToMakeRopeColourful {
    public static void main(String[] args) {
        int[] neededTime = new int[]{3,5,10,7,5,3,5,5,4,8,1};
        String colors = "aaabbbabbbb";
        System.out.println(minCost(colors,neededTime));
        System.out.println(minCostApproach2(colors,neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        int result = 0;
        //3,5,10,7,5,3,5,5,4,8,1
        //a a a  b b b a b b b b
        for(int i = 0 , j = 1 ; j < colors.length();j++){
            if(colors.charAt(i) == colors.charAt(j)){
                if(neededTime[i] > neededTime[j]){
                    result +=neededTime[j];
                }else {
                    result +=neededTime[i];
                    i = j;
                }
            }else{
                i = j;
            }
        }
        return result;
    }
    public static int minCostApproach2(String colors, int[] neededTime) {
        int result = 0, chunkSum = neededTime[0] , chunkMax = neededTime[0] ;
        char tempChar = colors.charAt(0);
        for(int i = 1; i < colors.length() ;i++){
            if(colors.charAt(i) == tempChar){
                chunkSum += neededTime[i];
                if(neededTime[i] > chunkMax){
                    chunkMax =neededTime[i];
                }
            }else{
                tempChar = colors.charAt(i);
                result += (chunkSum - chunkMax);
                chunkSum = neededTime[i];
                chunkMax = neededTime[i];
            }
            if (i == colors.length()-1){
                result += (chunkSum - chunkMax);
            }
        }
        return result;
    }
    public static int minCostApproach3(String colors, int[] neededTime) {
        char[] strColors = colors.toCharArray();
        int minTime=0;
        for(int i=0;i<strColors.length-1;i++){
            if(strColors[i]==strColors[i+1]){
                if(neededTime[i]<=neededTime[i+1]){
                    minTime+=neededTime[i];
                    neededTime[i]=0;
                }
                else{
                    minTime+=neededTime[i+1];
                    neededTime[i+1]=neededTime[i];
                }
            }
        }
        return minTime;
    }

}
