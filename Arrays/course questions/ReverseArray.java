// package arrays.course questions;

public class ReverseArray {
    public static void arrayReversal(int array[]){
        int start=0;
        int end=array.length-1;
        while(start<end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        arrayReversal(arr);
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
