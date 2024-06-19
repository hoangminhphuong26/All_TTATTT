/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;

/**
 *
 * @author HP
 */
import java.util.Scanner;
public class bai8Tprime {
    public static void main(String[] args) {
        int n,p,t;
        t=0;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Nhap n:");
            n=sc.nextInt();
        }while(n<0);
        
        //System.out.printf("So T_Prime nho hon hoac bang %d la: ",n);
        for(int m=2;m<=n;m++){
            p=2;
            for (int i = 2; i <=m/2; i++) {
                if(m%i==0) p++;    
            }
            if(p==3) {
                System.out.print(m+" ");
                t=1;
            }            
        } 
         if (t==0) System.out.println("khong co so Tprime");
    }   
}
