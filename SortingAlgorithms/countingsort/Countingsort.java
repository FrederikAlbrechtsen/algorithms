public class Countingsort {
    
    public int[] CountingSort(int arr[], int B[], int k) {
        
        
        int n = arr.length;
        int C[] = new int[k+1];
        
        
        for (int i = 0; i < k+1; i++) {
            C[i] = 0;
        }
        
        for (int j = 0; j < n; j++) {
            C[arr[j]] = C[arr[j]] + 1;
        }
        
        for (int i = 1; i < k+1; i++) {
            C[i] = C[i] + C[i-1];
            
        }
        
        for (int j = n-1; j >= 0; j--) {
            B[C[arr[j]] - 1] = arr[j];
            C[arr[j]] = C[arr[j]] - 1;
        }
        
        return B;
    }

   
    public static void main(String[] args) {
        
        Countingsort ob = new Countingsort();
        
        int arr[] = {4,7,8,1,25}; 
        
        int B[] = new int[arr.length];
        
        
        ob.CountingSort(arr, B, 25);
        
        for (int i=0; i<arr.length; ++i) 
            System.out.print(B[i] + ", ");
        
    }
    
}