public class SortingAlgos
{
	/*
	Quick Sort have Time Complexity in Worst Case is O(n^2) when pivot is largest
	or smallest value still compared to better than Merge sort having Time Complexity
	of O(nlogn) in worst case because extra memory not allocated like merge sort. 
	*/
	
	static int partition(int[] arr, int low, int high)
	{
	    int SpaceCounterIdx = low - 1;  // Counts Space Empty to fill Smaller values
	    int pivot = arr[high];  // Pivot is like a Centew pivot around which things evolve
	    
	    //pivot can be placed at low, median, random also.
	    
	    for(int current= low; current < high; current++)    // Ignore high as pivot is kept there
	    {
	        if(arr[current] < pivot)       // Value is less than pivot
	        {
	            SpaceCounterIdx++;         // Increased the Space Count
	            //swap
	            int temp = arr[SpaceCounterIdx];
	            arr[SpaceCounterIdx] = arr[current];    // filled the current value at the empty sapce
	            arr[current] = temp;
	        }
	    }
	    SpaceCounterIdx++;                  // lowest value before Pivot Index + 1 i.e position of pivot
	        //swap
	        int temp = arr[SpaceCounterIdx];
	        arr[SpaceCounterIdx] = arr[high];
	        arr[high] = temp;
	        return SpaceCounterIdx;         // return Pivot Index
	}
	
	static void quickSort(int[] arr, int low, int high)
	{
	    if(low < high)
	    {
	        int pivotIdx = partition(arr, low, high); // Pivot Index
	        
	        quickSort(arr, low, pivotIdx - 1);  // Partitioned into two halfs values smaller than pivot
	        quickSort(arr, pivotIdx + 1, high); // This half contains values higher than Pivot
	    }
	}
	
	static void mergeSort(int[] arr, int left, int mid, int right)
	{
	    int[] mergedArr = new int[arr.length];  // Creating temporary array in which sort values are saved
	    int firstArrIdx = left;
	    int SecondArrIdx = mid + 1;
	    int mergedArrIdx = left;
	    
	    while( firstArrIdx <= mid && SecondArrIdx <= right)
	    {
	        if( arr[firstArrIdx] <= arr[SecondArrIdx]) // Element of 1st Half is compared with 2nd Half
	        {
	            mergedArr[mergedArrIdx++] = arr[firstArrIdx++]; // ++ happens after value assignment
	        }
	        else mergedArr[mergedArrIdx++] = arr[SecondArrIdx++];
	    }
	    while(firstArrIdx <= mid) // Copying remaining values in 1st half
	    {
	        mergedArr[mergedArrIdx++] = arr[firstArrIdx++];
	    }
	    
	    while(SecondArrIdx <= right) // Copying remaining values in 2nd half
	    {
	        mergedArr[mergedArrIdx++] = arr[SecondArrIdx++];
	    }
	    
	    for(int i=left; i <= right; i++)    // Copying Sorted Array to the Original Array
	    {
	        arr[i] = mergedArr[i];
	    }
	}
	
	static void mergeSortDivide(int[] arr, int left, int right) // Divide Part
	{
	    if( left < right)
	    {
	        int mid = left + (right - left)/2;
	        
	        mergeSortDivide(arr, left, mid);    // Recursive call which runs till base case
	        mergeSortDivide(arr, mid+1, right); // Second Recursive call which also runs till base case
	        
	        mergeSort(arr, left, mid, right); // Calling the Merge sorting method
	    }
	}
	static void insertionSort(int[] arr)
	{
		int n = arr.length;
		for(int i=1; i<n; i++)      // supposing arr[0] is sorted
		{
            int current = arr[i];   // starting of unsorted arr
            int j = i-1;            // keep track of sorted arr
            while( j >= 0 && current < arr[j])      // current is compared with its left value
            {
                arr[j+1] = arr[j];      // pushing larger elements at left towards right
                j--;                    // decreasing to compare with more left values
            }
            arr[j+1] = current;         // placing current at correct position
		}
	}
	static void selectionSort(int[] arr)
	{
		int temp;
		int n = arr.length;
		for(int i=0; i < n-1; i++)
		{
			int smallestIdx = i;       //Considering sorted
			for(int j = i+1; j < n; j++) // starting of unsorted
			{
				if(arr[j] < arr[smallestIdx]) smallestIdx = j;  // smallestIdx found
			}
			temp = arr[i];              // swap
			arr[i] = arr[smallestIdx];  // smallest value goes to sorted part which is at ith Index which
			arr[smallestIdx] = temp;
		}
	}
	static void bubbleSort(int[] arr)
	{
		int temp;
		int n = arr.length;
		boolean swap = false;               // flag for optimisng code.
		for(int i=0; i<n-1; i++)            // Iteration n-1
		{
			for(int j=0; j<n-i-1; j++)      // n-i-1 ignoring larger value sets at last
			{
				if(arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap = true;
				}
			}
			if(!swap) return;               // if no swapping happens in the pass means already sorted
		}
	}

	public static void main(String[] args)
	{
		int[] arr = {69,78,98,45,5,2,1,0,74,3};
		System.out.println("Before Sorting:");
		for(int a:arr) System.out.print(a+" ");

		//bubbleSort(arr);
		//selectionSort(arr);
		//insertionSort(arr);
		//mergeSortDivide(arr, 0, arr.length - 1);
	    quickSort(arr, 0, arr.length - 1);
		System.out.println("\nAfter Sorting:");
		for(int a:arr) System.out.print(a+" ");
	}
}
