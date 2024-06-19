/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;

/**
 *
 * @author Vu Lan Anh
 */
import java.util.Scanner;
public class bai11 {
    public static void main(String[] args) {
        int n,s;
        s=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap n:");
        n=sc.nextInt();
        int[] a=new int[n+1];
        
        for (int i = 2; i <=n; i++){
            a[i]=1;
        }
        for(int p=2; p<n;p++){
           for (int i = 2; i <=n/p; i++){
                a[p*i]=0;
            } 
        }
        for (int i = 2; i <=n; i++){
            if(a[i]==1) s=s+i;
        }
        System.out.printf("tong cac so ngto nho hon hoac bang %d la: %d",n,s);
        
    }
    
}
