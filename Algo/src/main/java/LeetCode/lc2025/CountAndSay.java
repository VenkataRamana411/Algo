package LeetCode.lc2025;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(1));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = "";
        String input = "1";
        for (int i = 1; i < n; i++) {
            result = buildString(mapper(input));
            input = result;
        }
        return result;
    }


    // 223314444411
    //[2,2],[3,3],[1,1],[4,4],[1,1]
    private List<Integer[]> mapper(String input) {
        List<Integer[]> resultList = new ArrayList<>();
        char prev = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (prev == input.charAt(i)) {
                count++;
            } else {
                resultList.add(new Integer[]{prev - '0', count});
                prev = input.charAt(i);
                count = 1;
            }
        }
        resultList.add(new Integer[]{prev - '0', count});
        return resultList;
    }

    private String buildString(List<Integer[]> mapperList) {
        StringBuilder sb = new StringBuilder();
        for (Integer[] input : mapperList) {
            sb.append(input[1]).append(input[0]);
        }
        return sb.toString();
    }
}
