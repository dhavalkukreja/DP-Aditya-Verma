package com.DPAdityaVerma;

import java.util.*;
import java.io.*;

public class countOfSubsetSumWithGivenSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = scn.nextInt();
        }
        int w = scn.nextInt();
        System.out.println("The number of possible subsets is " + cosswgs(val, n, w));
    }

    public static int cosswgs(int val[], int n, int w) {
        int[][] t = new int[n + 1][w + 1];
        Arrays.fill(t[0], 0);
        for (int[] col : t) {
            Arrays.fill(col, 0, 1, 1);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= w; j++) {
                    if (val[i - 1] <= j) {
                        t[i][j] = t[i - 1][j] + t[i - 1][j - val[i - 1]];
                    } else {
                        t[i][j] = t[i - 1][j];
                    }
                }
            }
        }
        return t[n][w];
    }
}
