package com.DPAdityaVerma;
import java.util.*;

public class convertStringAtoB {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        int m = s1.length();
        int n = s2.length();
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        System.out.println("Number of deletions needed is " + (m - lcs(x, y, m, n)) );
        System.out.println("Number of insertions needed is " + (n - lcs(x, y, m, n)) );
    }

    public static int lcs(char[] x, char[] y, int m, int n){
        int[][] t = new int[m+1][n+1];
        Arrays.fill(t[0], 0);
        for(int[] row: t)
            Arrays.fill(row, 0, 1, 0);
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(x[i-1] == y[j-1])
                    t[i][j] = 1+t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        return t[m][n];
    }
}
