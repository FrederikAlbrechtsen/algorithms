import java.util.*;

public class InsertionSort {
    
    public static void insertionSort(int array[]) {
        
        int n = array.length;
        for(int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while((i > -1) && (array[i] > key)) {
                array[i+1] = array[i];
                i = i - 1;
            }
            
            array[i+1] = key;       
        }
    }

    public static void main(String[] args) {
        
        //Generation random values to array
        Random r = new Random();
        
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        
        System.out.println("Before Insertion Sort");
        for(int i : arr) {
            System.out.println(i+" ");
        }
        
        System.out.println();

        double timeStarted = System.nanoTime();
        insertionSort(arr);
        System.out.println("Sorting last for:" + (System.nanoTime() - timeStarted));
        
        
        System.out.println("After Insertion Sort");
        for(int i : arr) {
            System.out.println(i+" ");
        }
    }
}