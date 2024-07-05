package striver.bs;

public class MBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        System.out.println(minDays(bloomDay,3,1));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = -1;
        for (int i : bloomDay) {
            high = Math.max(high, i);
        }
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int boques = 0;
            int count = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                while (i != bloomDay.length && bloomDay[i] <= mid) {
                    count++;
                    i++;
                }
                boques += (count / k);
                count = 0;
            }
            if (boques >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

}
