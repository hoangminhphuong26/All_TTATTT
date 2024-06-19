/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nangcao;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Vu Lan Anh;
 */
public class Cau40 {
   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap kich thuoc mang: ");
        int n = scan.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.print("A["+i+"]=");
            A[i] = scan.nextInt();
        }
        int tmp=0;
         for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(fermat(UCLN(A[i], A[j]), 5)) {
                    tmp++;
                  // System.out.println("("+A[i]+","+A[j]+")");
                }
            }
        }
         System.out.println("so cap thoa man la: "+tmp);
        
        
    }
    
    
    public static int UCLN(int a, int b) {
        int r;
        while(b>0) {
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
        public static boolean fermat(long n, int t) {
        long r, a;
        if(n < 2) {
            return false;
        }
        if(n == 2 || n == 3) {
            return true;
        }
        for(int i = 1; i <= t; i++) {
            
            a = (new Random().nextLong(n-2))+2;
            r = Binhphuongcolap(a, n-1, n);
            if(r != 1){
                return false;
            }
            
        }
        return true;
    }
    
    public static long Binhphuongcolap(long a, long x, long n) {
        long b = 1;
        if(x == 0){
            return b;
        }
        long A = a;
        int j = 0;
        
        long[] nhiPhan = new long[10000];
        while(x > 0){
            nhiPhan[j++] = x%2;
            x = x/2;
        }
        if(nhiPhan[0] == 1){
            b = a;
        }
        for(int i = 1; i < j;i++){
            A = (int) (Math.pow(A, 2)%n);
            if(nhiPhan[i] == 1) {
                b = ((A*b)%n);
            }
        }
        return b;
    }
}
