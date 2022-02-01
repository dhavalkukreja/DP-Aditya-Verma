package com.DPAdityaVerma;
import java.net.StandardSocketOptions;
import java.util.*;

public class mcmMemoization {

    static int[][] t = new int[100][100];

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        for(int[] row:t)
            Arrays.fill(row, -1);

        System.out.println("minimum number of multiplication is " + solve(arr, 1, n-1));

    }

    static int solve (int arr[], int i, int j){
        if(i>=j)
            //t[i][j] = 0;
            return 0;
        if (t[i][j] != -1)
            return t[i][j];
        int mn = Integer.MAX_VALUE;
        int temp_ans = -1;
        for (int k = i; k<j; k++)
            temp_ans = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1] *arr[k] *arr[j];
            mn = Math.min(mn, temp_ans);

        return t[i][j] = mn;
    }
}
