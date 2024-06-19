/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vu Lan Anh
 */
public class bai25 {
    public static ArrayList<String> result = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m;
        do{
            System.out.print("Nhap N: ");
            n = scan.nextInt(); 
        }while(n < 1 && n > 10000);
        do{
            System.out.print("Nhap M: ");
            m = scan.nextInt();
        }while(m < 3 && m > 100);
       
        boolean[] x = sangNguyenTo(n);
        int[] a = new int[n];
        int index = 0;
        for(int i = 2; i < x.length; i++) {
            if(x[i]) {
                a[index++] = i;
            }
        }
        tinh(a, index-1, n, "");
        for(String i : result){
            String[] aa = i.split("\\ ");
            if(aa.length == m) {
                System.out.println("So "+n+" la tong cua "+m+" so nguyen ro:\n "+i);
                return;
            }
        }
        System.out.println("So "+n+" khong the phan tich "+m+" so nguyen to");
    }
    
    
    
    public static void tinh(int[] a, int vitri,int tong,String kq){
        if (vitri < -1){
            return;
        }
        if (tong == 0){
            result.add(kq);
            return;
        }
        for(int i = vitri; i > -1; i--) {
            if (tong >= a[i]) {
                String so = "";
                String temp = "";
                so += String.valueOf(a[i]);
                temp = kq;
                temp += so + " ";
                tinh(a, i-1, tong - a[i], temp);
            }
        }
    }
    
    public static boolean[] sangNguyenTo(int b) {
        boolean[] x = new boolean[b+2];
        for(int i = 2; i <= b; i++){
           x[i] = true; 
        }
        for(int i = 2; i <= b; i++) {
            double t = (double) b/i;
            for(int j = 2; j<= t;j++) {
                x[i*j] = false;
            }
        }
        return x;
    }
    
}
