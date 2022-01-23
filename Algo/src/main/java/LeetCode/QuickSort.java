package LeetCode;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,5,8,1,9,-1,6,0,10};
        quickSort(arr,0,arr.length-1);
        for (int a: arr) {
            System.out.println(a);
        }
    }

    private static void quickSort(int[] arr,int l , int r){
        if(l >= r)
            return;
        int boundary = partition(arr,l,r);
        quickSort(arr,l,boundary-1);
        quickSort(arr,boundary+1,r);
    }

    private static int partition(int[] arr,int l, int r){
        int pivot = arr[r];
        int boundary = l-1;
        for(int i = l ; i <= r ; i++){
            if(arr[i] <= pivot ){
                swap(arr,i,++boundary);
            }
        }
        return boundary;
    }

    private static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
