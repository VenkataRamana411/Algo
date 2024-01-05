package prep.array;

import java.util.Arrays;

public class DecodedXOR {
    public static void main(String[] args) {
        System.out.println(4^2);
        System.out.println(Arrays.toString(decode(new int[]{6, 2, 7, 3}, 4)));
    }
    //A
    //6, 2, 7, 3
    //4 c
    //B
    public static int[] decode(int[] encoded, int first) {
        /** We need to find B here
         *  A ^ B = C
         *  A^ B ^ A = C ^ A
         *  B ^ 0 = C ^ A
         *  B = C ^ A
         *  */
        int[] result = new int[encoded.length+1];
        result[0] = first;
        int i = 1;
        for (int n : encoded){
            result[i] = result[i-1] ^ n;
            i++;
        }
        return result;
    }
}
