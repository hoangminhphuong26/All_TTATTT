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
public class Cau35 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap N: ");
        long n = scan.nextLong();
        System.out.print("Nhap t: ");
        int t = scan.nextInt();
        
        if(MillerRabin(n, t)) {
            System.out.println("Nguyen To");
        }else{
            System.out.println("Hop So");
        }
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
            a = (new Random().nextLong(n-3))+2;
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
