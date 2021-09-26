package com.DPAdityaVerma;

import java.util.*;
import java.io.*;

public class EqualSumPartition {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = scn.nextInt();
        int[] val = new int[n];
        for(int i = 0; i<n; i++){
            val[i] = scn.nextInt();
        }
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum = val[i] + sum;
        }

        if(sum%2 == 1){
            System.out.println(false);
        }
        else{
            System.out.println(esp(val, sum/2, n));
        }
    }

    static boolean esp(int val[], int sumb2, int n){
        boolean[][] t = new boolean[n+1][sumb2 +1];
        Arrays.fill(t[0], false);
        for(boolean[] row : t)
            Arrays.fill(row, 0, 1, true);

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=sumb2; j++){
                if(val[i-1] <= j){
                    t[i][j] = t[i-1][j] || t[i-1][j-val[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sumb2];
    }
}
