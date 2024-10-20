
// public class RotatedArraySearch{

//     public static int binSearch(int a[], int target, int start, int end){
//         while(start<end){
//             int mid = start + (end-start)/2;
//             if(target==a[mid])
//                 return mid;
//             if(target>a[mid])
//                 start=mid+1;
//             else
//                 end=mid-1;
//         }

//         return -1;
//     }
//     //returns the index of the minimum element in the rotated array
//     public static int minElementIndexSearch(int a[]){
//         int start = 0;
//         int end = a.length - 1;

//         while(start < end){
//             int mid = start + (end - start)/2;
//             if(a[mid]<a[mid-1] && mid>0){
//                 return mid;
//             } else if(a[mid] > a[start] && a[mid] > a[end]){
//                 start = mid + 1;
//             } else{
//                 end = mid - 1;
//             }
//         }

//         return start; //do not return -1
//     }

//     public static int searchRotatedArray(int a[], int target){
//         // if(a.length==1){
//         //     if(target==a[0])
//         //         return 0;
//         //     else
//         //         return -1;
//         // }
//         int pivotElement = a[0]; 

//         // for(int i=1;i<a.length;i++){  //NOTE:due to this loop the solution gives O(n) and not O(logn)
//         //     if(a[i]<a[i-1]){
//         //         RStart = i;
//         //         break;
//         //     }
//         // }

//         int pivotIndex = minElementIndexSearch(a);
//         int lEnd = a.length - 1 - pivotIndex;
//         int RStart = lEnd + 1;

//         if(target > pivotElement){
//             return binSearch(a, target, 0, lEnd);
//         } else{
//             return binSearch(a, target, RStart , a.length-1);
//         }
//     }
//     public static void main(String[] args) {
//         int a[] = {1};
//         System.out.println(searchRotatedArray(a, 1));
//     }
// }

class RotatedArraySearch {
    public static int helper(int[] nums, int target, int si, int ei){
        if(si > ei)
            return -1;

        int mid = si + (ei-si)/2;

        if(target == nums[mid])
            return mid;
        
        //mid on line 1
        if(nums[si] <= nums[mid]){
            //target on left
            if(target >= nums[si] && target <= nums[mid])
                return helper(nums, target, si, mid-1);
            //target on right
            else
                return helper(nums, target, mid+1, ei);
        }else{
            //mid on line 2
            if(nums[mid] <= target && target <= nums[ei])
                return helper(nums, target, mid+1, ei);
            else
                return helper(nums, target, si, mid-1);
        }
    }

    public static int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int nums[] = {1,0,1,1,1};
        System.out.println(search(nums, 4));
    }
}