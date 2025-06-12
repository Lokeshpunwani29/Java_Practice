public class SortingAlgos
{
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
			int smallestIdx = i;       //starting of unsorted array at each iteration
			for(int j = i+1; j < n; j++)
			{
				if(arr[j] < arr[smallestIdx]) smallestIdx = j;  // smallestIdx found
			}
			temp = arr[i];              // swap
			arr[i] = arr[smallestIdx];  // smallest value goes to sorted part which is at ith Index which
			arr[smallestIdx] = temp;    // considered to be start of unsorted array.
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
		insertionSort(arr);
		System.out.println("\nAfter Sorting:");
		for(int a:arr) System.out.print(a+" ");
	}
}
