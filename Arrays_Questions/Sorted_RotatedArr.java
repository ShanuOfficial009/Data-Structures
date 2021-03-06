//Search an element in a sorted and rotated array

package Arrays_Questions;

import java.util.Scanner;

public class Sorted_RotatedArr {

    public static int find(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[low] <= arr[mid]){                   // This means Low to mid part is sorted
                if(target >= arr[low] && target < arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
           else if(arr[high] >= arr[mid]){                    // This means mid part to right part is sorted
               if(target >= arr[mid] && target <= arr[high]){
                   low = mid + 1;
               }
               else{
                   high = mid -1;
               }
            }
        }
        return -1;                                           //If the given target is not present in the list
    }


    public static void main(String[] args) {
        //input work
  int[] arr = {1, 2, 4, 5, 3, 66 };
  int target = 66;
        int ans = find(arr, target);
        System.out.println("Target " + target+ " found at index: " +ans);
    }
}
