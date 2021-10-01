package com.DPAdityaVerma;
import java.io.*;
import java.util.*;

public class longestCommonSubstring {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();

        int m = s1.length();
        int n = s2.length();

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();

        System.out.println("The longest common substring is " + lcss(x, y, m, n) + ".");
    }

    public static int lcss(char[] x, char[] y, int m, int n){
            int[][] t = new int[m+1][n+1];
            Arrays.fill(t[0], 0);
            for(int[] row: t)
                Arrays.fill(row, 0, 1, 0);
            int max = Integer.MIN_VALUE;
            for(int i = 1; i<=m; i++){
                for(int j = 1; j<=n; j++){
                    if(x[i-1] == y[j-1]){
                        t[i][j] = 1 + t[i-1][j-1];
                        max = Math.max(max, t[i][j]);
                    }
                    else{
                        t[i][j] = 0;
                    }
                }
            }
            return max;

    }
}
