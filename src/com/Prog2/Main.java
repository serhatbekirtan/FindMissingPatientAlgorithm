package com.Prog2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//	    int[] arr = {7, 3, 1, 4, 2, 6, 8, 10, 5, 11};
//        int[] arr = {12, 7, 10, 9, 5, 4, 11, 1, 6, 8, 2};
        int[] input10K = new int[19999];

        for (int a = 0; a < input10K.length; a++) {
            input10K[a] = a;
        }

        long startTime = System.nanoTime();
        System.out.println(FindMissing(input10K, 0, input10K.length - 1));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " ms");


    }

    public static int partition(int[] A, int low, int high, int pivot){
        int temp;
        int i = low - 1;
        for (int j = low; j <= high; j++){
            if (A[j] <= pivot){
                i++;
                temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        return i + 1;
    }

    public static int FindMissing(int [] A, int low, int high){
        double doublePivot = (low + high + 2) / 2.0;
        int pivot = (int)Math.ceil(doublePivot);
        int i = partition(A, low, high, pivot);
//        System.out.println(i);

        if (i > high){
            return i + 1;
        } else {
            if (i < pivot){
                return FindMissing(A, low, i - 1);
            } else {
                return FindMissing(A, i, high);
            }
        }
    }
}
