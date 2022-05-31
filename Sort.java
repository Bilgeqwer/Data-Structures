public class Sort {
    public static void main(String[] args) {
        int g[] = {151, 259, 360, 91, 115, 706, 34, 858};  
        int h = g.length;  
        RadixSort r1 = new RadixSort();  
        System.out.print("Before sorting array elements are - \n");  
        r1.printArray(g,h); 
        r1.radixsort(g, h);
        System.out.print("\n\nAfter applying Radix sort, the array elements are -\n");  
         r1.printArray(g, h);  
        System.out.println();
        int d [] = { 30, 28, 37, 5, 9, 14, 22, 39 };
        int q = d.length;  
        System.out.print("Before shell sorting array elements are - \n"); 
        ShellSort.printArr(d, q);  
        ShellSort.shell(d, q);
        System.out.print("\nAfter applying shell sort, the array elements are - \n");    
        ShellSort.printArr(d, q);
        System.out.println();
        int[] arrayToSort = {15, 19, 4, 3, 18, 6, 2, 12, 7, 9, 11, 16};
        System.out.println("Unsorted:");
        for(int i = 0;i< arrayToSort.length ; i++)
        { 
            System.out.print(arrayToSort[i] + " "); 
        }

        MergeSort sortObj = new MergeSort(arrayToSort);
        sortObj.sort();
        System.out.println();
        System.out.println("Sorted:");
        int [] sirali = sortObj.getList();
        for(int i = 0;i< sirali.length ; i++)
        { 
            System.out.print(sirali[i] + " "); 
        }
        int b[] ={9,5,8,3,1};
        //bubblesort(a);
        selectionsort(b, b.length);
        int a[] = { 13, 18, 27, 2, 19, 25 };  
        int n = a.length;  
        System.out.println("\nBefore sorting array elements are - ");  
        Quick q1 = new Quick();  
        q1.printArr(a, n);  
        q1.quick(a, 0, n - 1);  
        System.out.println("\nAfter sorting array elements are - ");  
        q1.printArr(a, n);  
        System.out.println();
        System.out.println("\nAfter insertion sorting array elements are - ");  
        insertsort(a, n); 
    }
    //moving the largest element to the end
    public static void bubblesort(int [] x){
        int n = x.length;
        int tut,j,i;
        boolean siralı=false;
        for(i=0;(i<n-1)&&!siralı; i++){
            siralı=true;
             for(j=0; j<n-i-1; j++){
                 if (x[j]>x[j+1]){
                     tut = x[j];
                     x[j] = x[j+1];
                     x[j+1] = tut;
                     siralı = false;     
                 }
             }
           
        }
        
    }
    public static int[] selectionsort(int[] A, int n){
        int tmp;
        int min;
        for(int i = 0; i<n-1;i++){
            min = i;
            for(int j = i; j<n-1; j++){ /*The reason we say j=i here is because if we find the smallest element and place it at the beginning
                                        we'll make sure he doesn't compare to this.*/ 
                 if(A[j]<A[min]){
                    min = j;
                }
                tmp = A[i] = A[min];
                A[min] = tmp;
            } 
        }
        return A; 
    }
    public static void insertsort(int x[], int n){
        int i,k,y;
        for(k=1; k<n; k++){
            y=x[k]; //the algorithm starts from the second index
            for(i=k-1; i>=0 && y<x[i]; i--)
            x[i+1]=x[i];
            x[i+1]=y;
            
        }
        for (int l : x) {
            System.out.print(" "+l);
        }
    }

}
class Quick{
     /* function that consider last element as pivot,  
place the pivot at its exact position, and place  
smaller elements to left of pivot and greater  
elements to right of pivot.  */  
    int partition(int a[], int start, int end){
        int pivot = a[end]; //pivot element
        int i =(start-1);
        for(int j = start; j<=end-1; j++){
            // If current element is smaller than pivot
            if(a[j]<pivot){
                i++; // increment index of smaller element
                int t = a[i];
                a[i] = a[j];
                a[j] = t;

            }
        }
        int t = a[i+1];  
        a[i+1] = a[end];  
        a[end] = t;  
        return (i + 1); 
    }
    /* function to implement quick sort */  
    void quick(int a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */  
    {  
    if (start < end)  
    {  
        int p = partition(a, start, end);  //p is partitioning index  
        quick(a, start, p - 1);  
        quick(a, p + 1, end);  
    }  
}  
  
/* function to print an array */  
void printArr(int a[], int n)  
{  
    int i;  
    for (i = 0; i < n; i++)  
        System.out.print(a[i] + " ");  
}  
}
class MergeSort{
    private int [] list;
    public MergeSort(int [] listToSort){
        list = listToSort;
    }
    public int[] getList(){
        return list;
        // externally called sort function
    }
    public void sort() { 
    list = sort(list);
    // The sorting function that works recursively and is used for each part
    }
    private int[] sort(int[] whole) {
        if(whole.length == 1){
            return whole;
        }
        else{
        // we divide the array in half and form the left
        int[] left = new int[whole.length/2];
        System.arraycopy(whole, 0, left, 0, left.length);
        //we create the right of the array, but there is a possibility of an odd number
        int[] right = new int[whole.length-left.length];
        System.arraycopy(whole, left.length, right, 0, right.length);
        // we sort out both sides separately
        left = sort(left);
        right = sort(right);
        // We combine the sorted sequences
        merge(left, right, whole);
        return whole;
        }
    }
    private void merge(int[] left, int[] right, int[] result){
        int x = 0;
        int y = 0;
        int k = 0;
        // when there are elements in both arrays
        while (x < left.length && y < right.length){
            if (left[x] < right[y]) { 
                result[k] = left[x]; x++; 
            }
            else { 
                result[k] = right[y]; y++; 
            }
            k++;
        }
        int[] rest; int restIndex;
        if (x >= left.length) { 
            rest = right; restIndex = y; 
        }
        else { 
            rest = left; restIndex = x; 
        }
        for (int i = restIndex; i < rest.length; i++)
        { 
            result[k] = rest[i]; k++; 
        }
    }  
}
class ShellSort {  
    /* function to implement shellSort */  
    static void shell(int a[], int n)  
    {  
        /* Rearrange the array elements at n/2, n/4, ..., 1 intervals */  
        for (int interval = n/2; interval > 0; interval /= 2)  
        {  
            for (int i = interval; i < n; i += 1)  
            {  
        /* store a[i] to the variable temp and make the ith position empty */  
                int temp = a[i];  
                int j;        
                for (j = i; j >= interval && a[j - interval] > temp; j -= interval)  
                    a[j] = a[j - interval];  
                  
        /* put temp (the original a[i]) in its correct position */  
        a[j] = temp;  
            }  
        }  
    }  
    static void printArr(int a[], int n) /* function to print the array elements */  
    {  
        int i;  
        for (i = 0; i < n; i++)  
            System.out.print(a[i] + " ");  
    } 
}
class RadixSort {  
  
