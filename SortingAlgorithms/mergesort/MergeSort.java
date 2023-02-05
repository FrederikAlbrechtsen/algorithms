import java.util.*;

public class MergeSort {
    
    public static void merge(int array[], int start, int mid, int end) {
    
        int n1 = mid - start + 1;
        int n2 = end - mid;
        
        int L[] = new int [n1]; 
        int R[] = new int [n2];
        
        for(int i = 0; i < n1; i++) {
            L[i] = array[start+i];
            
        }
        for(int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }
        
        int i = 0;
        int j = 0;
        int k = start;
        
        while(i < n1 && j < n2) {
            
            if(L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else{
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            array[k] = L[i];
            i++;
            k++;
        }
       while(j < n2){
            array[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static void sort(int array[], int start, int end) {
    
        if (start < end) {
            int mid = (start + end)/2;
            sort(array, start, mid);
            sort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

 
    public static void main(String[] args) {
        
        //Generation random values to array
        Random r = new Random();
        
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt();
        }
        System.out.println("Before Merge Sort");
        for(int i : array) {
            System.out.println(i+" ");
        }
        
        System.out.println();
        
        MergeSort ob = new MergeSort();
        double timeStarted = System.currentTimeMillis();
        ob.sort(array, 0, array.length-1);
        System.out.println("Sorting last for:" + (System.currentTimeMillis() - timeStarted));
        
        System.out.println();
        
        System.out.println("After Merge-Sort");
        for(int i : array) {
            System.out.println(i+" ");
        }
        
    }
    
}
