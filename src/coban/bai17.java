/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Vu Lan Anh;
 */
package coban;
/* 
tìm x s/c Ax2+Bx+C là một số ngtố với A,B,C là các số nguyên nhập vào từ bàn phím. 
*/

import java.util.Scanner;
import java.util.Random;
public class bai17 {
    public static void main(String[] args) {
        int A,B,C,x;
        x=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap A:");
        A=sc.nextInt();
        System.out.println("Nhap B:");
        B=sc.nextInt();
        System.out.println("Nhap C:");
        C=sc.nextInt();

        if(A==B & B==C) System.out.println("Khong co x thoa man");
        else{
          while(true){
           int S=A*x*x+B*x+C;
            if(fermat(S,5)) {
                System.out.print("so x nho nhat la: " +x);
                return;
            }
            x++;
        }     
    }
    }
    
    public static boolean fermat(int n, int t) {
        int r, a;
        if(n < 2) {
            return false;
        }
        if(n == 2 || n == 3) {
            return true;
        }
        for(int i = 1; i <= t; i++) {
            //chọn ngẫu nhiên a trong khoảng 2<=a<=n-2
            a = (new Random().nextInt(n-2))+2;
            r = Binhphuongcolap(a, n-1, n);
            if(r != 1){
                return false;
            }
            a++;
        }
        return true;
    }
    
    public static int Binhphuongcolap(int a, int x, int n) {
        int b = 1;
        if(x == 0){
            return b;
        }
        int A = a;
        int j = 0;
        
        int[] nhiPhan = new int[10000];
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

