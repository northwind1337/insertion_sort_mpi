package com.example.insertion_sort_mpj;

public class InsertionSort {
    public static void sortSequential(int[] array) {
        int swap_counter = 0;
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                ArrayHelper.swapElements(array, j, j - 1);
                swap_counter += 1;
                j = j - 1;
            }
        }
        System.out.println("swap counter: " + swap_counter);
    }
}
