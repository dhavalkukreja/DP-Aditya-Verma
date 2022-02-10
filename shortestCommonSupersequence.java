package com.DPAdityaVerma;
import java.io.*;
import java.util.*;

public class shortestCommonSupersequence {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();

        int m = s1.length();
        int n = s2.length();

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();

        System.out.println("Length of shortest common subsequence is " + (m+n - scss(m, n, x, y)));
    }

    public static int scss(int m, int n, char[] x, char[] y){
        int[][] t = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(x[i-1] == y[j-1]){
                    t[i][j] = 1 +  t[i-1][j-1];
                    max = Math.max(max, t[i][j]);
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return max;
    }
}