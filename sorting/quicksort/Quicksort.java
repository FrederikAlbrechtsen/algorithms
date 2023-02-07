import java.util.*;

public class Quicksort {
    
    public void QuickSort(int arr[], int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            QuickSort(arr, p, q - 1);
            QuickSort(arr, q + 1, r);
        }
    }

    public int partition(int arr[], int p, int r) {
        int x = arr[r];
        int i = (p - 1);
        
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i = i + 1;
                
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = swapTemp;
        
        return i + 1;
        
    }
    
    // A utility function to print array of size n
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    }

    
    public static void main(String[] args) {
        
        //Generation random values to array
        Random r = new Random();
        
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        
        System.out.println("Before Quicksort Sort");
        for(int i : arr) {
            System.out.println(i+" ");
        }
        
        
        System.out.println();
        
        int n = arr.length; 
  
        Quicksort ob = new Quicksort();
        
        double timeStarted = System.currentTimeMillis();
        
        ob.QuickSort(arr, 0, n-1); 
        
        System.out.println("Sorting last for:" + (System.currentTimeMillis() - timeStarted));
  
        System.out.println("After Quicksort"); 
        for(int i : arr) {
            System.out.println(i+" ");
        } 
        
    }
    
}
