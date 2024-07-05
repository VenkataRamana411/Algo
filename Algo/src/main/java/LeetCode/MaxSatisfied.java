package LeetCode;

public class MaxSatisfied {
    public static void main(String[] args) {
        int[] customers = {4,10,10};
        int[] grumpy = {1,1,0};
        //System.out.println(maxSatisfied(customers,grumpy,2));

        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int i = 0;
        int curWin = 0;
        int maxWin = 0;

        for(int j=0;j<n;j++) {
            curWin+=customers[j] * grumpy[j];
            maxWin = Math.max(curWin, maxWin);
            if(j >= minutes - 1 ) {
                curWin -= customers[i] * grumpy[i++];
            }
        }
        int res = maxWin;
        for(i=0;i<grumpy.length;i++) {
            res+=customers[i] * (1 - grumpy[i]);
        }
        return res;
        /*int n = customers.length;
        int tempSum = 0 ,  maxSum = 0, maxIdx = 0 , result = 0;
        for(int i = 0 , j = 0 ; j < n; j++){
            if(j-i < minutes){
                tempSum += customers[j];
            }else{
                tempSum += (customers[j] - customers[i++]);
            }
            if(tempSum > maxSum){
                maxSum = tempSum;
                maxIdx = i;
            }
        }
        for(int i = maxIdx; i < maxIdx + minutes ; i++){
            grumpy[i] = 1;
        }
        for(int i = 0 ; i < n ; i++){
            if(grumpy[i] == 1){
                result += customers[i];
            }
        }
        return result;*/
    }
}
