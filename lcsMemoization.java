package com.DPAdityaVerma;
import java.util.*;
import java.io.*;

public class lcsMemoization {

    static int[][] t = new int[1001][1001];
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int m = s1.length();
        int n = s2.length();
        for(int[] row: t)
            Arrays.fill(row, -1);
        System.out.println("Length of the LCS is " + lcs(x, y, m, n));
    }
    static int lcs(char[] x, char[] y, int m, int n){
        if(m==0 || n==0){
            return 0;
        }
        if(t[m][n] != -1){
            return t[m][n];
        }
        if(x[m-1] == y[n-1]){
            return t[m][n] = 1 + lcs(x, y, m-1, n-1);
        }
        else{
            return t[m][n] = Math.max(lcs(x, y, m, n-1), lcs(x, y, m-1, n));
        }
    }
}
