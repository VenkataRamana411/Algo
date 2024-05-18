package Assignement;

import java.util.Scanner;

public class Solution {

    public static String solution(String S) {
        StringBuilder sb = new StringBuilder();
        boolean isCapsLock = false;

        for (char c : S.toCharArray()) {
            switch (c) {
                case 'B':
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    break;
                case 'C':
                    isCapsLock = !isCapsLock;
                    break;
                default:
                    if (isCapsLock) {
                        sb.append(Character.toUpperCase(c));
                    } else {
                        sb.append(Character.toLowerCase(c));
                    }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

        }
        String[] testCases = {"CrCellBax", "CgCoodIBCICuck", "aCaBBCCab", "aBB"};
        for (String testCase : testCases) {
            String result = solution(testCase);
            System.out.println("Input: " + testCase + ", Output: " + result);
        }
    }
}