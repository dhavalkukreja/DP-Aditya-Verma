package com.DPAdityaVerma;
import java.util.*;

public class printShortestCommonSupersequence {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        int m = s1.length();
        char[] x = s1.toCharArray();

        String s2 = scn.next();
        int n = s2.length();
        char[] y = s2.toCharArray();

        System.out.println("The scs is " + pscs(x, y, m, n));
    }

    public static StringBuilder pscs(char[] x, char[] y, int m, int n){
        StringBuilder sb = new StringBuilder();
        int[][] t = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
                else if(x[i-1] == y[j-1]){
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        int c = m, d = n;
        while(c>0 && d>0){
            if(x[c-1] == y[d-1]){
                sb.append(x[c-1]);
                c--;
                d--;
            }
            else if(t[c-1][d] < t[c][d-1]){
                sb.append(y[d-1]);
                d--;
            }
            else{
                sb.append(x[c-1]);
                c--;
            }

        }
        while(c>0){
            sb.append(x[c-1]);
            c--;
        }
        while(d>0){
            sb.append(y[d-1]);
            d--;
        }

        return sb.reverse();
    }
}
