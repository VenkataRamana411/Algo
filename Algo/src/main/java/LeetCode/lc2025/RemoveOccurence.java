package LeetCode.lc2025;

public class RemoveOccurence {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc","abc"));
    }
    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)){
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
