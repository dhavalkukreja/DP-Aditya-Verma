package com.DPAdityaVerma;
import java.io.*;
import java.util.*;

public class lcsPrint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();

        int m = s1.length();
        int n = s2.length();

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();

        System.out.println("The longest common subsequence is " + lcsp(x, y, m, n) + ".");

    }

    public static StringBuilder lcsp(char[] x, char[] y, int m, int n) {
        StringBuilder sb = new StringBuilder();
        int[][] t = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        int c = m, d = n;
        while (c > 0 && d > 0) {
            if (x[c - 1] == y[d - 1]) {
                sb.append(x[c - 1]);
                c--;
                d--;
            } else {
                if (t[c][d - 1] > t[c - 1][d]) {
                    d--;
                } else {
                    c--;
                }
            }
        }
        // editing done
        return sb.reverse();
    }
}

