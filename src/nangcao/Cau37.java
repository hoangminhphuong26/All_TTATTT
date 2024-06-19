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
public class Cau37 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap T: ");
        char[] T = scan.nextLine().toCharArray();
        System.out.print("Nhap P: ");
        char[] P = scan.nextLine().toCharArray();
        xuLy(T, P);
    }
    
    public static void xuLy(char[] T, char[] P) {
        int i,j, m;
        i = j = 0;
        while(i+P.length-1 < T.length) {
            m = i;
            while(T[i] == P[j]) {// neu khop tang 1
                i++;
                j++;
                if(j == P.length) {
                    System.out.println("Xau \""+String.valueOf(P)+"\" nam trong xau \""+String.valueOf(T)+"\" bat dau tu vi tri "+(m+1)+" va ket thuc tai vi tri thu "+i);
                    return;
                }
            }
            i = m;
            i = i+j-F(P, j);
            j = (F(P, j)==-1)?0:F(P, j);// neu =-1 j=0
        }
        System.out.println("Khong tim thay xau \""+String.valueOf(P));
    }
    
    public static int F(char[] P, int j) {
        if(j == 0) {
            return -1;
        }else if(j == 1) {
            return 0;
        }
        String p = String.valueOf(P);
        int dem = 0;
        int k = j-1;
        for(int i = 0; i < j; i++) {
            if(p.substring(i, j).equalsIgnoreCase(p.substring(k, j))) {
                dem++;
            }
            k--;
        }
        return dem;
    }
}
