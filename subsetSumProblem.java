package com.DPAdityaVerma;
import java.util.*;

public class subsetSumProblem {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<arr.length; i++)
            arr[i] = scn.nextInt();
        int w = scn.nextInt();

        System.out.println(ssp(arr, w, n));
    }

    public static boolean ssp(int[] arr, int w, int n){
        boolean[][] t = new boolean[n+1][w+1];
        Arrays.fill(t[0], false);
        for (boolean[] row: t)
            Arrays.fill(row, 0, 1, true);

        for(int i = 1; i<=n; i++)
            for(int j = 1; j<=w; j++)
                if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j] || t[i-1][j - arr[i-1]];
                else
                    t[i][j] = t[i-1][j];

        return t[n][w];
    }
}