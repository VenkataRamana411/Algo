package prep.array.assign;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(summaryRangesOptimal2(nums));
    }

    public static List<String> summaryRangesOptimal(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length;i++) {
            int start = nums[i];
          while (i+1 < nums.length && nums[i]+1==nums[i+1]){
              i++;
          }
          if (start != nums[i]){
              result.add(start+"->"+nums[i]);
          }else {
              result.add(""+start);
          }
        }
        return result;
    }
    public static List<String> summaryRangesOptimal2(int[] nums) {
        ArrayList<String> al=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int start=nums[i];
            while(i+1<nums.length && nums[i]+1==nums[i+1])
                i++;

            if(start!=nums[i]){
                al.add(""+start+"->"+nums[i]);
            }
            else{
                al.add(""+start);
            }
        }
        return al;
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        String temp = String.valueOf(nums[0]);
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start != end) {
                    temp += "->";
                    temp += end;
                }
                result.add(temp);
                temp = String.valueOf(nums[i]);
                start = nums[i];
                end = nums[i];
            } else {
                end++;
            }
        }
        if (start != end) {
            temp += "->";
            temp += end;
        }
        result.add(temp);
        return result;
    }
}
