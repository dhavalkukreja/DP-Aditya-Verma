package com.DPAdityaVerma;
import java.util.*;
import java.io.*;

public class lcsRecursion {
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
        if(m==0 || n==0){
            return 0;
        }
        if(x[m-1] == y[n-1]){
            return 1 + lcs(x, y, m-1, n-1);
        }
        else{
            return Math.max(lcs(x, y, m, n-1), lcs(x, y, m-1, n));
        }
    }
}
