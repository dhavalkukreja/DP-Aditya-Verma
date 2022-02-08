package com.DPAdityaVerma;
import java.util.*;


public class mcmRecursive {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n= scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println("minimum number of multiplication is " + solve(arr, 1, n-1));
    }

    static int solve(int[] arr, int i, int j){
        if(i>=j)
            return 0;
        int mn = Integer.MAX_VALUE;
        int temp_ans = -1;
        for(int k = i; k<j; k++)
            temp_ans = solve(arr, i, k ) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            mn = Math.min(mn, temp_ans);
        return mn;

        // edited
    }
}
