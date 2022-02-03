package com.DPAdityaVerma;
import java.util.*;

public class palindromePartitionRecursive {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = str.length();
        char[] arr = str.toCharArray();

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
        int mn, temp_ans;
        mn = temp_ans = Integer.MAX_VALUE;
        // int temp_ans = -1;
        for (int k = i; k<j; k++) {
            temp_ans = solve(arr, i, k) + 1 + solve(arr, k + 1, j);
            mn = Math.min(mn, temp_ans);
        }

        return mn;
    }
}
