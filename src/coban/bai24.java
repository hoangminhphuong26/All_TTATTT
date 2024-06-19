/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;
/**
 *
 * @author Vu Lan Anh;
 */
import java.util.Scanner;
import java.util.Random;
public class bai24 {
    public static void main(String[] args) {
        int a,b;
        int tmp=0;
        Scanner sc=new Scanner(System.in);
        do{
        System.out.println("Nhap a: ");
        a=sc.nextInt();
        System.out.println("Nhap b:");
        b=sc.nextInt();
        }while(b<a);
        int [] S1=new int[b];
        
        for (int i = 1; i <= Math.sqrt(b); i++) {
            S1[i]=i*i;
        }
        
        for (int i = 1; i <= Math.sqrt(b); i++){
            for (int j = i+1; j <= Math.sqrt(b); j++) {
                int S=S1[i]+S1[j];  //so can tim 
                if(S>=a && S<=b&& fermat(S,5)){
                    tmp++;
                    System.out.println(S+"="+S1[i]+"+"+S1[j]);
                }
            }
        }
        System.out.println("so cac so thoa man: "+tmp);
        
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

