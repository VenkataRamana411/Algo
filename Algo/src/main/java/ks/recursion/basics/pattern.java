package ks.recursion.basics;

public class pattern {
    public static void main(String[] args) {
        //pattern1(4,0);
        pattern2(4,0);
    }

    private static void pattern1(int row,int column){
        if (row == 0){
            return;
        }
        if (column < row){
            System.out.print("*");
            pattern1(row,column+1);
        }else {
            System.out.println();
            pattern1(row-1,0);
        }
    }
    private static void pattern2(int row,int column){
        if (row == 0){
            return;
        }
        if (column < row){
            pattern2(row,column+1);
            System.out.print("*");

        }else {
            pattern2(row-1,0);
            System.out.println();
        }
    }
}
