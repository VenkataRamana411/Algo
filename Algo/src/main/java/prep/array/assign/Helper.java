package prep.array.assign;

public class Helper {
    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        RangeSumQuery2 rangeSumQuery2 = new RangeSumQuery2(matrix);
        System.out.println(rangeSumQuery2.sumRegion(2,1,4,3));
        System.out.println(rangeSumQuery2.sumRegion(1,1,2,2));
        System.out.println(rangeSumQuery2.sumRegion(1,2,2,4));
    }
}
