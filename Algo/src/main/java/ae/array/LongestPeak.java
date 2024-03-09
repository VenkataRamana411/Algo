package ae.array;

public class LongestPeak {
    public static void main(String[] args) {
        int[] nums  = {5,4,3,2,1,2,1};
        System.out.println(longestPeakOptimal(nums));
        System.out.println(longestPeakOptimal(new int[]{1,2,3,3,4,0,10,6,5,-1,-3,2,3}));

    }
    public static int longestPeakOptimal(int[] array){
        //Find the peak by comparing adjacent values and then iterate through left and right
        int longestPeak = 0;
        for (int i = 1 ; i < array.length-1 ; i++){
            if (array[i] > array[i-1] && array[i] > array[i+1]){
                int j = i, count = 1;
                while (j >= 0 && array[j] > array[j-1]){
                    j--;
                    count++;
                }
                j = i;
                while (j < array.length-1 && array[j] > array[j+1]){
                    j++;
                    count++;
                }
                longestPeak = Math.max(longestPeak,count);
            }
        }
        return longestPeak;
    }

    public static int longestPeak(int[] array){
        if (array.length < 3){
            return 0;
        }
        int i = 0 , j = 1 , longestPeak = 0;
        boolean isPeakFound = false;
        while (j < array.length){
            if (isPeakFound){
                if (array[j] < array[j-1]){
                    j++;
                }else {
                    longestPeak = Math.max((j-i),longestPeak);
                    isPeakFound = false;
                    i = j-1;
                    j++;
                }
            }else {
                if (array[j] < array[j-1]){
                    i++;
                    j++;
                }else if (array[j] == array[j-1]){
                    j++;
                    i = j-1;
                }else {
                    isPeakFound = true;
                }
            }
        }
        return longestPeak;
    }
}
