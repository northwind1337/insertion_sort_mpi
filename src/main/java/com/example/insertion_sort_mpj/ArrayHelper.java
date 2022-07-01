package com.example.insertion_sort_mpj;

public class ArrayHelper {
    public static final int MIN_NUMBER = -100;
    public static final int MAX_NUMBER = 100;

    public static int testArraySize = 20;
    public static int[] testArray1 = new int[]{3, 4, 5, 78, 3, 4, 6, 7 - 4, -5, 6, -60, 67, 4, 8, 33, 56, -90, 95, 86};

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = RandomNumber.getInRange(MIN_NUMBER, MAX_NUMBER);
//            array[i] = size - i;
        return array;
    }

    public static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
