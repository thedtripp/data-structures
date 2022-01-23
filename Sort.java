package project7_sorting;
import java.util.Random;
/**Class: Sort
 * Author: Daniel Tripp
 * Description: This class tests various sorting methods for efficiency. Here,
 * we analyze insertion sort, selection sort, shell sort, and merge sort. Of
 * these algorithms, I believe merge sort is the most efficient because the
 * average case time complexity is (n log n). Insertion and selection sort are
 * not efficient with n^2 run times. Shell sort has an average time complexity
 * of n (log n) ^ 2.
 */
public class Sort {
    
    public Timer tmr;
    public int iterations;      // counts the number of iterations.
    double[] arr;               // stores the list.
    
    /** Function: Sort
     * Author: Daniel Tripp
     * Description: A no arg constructor. It calls the working constructor with
     * a default value. In this case, 1000.
     * Inputs: None.
     * Outputs: None.
     */
    public Sort() {
        this(1000);
    }
    
    /** Function: Sort
     * Author: Daniel Tripp
     * Description: A single arg constructor. It loads the arr field with a
     * specified number of random doubles. A Timer object is instantiated.
     * Inputs: int num: number of items to add to array.
     * Outputs: None.
     */
    public Sort(int num) {
        Random r = new Random();
        arr = new double[num];
        for(int i = 0; i < arr.length; i++) {
            //rounded doubles to make output more readable
            //arr[i] = Math.round((((r.nextDouble() * (100.0 - 1.0)) + 1.0)) *1000.0) / 1000.0;
            arr[i] = (r.nextDouble() * (100.0 - 1.0)) + 1.0; //unrounded doubles
        }
        tmr = new Timer();
    }
    


    /** Function: print
     * Author: Daniel Tripp
     * Description: This function iterates through the arr field, printing each
     * value to the console.
     * Inputs: None.
     * Outputs: None.
     */
    public void print() {
        System.out.print(": ");
        for (double d : this.arr) {
            System.out.print(d + " : ");
        }
        System.out.println();
    }
    
    /** Function: insertionSort
     * Author: Daniel Tripp
     * Description: A wrapper to allow the user to call the insertion Sort function
     * without having to specify the last parameter. It sets this
     * value to array length - 1. It sorts the arr field of the calling object.
     * In addition, it times the sorting process and outputs time to the console.
     * Inputs: None.
     * Outputs: None.
     */
    public double[] insertionSort() {
        tmr.startTimer();
        insertionSort(this.arr, arr.length - 1);
        tmr.stopTimer();
        System.out.println("Insertion sort complete.\nNumber of items: " + this.arr.length + "\nTime elapsed: " + tmr.getSecond() + "\nNumber of iterations: " + this.iterations);
        return this.arr;
    }
     
    
    /** Function: insertionSort
     * Author: Dr. Glenn Stevenson
     * Description: From lecture notes: This method sorts the array argument. 
     * It selects the item to moved then swap that value with the value in place 
     * where you want to insert. The algorithm divides the list to be sorted into 
     * two separate sublists, one that is sorted and one that is not. At each 
     * iteration an element from the unsorted list is moved into the sorted sublist.
     * Inputs: array of doubles, int low, int high.
     * Outputs: None.
     */
    public double[] insertionSort(double[] list, int last) {
       double hold = 0;
       int search = 0;
       iterations = 0;
        for(int current = 1; current <= last; current++)
        {
            hold = list[current];
            for(search = current - 1; search >= 0 && hold < list[search]; search--)
            {
                iterations++;
                list[search + 1 ] = list[search];
            }
            list[search + 1] = hold;
        }
        return list; 
    }

    /** Function: selectionSort
     * Author: Daniel Tripp
     * Description: A wrapper to allow the user to call the selection Sort function
     * without having to specify the last parameter. It sets this
     * value to array length - 1. It sorts the arr field of the calling object.
     * In addition, it times the sorting process and outputs time to the console.
     * Inputs: None.
     * Outputs: None.
     */
    public double[] selectionSort() {
        tmr.startTimer();
        selectionSort(this.arr, this.arr.length -1 );
        tmr.stopTimer();
        System.out.println("Selection sort complete.\nNumber of items: " + this.arr.length + "\nTime elapsed: " + tmr.getSecond() + "\nNumber of iterations: " + this.iterations);
        return this.arr;
    }
    
