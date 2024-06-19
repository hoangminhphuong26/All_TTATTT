/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// nhanh hơn nhiều, thực hiện tốt với bảng chữ lớn, tốt với văn bản thường, kém với nhị phân
package nangcao;

import java.util.Scanner;

/**
 *
 * @author Vu Lan Anh;
 */
public class Cau36 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap T: ");
        char[] T = scan.nextLine().toCharArray();
        System.out.print("Nhap P: ");
        char[] P = scan.nextLine().toCharArray();
        BoyerMoore(T, P);
    }
    
    public static void BoyerMoore(char[] T, char[] P) {
        int i,j;
        i = j = P.length-1;
        while(i < T.length) {
            if(T[i] != P[j]) {
                i = i + P.length - min(j, 1 + L(T[i], P));// sử dụng hàm tiền sử lý L() để nhảy cách
                j=P.length -1;
            }else if(T[i] == P[j]) {
                i--;
                j--;
            }
            if(j == 0) {
                System.out.println("Xau \""+String.valueOf(P)+"\" nam trong xau \""+String.valueOf(T)+"\" bat dau tu vi tri "+(i+1)+" va ket thuc tai vi tri "+(i+P.length));
                return;
            }
        }
        System.out.println("Khong tim thay xau \""+String.valueOf(P)+"\" trong xau \""+String.valueOf(T)+"\"");
    }
    
    public static int min(int a, int b) {
        if(a>b) {
            return b;
        }
        return a;
    }
    // ham tien xu ly L()
    public static int L(char a, char[] P) {//kí tự và 1 chuỗi
        for(int i = P.length-1; i >= 0; i--) {
            if(a == P[i]) {
                return i;
            }
        }
        return -1;
    }
}
