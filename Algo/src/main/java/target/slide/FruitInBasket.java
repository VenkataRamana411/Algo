package target.slide;

import java.util.HashMap;
import java.util.Map;

public class FruitInBasket {
    public static void main(String[] args) {
        System.out.println(fruitsInBasket(new int[]{3, 3, 2, 1, 2, 1, 0}));
        System.out.println(fruitsInBasket(new int[]{3, 3, 2, 3, 1, 2, 1, 1, 1, 1}));
    }

    private static int fruitsInBasket(int[] fruits) {
        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(fruits[0], 1);
        int result = 0;
        int lIdx = 0, rIdx = 1;
        while (rIdx < fruits.length) {
            hmap.put(fruits[rIdx], hmap.getOrDefault(fruits[rIdx], 0) + 1);
            if (hmap.size() > 2) {
                result = Math.max(result, rIdx - lIdx);
                while (hmap.size() > 2) {
                    hmap.put(fruits[lIdx], hmap.get(fruits[lIdx]) - 1);
                    if (hmap.get(fruits[lIdx]) == 0) {
                        hmap.remove(fruits[lIdx]);
                    }
                    lIdx++;
                }
            }
            rIdx++;
        }
        result = Math.max(result, rIdx - lIdx);
        return result;
    }

    /**
     * def variable_length_sliding_window(nums):
     *   state = # choose appropriate data structure
     *   start = 0
     *   max_ = 0
     *
     *   for end in range(len(nums)):
     *     # extend window
     *     # add nums[end] to state in O(1) in time
     *
     *     while state is not valid:
     *       # repeatedly contract window until it is valid again
     *       # remove nums[start] from state in O(1) in time
     *       start += 1
     *
     *     # INVARIANT: state of current window is valid here.
     *     max_ = max(max_, end - start + 1)
     *
     *   return max_
     *
     * */


}
