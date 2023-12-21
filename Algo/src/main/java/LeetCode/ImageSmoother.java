package LeetCode;

public class ImageSmoother {
    public static void main(String[] args) {

    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int sum = 0;
                int count = 0;
                for (int x = row - 1; x <= row + 1; x++) {
                    if (x < 0 || x >= m) {
                        continue;
                    }
                    for (int y = col - 1; y <= col + 1; y++) {
                        if (y >= 0 && y < n) {
                            sum += img[x][y];
                            count++;
                        }
                    }
                }
                result[row][col] = sum / count;
            }
        }
        return result;
    }
}
