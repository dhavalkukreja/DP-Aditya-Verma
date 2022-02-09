package com.DPAdityaVerma;
import java.util.*;

public class eggDropingRecursive {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of eggs and floors ");
        int e = scn.nextInt();
        int f = scn.nextInt();
        System.out.println(solve(e, f));
    }

    static int solve(int e, int f){
        if(e == 1 || f == 0 || f == 1){
            return f;
        }

        int mn = Integer.MAX_VALUE;
        for(int k = 1; k<=f; k++){
            int temp_ans = 1 + Math.max(solve(e, f-k), solve(e-1, k-1));
            mn = Math.min(mn, temp_ans);
        }
        return mn;
    }
}
