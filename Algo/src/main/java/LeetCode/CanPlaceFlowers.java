package LeetCode;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0, 1, 0}, 1));
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len > 1) {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                n--;
                flowerbed[0] = 2;
            }
            int i = 1;
            for (; i < len - 1 && n > 0; i++) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i +  1] == 0) {
                    flowerbed[i] = 2;
                    n--;
                }
            }
            if (flowerbed[i] == 1 && flowerbed[i - 1] == 2) {
                return false;
            } else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 2;
                n--;
            }
        } else {
            if (flowerbed[0] == 0) {
                n--;
                flowerbed[0] = 2;
            }
        }
        return n <= 0;
    }
}
