/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Vu Lan Anh;
 */
package coban;

import java.util.Scanner;
public class bai5 {
     public static void main(String[] args) {
        int a,b,n;
        n=0;
        Scanner sc=new Scanner(System.in);       
        System.out.println("Nhap a: ");
        a=sc.nextInt();
        do{
            System.out.println("Nhap b: ");
            b=sc.nextInt();
        }while(b<a);
        int [] arr= new int[b+1];
        if(a==1) {
            for (int i = 2; i <=b; i++) {
            arr[i]=1;           
        }}
        else{
         for (int i = a; i <=b; i++) {
            arr[i]=1;           
        }}
        for (int p = 2; p < b; p++) {
            int t=b/p;
            for (int i = 2; i <=t; i++) {
                arr[i*p]=0;               
            }            
        }
   
        for(int i=a;i<=b;i++){
            if(arr[i]==1) {
                n=n+i;
                System.out.println(i);
            }  
        }
        System.out.printf("Tong cac nguyen to nam trong khoang [%d,%d] la: %d ",a,b,n);
    }
}
