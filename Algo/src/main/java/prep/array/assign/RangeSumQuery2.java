package prep.array.assign;

public class RangeSumQuery2 {
    int[][] matrix = null;
    int[][] prefixMatrix = null;
    public RangeSumQuery2(int[][] matrix) {
        this.matrix = matrix;
        prefixMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length ; i++){
            prefixMatrix[i][0] = matrix[i][0];
            for(int j = 1 ; j < matrix[0].length; j++){
                prefixMatrix[i][j] = matrix[i][j] + prefixMatrix[i][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        while (row1 <= row2){
            if(col1 == 0){
                result += prefixMatrix[row1][col1];
            }else{
                result += prefixMatrix[row1][col2] -prefixMatrix[row1][col1-1];
            }
            row1++;
        }
        return result;
    }
}
