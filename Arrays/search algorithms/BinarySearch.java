public class BinarySearch{
    //returns the index of the key
    public static int binarySearch(int arr[] , int key){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(key==arr[mid]){
                return mid;
            }
            if(key>arr[mid])
                start=mid+1;
            else
                end=mid-1;
                
        }
        return -1;
    }
    public static void main(String[] args) {
        //sorted array needed
        int array[] = {1,2,3,4,5,6,7};
        System.out.println(binarySearch(array, 4));
    }
}