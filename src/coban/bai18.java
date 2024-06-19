/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;
/**
 *
 * @author Vu Lan Anh;
 */
//Tổng 2 số hiển thị dạng Mảng và số nguyên
import java.util.Scanner;
public class bai18 {
    public static int W=8;
    public static long p=2147483647;
    public static int t=4;
    public static int [] arr=new int[t];
    public static void main(String[] args) {
        long a,b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so nguyen lon a:");
        a=sc.nextLong();
        System.out.println("Nhap so nguyen lon b:");
        b=sc.nextLong();
        Hienthimang(a);
        Hienthimang(b);
        Tong(a,b);
        System.out.print("\nDang so nguyen: "+(a+b));
  }

    public static int [] BieuDienMang(long n){
        int [] arr=new int[t];
        for (int i = t-1; i >= 0; i--) {
            int a=(int) Math.pow(2,i*W);
            arr[i]=(int)n/a ;
            n-= arr[i]*a;
        }
        return arr;       
    }
    
    public static void Tong(long a, long b){
        int e;
        int m=(int) Math.pow(2,W);
        int [] A=BieuDienMang(a);
        int [] B=BieuDienMang(b);
        int [] C= new int [t];
        C[0]=(A[0]+B[0])%m;
        if((A[0]+B[0])>m )  e=1;
        else    e=0;
        for (int i = 1; i <= t-1; i++) {
            C[i]=(A[i]+B[i]+e)%m;
            if((A[i]+B[i])>m )  e=1;
            else    e=0;
        }
        System.out.print("Dang mang: ("+e+", (");
        for (int i = t-1; i >=0; i--) {
            System.out.print(C[i]+" ");
            
        }
        System.out.print("))");  
    }
    
        public static void Hienthimang(long n){
        int [] arr=new int[t];
        for (int i = t-1; i >= 0; i--) {
            int a=(int) Math.pow(2,i*W);
            arr[i]=(int)n/a ;
            n-= arr[i]*a;
        }
        System.out.print("[");
        for (int i = t-1; i >= 0; i--)
                 System.out.print(arr[i]+" "); 
        System.out.println("]");
    }
}
