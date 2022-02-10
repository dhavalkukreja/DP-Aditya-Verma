package com.DPAdityaVerma;

import java.util.Arrays;
import java.util.Scanner;

public class eggDropingMemoizationOptimisation {
    static int t[][] = new int[100][100];

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of eggs and floors ");
        int e = scn.nextInt();
        int f = scn.nextInt();
        for(int[] row: t){
            Arrays.fill(row, -1);
        }
        System.out.println(solve(e, f));
    }

    static int solve(int e, int f){

        if(t[e][f] != -1){
            return t[e][f];
        }
        if(e == 1 || f == 0 || f == 1){
            return f;
        }

        int mn = Integer.MAX_VALUE;
        for(int k = 1; k<=f; k++){
            int up, down;
            if(t[e-1][k-1] != -1){
                up = t[e-1][k-1];
            }
            else{
                up = solve(e-1, k-1);
                t[e-1][k-1] = up;
            }

            if(t[e][f-k] != -1){
                down = t[e][f-k];
            }
            else{
                down = solve(e, f-k);
                t[e][f-k] = down;
            }


            int temp_ans = 1 + Math.max(up, down);
            mn = Math.min(mn, temp_ans);
        }
        return t[e][f] = mn;
    }
}