package com.DPAdityaVerma;
import java.util.*;
import java.io.*;

public class countOfSubsetWithGivenDifference {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
        }
        System.out.println("Enter the required difference ");
        int diff = scn.nextInt();

        int rsum = (diff + sum)/2;
        System.out.println("The count of such subsets is " + cosswgs(arr, rsum, n));
    }

    public static int cosswgs(int[] arr, int rsum, int n){
        int[][] t = new int[n+1][rsum + 1];
        Arrays.fill(t[0], 0);
        for(int[] row: t)
            Arrays.fill(row, 0, 1, 1);
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=rsum; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j] + t[i-1][j - arr[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][rsum];
    }
}
