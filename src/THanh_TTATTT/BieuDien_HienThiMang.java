/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package THanh_TTATTT;



/**
 *
 * @author HP
 */
import java.util.Scanner;
public class BieuDien_HienThiMang {
    public static int W=8;
    public static long p=2147483647;
    public static int t=4;
     public static void main(String[] args) {
        long n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so nguyen lon n:");
        n=sc.nextLong();
        BieuDienMang(n);
        
  }
    public static void BieuDienMang(long n){
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
