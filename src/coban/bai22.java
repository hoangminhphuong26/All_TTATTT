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

public class bai22 {
    public static void main(String[] args) {
        int L,R;
        Scanner sc = new Scanner(System.in);
        
        do{
        System.out.println("Nhap L: ");
        L=sc.nextInt();
        System.out.println("Nhap R: ");
        R=sc.nextInt();
        }while(R<L);
        int S=0;
        for (int i = L; i <= R; i++) {
            
            for (int j = i+1; j <= R; j++) {
                S=tinhF(i)*tinhF(j);
                System.out.println("F("+i+")*F("+j+")= "+S);
            }         
        }       
    }
    
    public static int tinhF(int d){
         if(Fermat(d,5))   return (d);
         else return 0;
    }
    
    public static boolean  Fermat(long n, int t){
        if(n<2) return false;
        if(n==2) return true;
        for (int i = 1; i <= t; i++) {   
            //int a=rand.nextInt(n-2)+2;
            long a = (new Random().nextLong(n-2))+2;
            long r=Binhphuongcolap(a,n-1,n);
            
            if(r!=1)  return false;
            
        }
     
        return true;
    }
    
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
