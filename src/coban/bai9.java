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
public class bai9 {
    public static void main(String[] args) {
        int N,t;
        t=0;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Nhap N:");
            N=sc.nextInt();
        }while(N<0);
        int [] arr=new int[N+1];
        for (int i =2 ; i <= N; i++) {
            arr[i]=1;      
        }
        for (int p = 2; p < N; p++) {
            for(int i=2;i<=N/p;i++){
                arr[p*i]=0;
            }}
        for (int i = 2; i <= N; i++) {
             if(arr[i]==1) {t++;
             System.out.println(i+" ");}
        }
        System.out.printf("So so nguyen to nho hon hoac bang %d la %d",N,t);    
        
    }
}
