package com.DPAdityaVerma;
import java.util.*;
import java.io.*;
public class coinchange_MinNoOfCoins {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] coins = new int[n];
        for(int i = 0; i<n; i++){
            coins[i] = scn.nextInt();
        }
        int sum = scn.nextInt();
        System.out.println("Minimum no of coins is " + mnoc(coins, n, sum));
    }

    public static int mnoc(int[] coins, int n, int sum){
        int[][] t = new int[n+1][sum+1];
        for(int[] col: t){
            Arrays.fill(col, 0, 1, 0);
        }
        Arrays.fill(t[0], Integer.MAX_VALUE - 1);
        for(int i = 1, j = 1; j<=sum; j++){
            if(j % coins[0] == 0){
                t[i][j] = j/coins[0];
            }
            else{
                t[i][j] = Integer.MAX_VALUE-1;
            }
        }
        for(int i = 2; i<=n; i++){
            for(int j = 1; j<=sum; j++){
                if(coins[i-1] <= j) {
                    t[i][j] = Math.min(t[i - 1][j], t[i][j - coins[i - 1]] + 1);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
