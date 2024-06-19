/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nangcao;

import java.util.Scanner;

/**
 *
 * @author Vu Lan Anh;
 */
public class Cau38 {
    public static void main(String[] args) {
        int a,p;
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap p: ");
         p = scan.nextInt();
        do{
        System.out.print("Nhap a: ");
        a = scan.nextInt();
        }while(a<1 || a>p);
        //nghich dao 9. p>a
        if(gcd(a,p)!=1) System.out.println("khong co nghich dao");
        else{
        int u = a;
        int v = p;
        int x1 = 1;
        int x2 = 0;
        int q,r,x;
        while(u != 1) {
            q = (int) Math.floor((float) v/u);
            r = v - q*u;
            x = x2 - q*x1;
            v = u;
            u = r;
            x2 = x1;
            x1 = x;
        }
        if(x1<0) {
            x1=p+x1;
        }
        System.out.println("Nghich dao cua "+a+" trong truong Fp voi p = "+p+" la: "+x1);
    }}
    
    public static int gcd(int a, int b){
        int r;
        while(b>0){
            r=a%b;
            a=b;
            b=r;   
        }
        return a;
    }
}
