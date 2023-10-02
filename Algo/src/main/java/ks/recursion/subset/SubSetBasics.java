package ks.recursion.subset;

import java.util.ArrayList;
import java.util.List;

public class SubSetBasics {
    public static void main(String[] args) {
        //printCombination("", "abc");
        List<String> stringList = new ArrayList<>();
        //addToList("","abc",stringList);
        List<String> stringList1 = returnList("", "abc", stringList);
        System.out.println(stringList1);
    }

    private static void printCombination(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        printCombination(p + ch, up.substring(1));
        printCombination(p, up.substring(1));
    }

    private static void addToList(String p, String up, List<String> result) {
        if (up.isEmpty()) {
            result.add(p);
            return;
        }
        char ch = up.charAt(0);
        addToList(p + ch, up.substring(1), result);
        addToList(p, up.substring(1), result);
    }
    private static List<String> returnList(String p, String up, List<String> result) {
        if (up.isEmpty()) {
            result.add(p);
            return result;
        }
        char ch = up.charAt(0);
        returnList(p + ch, up.substring(1), result);
        returnList(p, up.substring(1), result);
        return result;
    }
    private static void printSubSequences(int[] nums){

    }
}
