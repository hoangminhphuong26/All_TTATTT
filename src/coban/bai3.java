/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;

/**
 *
 * @author Vu Lan Anh
 */
//-k là số ước nguyên tố của N;
//-q là tổng của các ước nguyên tố của N;
//-p là tổng của các ước số của N;
//-s là số ước của N;
import java.util.Scanner;
public class bai3 {
    public static void main(String[] args) {
        int N, k, q,p,s, t,i,j;
        k=q=p=s=0;
       
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Nhap n:");
            N=sc.nextInt();
        }while(N<0);
    
        int[] a = new int[N+1];
        for (i=2; i<=N;i++){
            a[i]=1;
        }       
        for(j=2;j<N;j++){
            t=N/j;
            for ( i = 2; i <=t; i++) {
                a[i*j]=0;
           }            
        } 
        for (i = 2; i <=N; i++) {
            if ((a[i]==1) && (N%i==0)){
                q=q+i;
                k++;
            }                            
        }
        System.out.printf("k = %d\nq = %d",k,q);
        
        
        for ( i = 1; i <=N; i++) {
            if(N%i==0){
                p=p+i;
                s++;
            }           
        }
        System.out.printf("\np = %d\ns = %d",p,s);
        System.out.printf("\nKet qua N+p+s-q-k=%d", (N+p+s-q-k));
        
    }
    
}