    /** Function: selectionSort
     * Author: Dr. Glenn Stevenson
     * Description: From wikipedia.com: The algorithm divides the input list into
     * two parts: a sorted sublist of items which is built up from left to right 
     * at the front (left) of the list and a sublist of the remaining unsorted 
     * items that occupy the rest of the list. Initially, the sorted sublist is 
     * empty and the unsorted sublist is the entire input list. The algorithm 
     * proceeds by finding the smallest (or largest, depending on sorting order) 
     * element in the unsorted sublist, exchanging (swapping) it with the leftmost 
     * unsorted element (putting it in sorted order), and moving the sublist 
     * boundaries one element to the right. 
     * Inputs: array of doubles, int low, int high.
     * Outputs: None.
     */
    public double[] selectionSort(double[] list, int last)
   {
        int smallest = 0;
        double holdData = 0;

        for(int current = 0; current < last; current++)
        {
            smallest = current;
            for(int index = current + 1; index <= last; index++)
            {
                iterations++;
                if(list[index] < list[smallest])
                {
                    smallest = index;
                }
            }
            holdData = list[current];
            list[current] = list[smallest];
            list[smallest] = holdData;
        }
        return list;
    }
  
    /** Function: shellSort
     * Author: Daniel Tripp
     * Description: A wrapper to allow the user to call the shellSort function
     * without having to specify the last parameter. It sets this
     * value to array length - 1. It sorts the arr field of the calling object.
     * In addition, it times the sorting process and outputs time to the console.
     * Inputs: None.
     * Outputs: None.
     */
    public double[] shellSort() {
        tmr.startTimer();
        shellSort(this.arr, arr.length -1 );
        tmr.stopTimer();
        System.out.println("Shell sort complete.\nNumber of items: " + this.arr.length + "\nTime elapsed: " + tmr.getSecond() + "\nNumber of iterations: " + this.iterations);
        return this.arr;
    }
    
    
    
    /** Function: shellSort
     * Author: Dr. Glenn Stevenson
     * Description: From lecture notes: This method sorts an array. The 
     * algorithm divides a list of n elements into k segments. Each segment 
     * contains a minimum integral of n/k. With each iteration through the data 
     * the processing begins with the first element in the list and progresses 
     * through each value comparing it to adjacent elements in each segment. 
     * Inputs: array of doubles, int low, int high.
     * Outputs: None.
     */
    void shellSort(double list[], int last) {
        double hold;
        int incre;
        int index;

        incre = last / 2;
        while (incre != 0)
        {
            for(int curr = incre; curr <= last; curr++)
            {
                hold = list[curr];
                index = curr - incre;
                while(index >= 0 && hold < list [index])
                {
                    iterations++;
                    //move larger element up in list
                    list[index + incre] = list [index];
                    //Fall back one partition
                    index = (index - incre);
                }

            //Insert hold in proper position
            list[index + incre] = hold;
        }

        //End of pass--calculate next increment.
        incre = incre / 2;
        }
    }
    
    /** Function: mergeSort
     * Author: Daniel Tripp
     * Description: A wrapper to allow the user to call the mergeSort function
     * without having to specify the low and high parameters. It sets these
     * values to 0, and array length - 1. It sorts the arr field of the calling object.
     * In addition, it times the sorting process and outputs time to the console.
     * Inputs: None.
     * Outputs: None.
     */
    public void mergeSort() {
        tmr.startTimer();
        this.mergeSort(this.arr, 0, this.arr.length - 1);
        tmr.stopTimer();
        System.out.println("Merge sort complete.\nNumber of items: " + this.arr.length + "\nTime elapsed: " + tmr.getSecond() + "\nNumber of iterations: " + this.iterations);
    }
    
    /** Function: mergeSort
     * Author: Dr. Glenn Stevenson
     * Description: This is a recursive method that sorts an array by repeatedly
     * dividing it in two sub-arrays. The sub-arrays are merged in sorted order.
     * Inputs: array of doubles, int low, int high.
     * Outputs: None.
     */
    public int mergeSort(double a[], int low, int high) {
        int mid;
            if(low<high)
            {
                mid=(low+high)/2;
                mergeSort(a,low,mid);
                mergeSort(a,mid+1,high);
                merge(a,low,high,mid);
            }
        return(0);
    }

    /** Function: merge
     * Author: Dr. Glenn Stevenson
     * Description: This is a helper method of mergeSort. It traverses two
     * halves of an array and compares the values at each step. It always places
     * the smaller value in a new array. This new sorted array is copied to the
     * original array.
     * Inputs: array of doubles, int low, int high, int mid.
     * Outputs: None.
     */
    void merge(double a[], int low, int high, int mid) {
        int i, j, k;
        
        double[] c = new double[a.length];
        
        i = low;
        j = mid+1;
        k = low;
        while((i<=mid)&&(j<=high)) {
            iterations++;
            if(a[i]<a[j]) {
                c[k]=a[i];
                k++;
                i++;
            }
            else {
                c[k]=a[j];
                k++;
                j++;
            }
        }
        while(i<=mid ) {
            c[k]=a[i];
            k++;
            i++;
        }
        while(j<=high) {
            c[k]=a[j];
            k++;
            j++;
        }
        for(i=low;i<k;i++) {
            a[i]=c[i];
        }
    }
   
}

