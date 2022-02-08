package com.DPAdityaVerma;
        import java.util.*;

public class palindromePartitionMemoizationOptimization {

    static int[][] t = new int[100][100];
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = str.length();
        char[] arr = str.toCharArray();

        for (int[] row: t)
            Arrays.fill(row, -1);

        System.out.println("minimum no. of cuts required is " + solve(arr, 0, n-1));
    }

    public static boolean isPalindrome(char[] arr, int i, int j){
        while (i<j) {
            if (arr[i] != arr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int solve(char[] arr, int i, int j){
        if(i>=j || isPalindrome(arr, i, j))
            return 0;
        if (t[i][j] != -1)
            return t[i][j];

        int mn, temp_ans;
        mn = temp_ans = Integer.MAX_VALUE;
        // int temp_ans = -1;
        for (int k = i; k<j; k++) {
//            temp_ans = solve(arr, i, k) + 1 + solve(arr, k + 1, j);
            int left, right;
            if(t[i][k] == -1){
                left = solve(arr, i, k);
            }
            else
                left = t[i][k];

            if(t[k+1][j] == -1){
                right = solve(arr, k+1, j);
            }
            else
                right = t[k+1][j];
            temp_ans = left + right + 1;
            mn = Math.min(mn, temp_ans);
        }

        return t[i][j] = mn;
    }
}

