package com.DPAdityaVerma;
import java.util.*;

public class knapsackBottomUp {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for(int i = 0; i<val.length; i++){
            val[i] = scn.nextInt();
        }
        for(int i = 0; i<wt.length; i++){
            wt[i] = scn.nextInt();
        }
        int w = scn.nextInt();
        int[][] t = new int[n+1][w+1];

        for(int[] row : t)
            Arrays.fill(row, -1);

        System.out.println(knapsack(wt, val, w, n, t));
        // System.out.println(Arrays.deepToString(t));
    }

    public static int knapsack(int[] wt, int[] val, int w, int n, int[][] t){
        if(n == 0 || w == 0){
            return 0;
        }
        if(t[n][w] != -1){
            return t[n][w];
        }
        if (wt[n-1] <= w)
            return t[n][w] = Math.max((val[n - 1] + knapsack(wt, val, w-wt[n-1], n-1, t)), knapsack(wt, val, w, n-1, t));
        else
            return t[n][w] = knapsack(wt, val, w, n-1, t);
    }
}
