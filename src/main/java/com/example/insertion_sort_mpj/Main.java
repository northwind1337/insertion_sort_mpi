package com.example.insertion_sort_mpj;


public class Main {
    public static void main(String[] args) {
        int arraySize = 3200;
        long startTime = System.currentTimeMillis();
        MPIHelper.runMPISort(args, arraySize);
//        MPIHelper.runSeqSort(arraySize);
        long finishTime = System.currentTimeMillis();
        long executionTime = finishTime - startTime;
        System.out.println("algorithm time execution (ms): " + executionTime);

    }
}
