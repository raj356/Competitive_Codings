import java.util.*;
import java.io.*;

public class quickSort{
    public static void main(String[] args){
        int[] arr = new int[]{-2, 3, -4, 1, 0};
        arr = quickSort(arr, 0, arr.length);
        System.out.print("[");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
            if(i!=arr.length - 1)
                System.out.print(",");
        }
        System.out.print("]");
    }
    public static int[] quickSort(int[] arr, int left, int right){
        if(left < right){
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
        return arr;
    }
    public static int partition(int[] arr, int left, int right){
        // -2, 3, -4, 1, 0
        int pivot = arr[left]; 
        int j = left; 
        for(int i=left + 1; i<=right - 1; i++){ 
            if(arr[i] < pivot){ 
                j++;                 
                swap(i, j, arr); 
            }
        }
        swap(j, left, arr);
        return j;
    }
    public static void swap(int a, int b, int[] arr){
       if(a!=b){
        arr[a] = arr[a] + arr[b]; 
        arr[b] = arr[a] - arr[b]; 
        arr[a] = arr[a] - arr[b]; 
       }
       else
          return;
    }
}