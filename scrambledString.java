package com.DPAdityaVerma;
import java.util.*;

public class scrambledString {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the 2 strings :");
        String a = scn.next();
        String b = scn.next();
        System.out.println(solve(a, b));
    }

    public static boolean solve(String a, String b){

        int n = a.length();
        if (n == 0){
            return true;
        }

        if(n != b.length()){
            return false;
        }

        if(a.equals(b)){
            return true;    // return true for the same string
        }

        char[] arra = a.toCharArray();
        char[] arrb = b.toCharArray();

        Arrays.sort(arra);
        Arrays.sort(arrb);   // to compare the letters of strings

        String g = new String(arra);
        String h = new String(arrb);
        if(!g.equals(h)){
            return false;
        }
        for(int i = 1; i<n; i++){
            if((solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i, n), b.substring(i, n)) || solve(a.substring(n-i, n), b.substring(0, i)) && solve(a.substring(0, n-i), b.substring(i, n)))){
                return true;
                //break;
            }
        }

        return false;
    }
}
