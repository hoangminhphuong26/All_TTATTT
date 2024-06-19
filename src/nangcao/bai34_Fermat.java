/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nangcao;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class bai34_Fermat {
    public static void main(String[] args) {
         int t;
         long r,n,a;
         int tmp=0;
         
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap n le va n>=3 :");
        n=sc.nextInt();
        System.out.println("Nhap t:");
        t=sc.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.println("Lan lap thu "+i);
             a = (new Random().nextLong(n-2))+2;
            System.out.println("a="+a);
            r=Binhphuongcolap(a,n -1, n);
            System.out.println("r=a^n-1 mod(n)="+r);
            if(r!=1)    {
                tmp++;
                System.out.println("hop so");
            }
            else System.out.println("nguyen to");
        }
        if(tmp==0)  System.out.println(n+" la nguyen to");
        if(tmp!=0)  System.out.println(n+" la hop so");           
        }
//    public static boolean fermat(long n, int t) {
//        long r, a;
//        if(n < 2) {
//            return false;
//        }
//        if(n == 2 || n == 3) {
//            return true;
//        }
//        for(int i = 1; i <= t; i++) {
//            //chọn ngẫu nhiên a trong khoảng 2<=a<=n-2
//            a = (new Random().nextLong(n-2))+2;
//            r = Binhphuongcolap(a, n-1, n);
//            if(r != 1){
//                return false;
//            }
//            a++;
//        }
//        return true;
//    }
    
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
