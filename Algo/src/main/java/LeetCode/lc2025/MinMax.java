package LeetCode.lc2025;

public class MinMax {
    public static void main(String[] args) {
        System.out.println(minMaxDifference(5964654));
    }
    public static int minMaxDifference(int num) {
        String s1 = String.valueOf(num);
        char max = s1.charAt(0);
        char min = s1.charAt(0);
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != '9'){
                max = s1.charAt(i);
                break;
            }
        }
        return Integer.parseInt(s1.replace(max,'9')) - Integer.parseInt(s1.replace(min,'0'));
    }
}
