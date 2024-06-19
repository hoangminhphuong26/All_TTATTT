/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nangcao;

import java.util.Random;


/**
 *
 * @author Vu Lan Anh;
 */
public class Cau42 {
    public static void main(String[] args) {
        int p,q;
        do{
            p = (new Random().nextInt(1000-2))+2;
        }while (!MillerRabin(p, 5));
        do{
            q = (new Random().nextInt(1000-2))+2;
        }while (!MillerRabin(q, 5));
        System.out.println("p="+p+"\nq="+q);
        
        System.out.println("Cac so a thoa man a^"+p+" mod "+q+" la so nguyen to la: ");
        for(int i = 1; i < 100; i++) {
            int R=binhPhuongCoLap(i, p, q);
            if(MillerRabin(R, 5)) {
                System.out.println(i+" ");
               // System.out.println(i+"^"+p+" mod "+q+"= "+R);
                
            }
        }
        
    }
    
    public static boolean MillerRabin(int n, int t) {
        if(n < 2) {
            return false;
        }else if(n == 2 || n == 3) {
            return true;
        }
        //n-1=2^s*r
        int  s=0;
        int a,r,m = n-1;
        while(m%2 == 0){
            m = m/2;
            s++;
        }
        r = m;
        for(int i = 1; i <= t; i++) {
            a = (new Random().nextInt(n-2))+2;
            int y = binhPhuongCoLap(a,r,n);
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
    
    public static int binhPhuongCoLap(int a, int r, int n) {
        int b = 1;
        if(r == 0){
            return b;
        }
        int A = a;
        int j = 0;
        int[] nhiPhan = new int[10000];
        while(r > 0){
            nhiPhan[j++] = r%2;
            r = r/2;
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
