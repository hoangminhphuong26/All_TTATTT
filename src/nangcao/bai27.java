/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nangcao;

import java.util.Random;


public class bai27 {
    public static void main(String[] args) {
         for(int a = 1; a < 1000; a++) {
            for(int b = a; b < 1000; b++) {
                if(fermat(UCLN(a, b),5)) {
                    System.out.println("("+a+","+b+")");
                }
            }
        }
    }
    
    public static int UCLN(int a, int b){
        int r;
        while(b>0){
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
            //chọn ngẫu nhiên a trong khoảng 2<=a<=n-2
            a = (new Random().nextLong(n-3))+2;
            r = Binhphuongcolap(a, n-1, n);
            if(r != 1){
                return false;
            }
            a++;
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
