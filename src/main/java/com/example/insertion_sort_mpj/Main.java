package com.example.insertion_sort_mpj;


public class Main {
    public static void main(String[] args) {
        int arraySize = 50000;
        long startTime = System.nanoTime();
        MPIHelper.runMPISort(args, arraySize);
//        MPIHelper.runSeqSort(arraySize);
        long finishTime = System.nanoTime();
        long executionTime = finishTime - startTime;
        System.out.println("algorithm time execution (seconds): " + executionTime/1e9);

    }
}
