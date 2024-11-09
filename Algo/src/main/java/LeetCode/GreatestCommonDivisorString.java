package LeetCode;

public class GreatestCommonDivisorString {
    public static void main(String[] args) {

    }

    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str1.length() && i < str2.length(); i++){
            if(str1.charAt(i) == str2.charAt(i)){
                sb.append(str1.charAt(i));
            }else{
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
