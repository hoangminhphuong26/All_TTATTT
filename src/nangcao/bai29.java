/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nangcao;

import java.util.Scanner;
import java.util.Random;
public class bai29 {
      public static void main(String[] args) {
        int n;
        int dem=0;
        Scanner sc= new Scanner(System.in);
        do{
        System.out.println("Nhap n:");
        n=sc.nextInt();
        }while(n<0 || n>10000);
       
        
        for(int m = 4; m < n; m++) {
            int check1, check2;
            check1=check2=0;
            // điều kiện nó - 1 chia hết cho p-1 với mọi ước nguyên tố p của nó và không chia hết cho bình phương số ng to nao
            int[] uoc = new int[n];
            int x = 0;
            for(int j = 2; j < m; j++) {
               
                if(m%j==0 && MillerRabin(j,5)) { 
                    uoc[x] = j;
                    x++;
                    if(m%(j*j)==0) check1++;
                }
            }
            
            for(int i=0; i<x;i++) {
                if((m-1)%(uoc[i]-1)!=0) {
                    check2++;
                }
            }
        
            if(check1==0&& x != 0 && check2 == 0) {
                dem++;
            }
        }
          System.out.println("so cac so Carmichael la "+dem);
    
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
    
    public static long binhPhuongCoLap(long a, long q, long n) {
        long b = 1;
        if(q == 0){
            return b;
        }
        long A = a;
        int index = 0;
        long[] nhiPhan = new long[10000];
        while(q > 0){
            nhiPhan[index++] = q%2;
            q = q/2;
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
