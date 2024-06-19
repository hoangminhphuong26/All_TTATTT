/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DeKetThucHocPhan;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hoang Thang;
 */
public class Cau39 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số phần tử trong mảng: ");
        int n = scan.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ "+(i+1)+" là: ");
            A[i] = scan.nextInt();
        }
        xuLy(A, n);
    }
    
    public static void xuLy(int[] A, int n) {
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(fermat(UCLN(A[i], A[j]), 5)) {
                    System.out.println("("+A[i]+","+A[j]+")");
                }
            }
        }
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
            //chọn ngẫu nhiên a trong khoảng 2<=a<=n-2
            a = (new Random().nextLong(n-3))+2;
            r = binhPhuongCoLap(a, n-1, n);
            if(r != 1){
                return false;
            }
            a++;
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
