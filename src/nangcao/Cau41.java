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
public class Cau41 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a,k,n;
        do{
            System.out.print("Nhap a: ");
            a = scan.nextInt();
            System.out.print("Nhap k: ");
            k = scan.nextInt();
            System.out.print("Nhap n: ");
            n = scan.nextInt();
        }while(a<1||k<1||a>n||k>n||n>1000);
        int r=Binhphuongcolap(a, k, n);
        System.out.println("a^k mod n="+r);
        if(fermat(r, 5)) {
            System.out.println("So Nguyen To"); 
        }else {
            System.out.println("khong la so nguyen to");
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
