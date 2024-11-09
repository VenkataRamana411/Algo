package LeetCode;

public class MinHeight {

    public static void main(String[] args) {
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        String customer = "7868190130M7522";
        int i = Integer.parseInt(customer.substring(11, 13));
        System.out.println(i);
        System.out.println(minHeightShelves(books, 4));
    }

    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int result = 0, currWidth = 0, currHeight = 0;
        for (int i = books.length - 1; i >= 0; i--) {
            if (books[i][0] + currWidth <= shelfWidth) {
                currHeight = Math.max(currHeight,books[i][1]);
                currWidth += books[i][0];
            }else {
                result += currHeight;
                currHeight = 0;
                currWidth = 0;
                i++;
            }
        }
        result += currHeight;
        return result;
    }
}
