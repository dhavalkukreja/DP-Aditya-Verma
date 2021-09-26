package com.DPAdityaVerma;
import java.util.*;
import java.io.*;

public class minimumSubsetSumDifference {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        for(int i = 0; i<n; i++){
            val[i] = scn.nextInt();
        }
        System.out.println("The minimum subset sum difference is " + mssd(val, n));
    }
    public static int mssd(int[] val, int n){
        int range = 0;
        for(int i = 0; i<n; i++){
            range = range + val[i];
        }
        boolean[][] t = new boolean[n+1][range+1];
        Arrays.fill(t[0], false);
        for(boolean[] col:t)
            Arrays.fill(col, 0, 1, true);
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=range; j++){
                if(val[i-1] <= j){
                    t[i][j] = t[i-1][j] || t[i-1][j-val[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        for(int j = range/2; j>=0; j--){
            if(t[n][j]){
                diff = range - 2*j;
                break;
            }
        }
        return diff;
    }
}
