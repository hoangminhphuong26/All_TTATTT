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
public class Cau45 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập N: ");
        int n = scan.nextInt();
        xuLy(n);
    }
    
    public static void xuLy(int n) {
        int[] A = new int[n];
        int x;
        for(int i = 0; i < n; i++) {
            while(true){
                x = (new Random().nextInt(1000-2))+2;
                if(MillerRabin(x, 5)) {
                    break;
                }
            }
            A[i] = x;
        }
        int min;
        //sắp xếp;
        for(int i = 0; i < n-1;i++) {
            for(int j = i+1; j < n; j++) {
                if(A[i] > A[j]) {
                    min = A[i];
                    A[i] = A[j];
                    A[j] = min;
                }
            }
        }
        // tính min
        min = A[1] - A[0];
        for(int i = n-1; i > 0; i--) {
            if(min > A[i]-A[i-1]) {
                min = A[i]-A[i-1];
            }
        }
        System.out.print("Mảng số nguyên tố là: (");
        String kq="";
        for(int i : A) {
            kq += i+", ";
        }
        System.out.print(kq.substring(0, kq.length()-2) + ")");
        System.out.println("\nKhoảng cách nhỏ nhất giữa 2 số bất kỳ trong mảng là: " + min);
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
