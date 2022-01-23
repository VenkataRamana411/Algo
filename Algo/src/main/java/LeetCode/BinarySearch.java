package LeetCode;

public class BinarySearch {
    public static void main(String[] args) {
        //[-1,0,3,5,9,12,15] Target=9
        /*int[] input ={1,3,5,6,8,9,10,34,56,77,89,90,91};*/
        int[] input ={3,5,7,9,10};
        int target = 8,leftIndex = 0 , rightIndex = input.length-1,result = -1,mid = 0;
        while(leftIndex<=rightIndex)
         {
             mid = (leftIndex+rightIndex)/2;
            if(target == input[mid]){
                result = mid;
                break;
            }else if (target > input[mid]){
                leftIndex = mid+1;
            }else {
                rightIndex = mid-1;
            }
        }
        if(leftIndex == rightIndex){
            System.out.println(leftIndex);
        } else if(target > input[mid]){
            System.out.println(mid+1);
        }else if(mid == 0 ||  mid == input.length-1){
            System.out.println(mid);
        }else{
            System.out.println(mid);
        }


    }
}
