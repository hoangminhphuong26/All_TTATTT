/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package THanh_TTATTT;
//Fermat
import java.util.Scanner;
import java.util.ArrayList;
public class bai12 {
    public static void main(String[] args) {
        int n ,t, a;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("Nhap n le va n>=3 :");
            n=sc.nextInt();
        }while (n<3 && n%2==0);
        
        System.out.println("Nhap so lan lap:");
        t=sc.nextInt();
        int tmp=0;
        for (int i = 1;i<= t; i++) {
            
            System.out.printf("lan lap thu %d", i);
            a = (int)(Math.random() * ((n-2) - 2 + 1) + 2);
            //tinh r=b=a^(n-1)mod n= a^x mod n
            //pp nhan binh phuong co lap
            System.out.println("\nVoi a="+a);
            int A,b,x;
            int j=0;
            x=n-1;
            b=1;
            A=a;
            ArrayList<Integer> k=new ArrayList<>();
            if (n-1==0) System.out.println("r=b=1");
            // chuyen mũ x sang nhị phân
            while (x>0){               
                k.add(x%2);
                x=(x-k.get(j))/2;
                j++;
            }
            if(k.get(0)==1) b=a;
            for (int d = 1; d <= j-1; d++) {
                A=(A*A)%n;
                if(k.get(d)==1)
                    b=(A*b)%n;  
              
            }
            System.out.println("(r=a^n-1)mod n="+b);  
            if(b!=1) tmp=1;
            
        }
        
        if(tmp==0) System.out.println(n+" la so nguyen to");
        if(tmp==1) System.out.println(n+" la hop so");
        
    }
    
}
