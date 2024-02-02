package prep.string;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqCharOptimal(String s) {
        int minIdx = Integer.MAX_VALUE;
        //Iterate through lowercase
        for (char c = 'a' ; c <= 'z' ; c++){
            int firstIdx = s.indexOf(c);
            //Check if first and last index of character is same
            if (firstIdx != -1 && firstIdx == s.lastIndexOf(c)){
                minIdx = Math.min(minIdx,firstIdx);
            }
        }
        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }
    public static int firstUniqChar(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        int minIdx = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (chars[i] == 1) {
                //int temp = s.indexOf((char) i + 97);
                //System.out.println(temp);
                minIdx = Math.min(minIdx, s.indexOf((char) i + 97));
                //System.out.println((char)(i+97));
            }
        }
        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }
}
