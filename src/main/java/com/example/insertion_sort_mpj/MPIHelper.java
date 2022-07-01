package com.example.insertion_sort_mpj;

import mpi.MPI;

import java.util.Arrays;

public class MPIHelper {
    public static final int MASTER_PROCESS_ID = 0;

    public static int[] takeSubArrayMPI(int[] array) {
        int processId = MPI.COMM_WORLD.Rank();
        int processesNum = MPI.COMM_WORLD.Size();
        int chunkSize = array.length / processesNum;

        if (processId == processesNum - 1) {
            return Arrays.copyOfRange(array, processId * chunkSize, array.length);
        }
        return Arrays.copyOfRange(array, processId * chunkSize, (processId + 1) * chunkSize);
    }

    public static void runSeqSort(int arraySize) {
        int[] initialArray = ArrayHelper.generateRandomArray(arraySize);
        System.out.println("Array before:" + Arrays.toString(initialArray));
        InsertionSort.sortSequential(initialArray);
        System.out.println("Array after:" + Arrays.toString(initialArray));
    }

    public static void runMPISort(String[] MPI_args, int arraySize) {
        MPI.Init(MPI_args);
        int processId = MPI.COMM_WORLD.Rank();
        int processesNum = MPI.COMM_WORLD.Size();

        int[] initialArray = new int[arraySize];
        int[] finalArray = new int[arraySize];
        if (processId == MPIHelper.MASTER_PROCESS_ID) {
            initialArray = ArrayHelper.generateRandomArray(arraySize);
            System.out.println(Arrays.toString(initialArray));
        }
        MPI.COMM_WORLD.Bcast(initialArray, 0, arraySize, MPI.INT, MPIHelper.MASTER_PROCESS_ID);

        int[] subArray = MPIHelper.takeSubArrayMPI(initialArray);
        InsertionSort.sortSequential(subArray);
        System.out.println("Process" + processId + ":" + Arrays.toString(subArray));

        MPI.COMM_WORLD.Gather(subArray, 0, subArray.length, MPI.INT, finalArray, processId * subArray.length, subArray.length, MPI.INT, MPIHelper.MASTER_PROCESS_ID);

        if (processId == MPIHelper.MASTER_PROCESS_ID) {
            System.out.println("Final array before:" + Arrays.toString(finalArray));
            InsertionSort.sortSequential(finalArray);
            System.out.println("Final array after:" + Arrays.toString(finalArray));
        }


        MPI.Finalize();
    }

}
