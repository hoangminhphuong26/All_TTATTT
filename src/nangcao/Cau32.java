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
public class Cau32 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap m: ");
        int m = scan.nextInt();
        m += 123;
        
         int p,q,e;
        do{
            p = (new Random().nextInt(499))+101;
        }while (!MillerRabin(p, 5));
        do{
            q = (new Random().nextInt(499))+101;
        }while (!MillerRabin(q, 5));
      
        long n = p*q;
        long phi = (p-1)*(q-1);
        
        e=2;
        while(true) {
            if(UCLN(e, phi)==1) {
                break;
            }
            e++;
        } 
        
        long d = nghichDao9(e, phi);
        long c = binhPhuongCoLap(m, e, n);
        System.out.println("p="+p+"\nq="+q+"\nn="+n+"\nphi="+phi+"\ne="+e+"\nd="+d);
        System.out.println("Ban ma cua thong diep "+m+" la: "+c);
        System.out.println("Giai ma "+c+" la: "+binhPhuongCoLap(c, d, n));
    }
    

    
    public static long UCLN(long a, long b) {
        long r;
        while(b>0) {
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
    
    public static long nghichDao9(long a, long p) {
        long u = a;
        long v = p;
        long x1 = 1;
        long x2 = 0;
        long q,r,x;
        while(u != 1) {
            q = (long) Math.floor((double) v/u);//floor lấy cận dưới
            r = v - q*u;
            x = x2 - q*x1;
            v = u;
            u = r;
            x2 = x1;
            x1 = x;
        }
        if(x1<0) {
            x1=p+x1;
        }
        return x1;
    }
    
    public static boolean MillerRabin(long n, int t) {
        if(n < 2) {
            return false;
        }else if(n == 2 || n == 3) {
            return true;
        }
        int  s=0;
        long a,r,m = n-1;
        while(m%2 == 0){
            m = m/2;
            s++;
        }
        r = m;
        for(int i = 1; i <= t; i++) {
            a = (new Random().nextLong(n-2))+2;
            long y = binhPhuongCoLap(a,r,n);
            if(y != 1 && y != n-1) {
                int j = 1;
                while(j <= s-1 && y != n-1) {
                    y = (y*y) % n;
                    if(y == 1) {
                        return false;
                    }
                    j++;
                }
                if(y != n-1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static long binhPhuongCoLap(long a, long r, long n) {
        long b = 1;
        if(r == 0){
            return b;
        }
        long A = a;
        int index = 0;
        long[] nhiPhan = new long[10000];
        while(r > 0){
            nhiPhan[index++] = r%2;
            r = r/2;
        }
        if(nhiPhan[0] == 1){
            b = a;
        }
        for(int i = 1; i < index;i++){
            A = (int) (Math.pow(A, 2)%n);
            if(nhiPhan[i] == 1) {
                b = ((A*b)%n);
            }
        }
        return b;
    }
}
