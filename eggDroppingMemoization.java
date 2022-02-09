package com.DPAdityaVerma;
import java.util.*;

public class eggDroppingMemoization{
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
            int temp_ans = 1 + Math.max(solve(e, f-k), solve(e-1, k-1));
            mn = Math.min(mn, temp_ans);
        }
        return t[e][f] = mn;
    }
}