    int getMax(int a[], int n) {  
       int max = a[0];  
       for(int i = 1; i<n; i++) {  
          if(a[i] > max)  
             max = a[i];  
       }  
       return max; //maximum element from the array  
    }  
      
    void countingSort(int a[], int n, int place) // function to implement counting   
        
    {  
       int[] output = new int[n+1];  
     int[] count = new int[10];  
      
      // Calculate count of elements  
      for (int i = 0; i < n; i++)  
        count[(a[i] / place) % 10]++;  
          
      // Calculate cumulative frequency  
      for (int i = 1; i < 10; i++)  
        count[i] += count[i - 1];  
      
      // Place the elements in sorted order  
      for (int i = n - 1; i >= 0; i--) {  
        output[count[(a[i] / place) % 10] - 1] = a[i];  
        count[(a[i] / place) % 10]--;  
      }  
      
      for (int i = 0; i < n; i++)  
        a[i] = output[i];  
    }  
      
    // function to implement radix sort  
    void radixsort(int a[], int n) {  
       
      // get maximum element from array  
      int max = getMax(a, n);  
      
      // Apply counting sort to sort elements based on place value  
      for (int place = 1; max / place > 0; place *= 10)  
        countingSort(a, n, place);  
    }  
      
    // function to print array elements  
    void printArray(int a[], int n) {  
      for (int i = 0; i < n; ++i)   
        System.out.print(a[i] + " ");  
    }  
}

