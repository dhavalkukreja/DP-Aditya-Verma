package com.DPAdityaVerma;
import java.util.*;

public class longestRepeatingSubsequence {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        //String s2 = scn.next();
        char[] x = s1.toCharArray();
        //char[] y = s2.toCharArray();
        int m = s1.length();
        //int n = s2.length();
        System.out.println("Length of the LCS is " + lcs(x, m));
    }
    static int lcs(char[] x, int m){
        int[][] t = new int[m +1][m+1];
        Arrays.fill(t[0], 0);
        for(int[] row: t)
            Arrays.fill(row, 0, 1, 0);
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=m; j++){
                if(x[i-1] == x[j-1] && i != j){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][m];
    }
}
