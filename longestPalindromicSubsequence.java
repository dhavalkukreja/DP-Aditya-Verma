package com.DPAdityaVerma;
import java.util.*;
public class longestPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        int m = s1.length();
        char[] x = s1.toCharArray();
        char[] revx = new char[m];
        for (int i = 0; i < m; i++) {
            revx[m - i - 1] = s1.charAt(i);
        }
//        System.out.println(String.copyValueOf(revx));
        System.out.println("length of longest palindrome subsequence is " + lcs(x, revx, m));
    }


    public static int lcs(char[] x, char[] revx, int m) {
        int[][] t = new int[m + 1][m + 1];
        Arrays.fill(t[0], 0);
        for (int[] row : t)
            Arrays.fill(row, 0, 1, 0);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (x[i - 1] == revx[j - 1])
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        return t[m][m];
    }
}

