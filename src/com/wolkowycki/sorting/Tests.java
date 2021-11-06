package com.wolkowycki.sorting;

class Tests {
    private static final int[] input = {7, 1, 12, 3};
    private static final int[] output = {1, 3, 7, 12};

    static void test() {
        int[] array = input.clone();
        Sorting.bubbleSort(array);
        // assert array == output;

        array = input.clone();
        Sorting.insertionSort(array);
        // assert array == output;

        array = input.clone();
        Sorting.selectionSort(array);
        // assert array == output;

        array = input.clone();
        Sorting.heapSort(array);
        // assert array == output;

        // array = input.clone();
        // Sorting.mergeSort(array, 0, array.length - 1);
        // assert array == output;

        array = input.clone();
        Sorting.quickSort(array, 0, array.length - 1);
        // assert array == output;

        array = input.clone();
        Sorting.shellSort(array);
        // assert array == output;
    }
}
