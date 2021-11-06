package com.wolkowycki.sorting;

class Sorting {

    static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1])
                    Utils.swap(array, j, j + 1);
            }
        }
    }

    static void insertionSort(int[] array) {
        int n = array.length;
        int key, j;
        for (int i = 0; i < n; i++) {
            // Selects the first unsorted element
            key = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > key) {
                // This loop shifts all the elements to right to
                // create the position for unsorted element
                array[j + 1] = array[j];
                j = j - 1;
            }
            // This inserts the unsorted element
            // to its correct position
            array[j + 1] = key;
        }
    }

    static void selectionSort(int[] array) {
        int n = array.length;
        int minIndex;
        // One by one move boundary of unsorted array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            // Swap the found minimum element with the first element
            Utils.swap(array, minIndex, i);
        }
    }

    static void heapSort(int[] array) {
        int n = array.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            Utils.createHeap(array, n, i);
        }
        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            Utils.swap(array, 0, i);
            // Create the reduced heap
            Utils.createHeap(array, i, 0);
        }
    }

    static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            // Find the middle point
            int m = leftIndex + (rightIndex - leftIndex) / 2;
            // Sort first and second halves
            mergeSort(array, leftIndex, m);
            mergeSort(array, m + 1, rightIndex);
            // Merge the sorted halves
            Utils.merge(array, leftIndex, m, rightIndex);
        }
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitioningIndex = Utils.partition(array, low, high);
            // Separately sort elements before partition
            // and after partition
            quickSort(array, low, partitioningIndex - 1);
            quickSort(array, partitioningIndex + 1, high);
        }
    }

    static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                // Copies the value to temp variable
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}
