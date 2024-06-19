/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package THanh_TTATTT;

import java.util.ArrayList;
import java.util.Scanner;

public class bai11 {
    public static void main(String[] args) {
        int n,tmp;
        
        ArrayList<Integer> coso=new ArrayList <>();
        ArrayList<Integer> somu=new ArrayList <>();
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap n:");
        n=sc.nextInt();
        
       
        for (int i = 2; i <= n; i++) {
            if(checkNT(i)==1 && n%i==0){
                    coso.add(i);
                    
            }
        }
        System.out.print("coso=[");
        for (int i = 0; i < coso.size(); i++) {
            System.out.print(coso.get(i) +" "); 
            
        }
        System.out.print("]");
        
        for (int i = 0; i < coso.size(); i++) {
            tmp=0;
            for (int j=0; j< n/2;j++){
            if(n% coso.get(i)==0) {
                tmp ++;
                n=n/coso.get(i);
            }
            }
            somu.add(tmp);
            
        }
        System.out.print("\nsomu=[");
        for (int i = 0; i < somu.size(); i++) {
            System.out.print(somu.get(i)+" "); 
            
        }
        System.out.print("]");
        
        
    }
    public static int checkNT(int n){
        if (n<2) return 0;
        for (int i = 2; i < n; i++) {
            if(n%i==0)  return 0;     
        }
        return 1;
    }

    
}
