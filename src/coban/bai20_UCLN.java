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
public class bai20_UCLN {
    public static void main(String[] args) {
        int m,n,d;
        Scanner sc=new Scanner(System.in);
        do{
        System.out.println("Nhap m:");
        m=sc.nextInt();
        System.out.println("Nhap n");
        n=sc.nextInt();
        System.out.println("Nhap d");
        d=sc.nextInt();
        }while (m<1 || n<1 || d<1 || n>=1000 || m>=1000||d>=1000 ||n<m );
        if(d>n) System.out.println("Khong co");
        for (int i = m+1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(d==UCLN(i,j)) 
                    System.out.println("cap so do la: ("+i+","+j+")");
                
            }         
        }
        
    }
    public static int UCLN(int a, int b){
        int r;
        while(b>0){
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
