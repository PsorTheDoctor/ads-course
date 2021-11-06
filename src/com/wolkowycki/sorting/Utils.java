package com.wolkowycki.sorting;

class Utils {

    static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    static void createHeap(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && array[left] > array[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            swap(array, i, largest);
            // Recursively create heap of the affected sub-tree
            createHeap(array, n, largest);
        }
    }

    static void merge(int[] array, int leftIndex, int m, int rightIndex) {
        int n1 = m - leftIndex + 1;
        int n2 = rightIndex - m;

        // Creates temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            left[i] = array[leftIndex + i];
        for (int j = 0; j < n2; ++j)
            right[j] = array[m + 1 + j];

        // Initial indices of the first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray
        int k = leftIndex;

        while (i < n1 && j < n2) {
            // Compares the elements of two subarrays and merges them
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of left[] if any
        while (i <= n1) {
            array[k] = left[i];
            i++;
            k++;
        }
        // Copy remaining elements of right[] if any
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        // Index of smaller element and indicates the right
        // position of pivot found so far
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (array[j] <= pivot) {
                // Increment index of smaller element
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
}
