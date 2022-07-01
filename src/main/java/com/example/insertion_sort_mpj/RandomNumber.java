package com.example.insertion_sort_mpj;

public class RandomNumber {
    public static int getInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
