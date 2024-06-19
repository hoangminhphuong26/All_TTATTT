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
public class bai10 {
    public static void main(String[] args) {
        int n,m,k;
        k=m=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap n:");
        n=sc.nextInt();
        int [] arr=new int[n+1];
        for (int i = 2; i <= n; i++) {
            arr[i]=1;   
        }
        for (int p = 2; p <n; p++) {
            for (int i = 2; i <=n/p; i++) {
                arr[p*i]=0;   
            }}
        for (int i = 2; i <=n; i++) {
                if((arr[i]==1)&&(n%i==0)){ 
                    m++;
                   // System.out.println(i+" ");
                }
            }
       System.out.printf("So uoc nguyen to la: %d\n",m);
       for (int i = 1; i <=n; i++) {
           if(n%i==0){
               k++;    
           }       
       }
        System.out.printf("So uoc la: %d\n", k);
        
    }
}
