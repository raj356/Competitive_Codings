import java.util.*;
import java.io.*;

public class mergeSort{
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 3, -4, 1, 0};
        arr = mergeSort(arr, 0, arr.length - 1);
         System.out.print("[");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length - 1)
                System.out.print(",");
        }
        System.out.print("]");
    }
    public static int[] mergeSort(int[] arr, int left, int right){
        if(left < right){
            //calculating mid point
            int mid = left + (right - left) / 2;
            //calling mergeSort on first half then on the next half
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            //once mergeSort has been called on the entire array elements then calling merge
            //to merge according to their orders
            arr = merge(arr, left, right, mid, arr.length);
        }
        return arr;
    }
    public static int[] merge(int[] arr, int left, int right, int mid, int len){
        //creating array of size upper bound i.e. right and plus 1
        int[] ret = new int[right + 1];
        //initializing left pointer to the lower bound i.e. left and the right pointer to the
        //mid+1
        int countLeft = left;
        int countRight = mid + 1;
        //initializing another counter to mark the current position of the "ret" array
        int count = left;
       
        //checking that left pointer is less than equal to the mid and the right pointer
        //is less than equal to the upper bound i.e. right pointer
        while((countLeft <= mid) && (countRight <=right)){
            //checking that left part of the array is less than the right part then copying
            //that to the new array
            if(arr[countLeft] < arr[countRight])
            {
                ret[count] = arr[countLeft];
                //incrementing left counter as we have copied elements from the left part
                countLeft++;
            }
            //else copying right part to the current position in the new array
            else{
                ret[count] = arr[countRight];
                //incrementing right counter as we have copied elements from the right part
                countRight++; 
            }
            
            //incrementing the current position in the newly created array
            count++;
        }
        
        //checking that the left pointer is less than the mid, if yes then it means some 
        //elements still there in the left portion of the array and copying them
        if(countLeft <= mid){
            while(countLeft <= mid){
               ret[count] = arr[countLeft];
                countLeft++;
                count++;
            }
        }
        //checking that the right pointer is less than the mid, if yes then it means some 
        //elements still there in the right portion of the array and copying them
        if(countRight <= right){
            while(countRight <= right){
               ret[count] = arr[countRight];
                countRight++;
                count++;
            }
        }
        //copying from the current array to the original array only the changed parts
        for(int i=left; i<=right; i++)
            arr[i] = ret[i];

        //returning the original array    
        return arr;
    }
}