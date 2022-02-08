package com.DPAdityaVerma;

import java.util.*;

public class booleanParenthesisationRecursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int n = s.length();
        char[] arr = s.toCharArray();

        System.out.println("The number of ways is " + solve(arr, 0, n - 1, true));
    }


    public static int solve(char[] arr, int i, int j, boolean istrue) {

        if (i == j) {
            if (istrue) {
                if (arr[i] == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            }

            if (istrue == false) {
                if (arr[i] == 'T') {
                    return 0;
                } else {
                    return 1;
                }
            }
        }

        int ans = 0;

        for (int k = i + 1; k < j; k += 2){
            int lt = solve(arr, i, k - 1, true);
            int rt = solve(arr, k + 1, j, true);
            int lf = solve(arr, i, k - 1, false);
            int rf = solve(arr, k + 1, j, false);

            if (arr[k] == '|') {
                if (istrue == true) {
                    ans += lt * rt + lt * rf + lf * rt;
                } else {
                    ans += rf * lf;
                }
            }

            if (arr[k] == '&') {
                if (istrue == true) {
                    ans += lt * rt;
                } else {
                    ans += rf * lf + lt * rf + lf * rt;
                }
            }

            if (arr[k] == '^') {
                if (istrue == true) {
                    ans += lt * rf + lf * rt;
                } else {
                    ans += rf * lf + rt * lt;
                }
            }
        }

        return ans;
    }
}