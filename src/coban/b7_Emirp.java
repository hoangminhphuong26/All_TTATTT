/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Vu lan anh;
 */

public class b7_Emirp {
    public static void main(String[] args) {
         int n;
       
        Scanner sc=new Scanner(System.in);       
        System.out.println("Nhap n: ");
        n=sc.nextInt();
      
        for(int i=2;i< n;i++){
            if(fermat(i,5)) {
                    int a= reverse(i);
                    if(fermat(a,5)){
                    System.out.println(" "+i);}
            }  
        }
    }
      
       public static int reverse(int x){
        int rev=0;
        while(x>0){
            rev=rev*10+ x%10;
            x=x/10;
        }
        return rev;
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
