package com.DPAdityaVerma;
import java.util.*;
import java.io.*;

public class coinChange_MaxNoOfWays {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coin = new int[n];
        for(int i = 0; i<n; i++){
            coin[i] = scn.nextInt();
        }
        int sum = scn.nextInt();
        System.out.println("The number of ways is " + mnow(coin, n, sum));
    }
    public static int mnow(int[] coin, int n, int sum){
        int[][] t = new int[n+1][sum+1];
        Arrays.fill(t[0], 0);
        for(int[] col:t){
            Arrays.fill(col, 0, 1, 1);
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=sum; j++){
                if(coin[i-1]<=j){
                    t[i][j] = t[i-1][j] + t[i][j-coin[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
