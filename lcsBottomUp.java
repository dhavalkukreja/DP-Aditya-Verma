package com.DPAdityaVerma;
import java.util.*;
import java.io.*;

public class lcsBottomUp {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int m = s1.length();
        int n = s2.length();
        System.out.println("Length of the LCS is " + lcs(x, y, m, n));
    }
    static int lcs(char[] x, char[] y, int m, int n){
        int[][] t = new int[m +1][n+1];
        Arrays.fill(t[0], 0);
        for(int[] row: t)
            Arrays.fill(row, 0, 1, 0);
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(x[i-1] == y[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}
