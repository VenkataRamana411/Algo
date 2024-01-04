package LeetCode;

public class LaserBeamInBank {
    public static void main(String[] args) {
        String[] bank = new String[]{"011001", "000000", "010100", "001000"};
        System.out.println(numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int result = 0, prev = 0;
        for (String row : bank) {
            int curr = 0;
            for (char c : row.toCharArray()) {
                curr += c - '0';
            }
            if (curr != 0) {
                result += (curr * prev);
                prev = curr;
            }
        }
        return result;
    }
}
