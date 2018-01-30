package exercises;

public class Exercise_23_3 {//oups 23.13

	public static void main(String[] args) {
		long[][] graph = new long[6][6];
		int n = 50000;
		printGraph(graph);
		
		for(int i =0; i < graph.length; i++){
			SortingTime timerArray = new SortingTime(n);
			
			for(int j = 0; j < graph[i].length - 1; j++){
				System.out.println(j);
				switch(j){
					case 0: graph[i][j] = timerInsertionSort(timerArray.getArray());break;
					case 1: graph[i][j] = timerBubbleSort(timerArray.getArray());break;
					case 2: graph[i][j] = timerMerge(timerArray.getArray());break;
					case 3: graph[i][j] = timerQuickSort(timerArray.getArray());break;
					case 4: graph[i][j] = timerHeapSort(timerArray.getArray());break;
					case 5: graph[i][j] = (long)0;break;
					default: break;
				}
				printGraph(graph);	
				timerArray.reset();
			}
			System.gc();
			n+=50000;
			
		}

	}
	
	public static long timerBubbleSort(int[] list){
		long startTime = System.currentTimeMillis();
		
		boolean needNextPass = true;
		
		for (int k = 1; k < list.length && needNextPass; k++) {
		// Array may be sorted and next pass not needed
		needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (list[i] > list[i + 1]) {
					// Swap list[i] with list[i + 1]
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true; // Next pass still needed
				}
			}
		}
		
		long endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
	}
	
	public static long timerMerge(int[] list){
		long startTime = System.currentTimeMillis();
		mergeSort(list);
		long endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
	}
	
	public static void mergeSort(int[] list){
		if (list.length > 1) { 
			// Merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);
			
			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2,
			secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
			}
	}
	
	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp
		
		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
		
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}
	
	public static long timerInsertionSort(int[] list){
		long startTime = System.currentTimeMillis();
		
		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0..i-1] so that
			list[0..i] is sorted. */
			int currentElement = list[i];
			int k;
			
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
			list[k + 1] = list[k];
			}
			
			// Insert the current element into list[k + 1]
			list[k + 1] = currentElement;
		}
		long endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
	}
	
	public static long timerHeapSort(int[] list){
		long startTime = System.currentTimeMillis();
		Heap<Integer> heap = new Heap<>();
		// Add elements to the heap
		
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);
		
		// Remove elements from the heap
		for (int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();
		
		
		long endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
	}
	
	public static long timerQuickSort(int[] list){
		long startTime = System.currentTimeMillis();
		
		quickSort(list, 0, list.length - 1);
		
		long endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
	}
	
	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
			System.gc();
		}
	}
	
	public static int partition(int[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search
		
		while (high > low) {
		// Search forward from left
		while (low <= high && list[low] <= pivot)
		low++;
		
		// Search backward from right
		while (low <= high && list[high] > pivot)
		high--;
		
		// Swap two elements in the list
		if (high > low) {
		int temp = list[high];
		list[high] = list[low];
		list[low] = temp;
		}
		}
		
		while (high > first && list[high] >= pivot)
		high--;
		
		System.gc();
		
		// Swap pivot with list[high]
		if (pivot > list[high]) {
		list[first] = list[high];
		list[high] = pivot;
		return high;
		}
		else {
		return first;
		}
		
		}
	
	/*public static long timerRadixSort(int[] list){
		long startTime;
		
		long endTime;
	}
	*/
	
	public static void printGraph(long[][] x){
		System.out.printf("%-12s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s", "Array Size","Insertion Sort", "Bubble sort", "MergeSort", "Quick Sort", "Heap Sort", "Radix Sort");
		System.out.println();
		int n;
		
		for(int i = 0; i < x.length; i++){
			
			switch(i){
			case 0: n = 50000; break;
			case 1: n = 100000; break;
			case 2: n = 150000; break;
			case 3: n = 200000; break;
			case 4: n = 250000; break;
			case 5: n = 300000; break;
			default: n = 0; break;
			}
			
			System.out.printf("%-12d |  %-12s  | %-12s | %-12s | %-12s | %-12s | %-12s", n, x[i][0], x[i][1], x[i][2], x[i][3], x[i][4], x[i][5] );
			System.out.println();
		}
	}
}
