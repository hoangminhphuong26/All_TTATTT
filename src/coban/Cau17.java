/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;

import java.util.Scanner;

/**
 *
 * @author Hoang Thang;
 */
public class Cau17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập A: ");
        long a = scan.nextLong();
        System.out.print("Nhập B:");
        long b = scan.nextLong();
        System.out.print("Nhập C: ");
        long c = scan.nextLong();
        int x = 1;
        long tong, check;
        while(true) {
            tong = a*x*x + b*x + c;
            check = 1;
            for(int i = 2; i <= Math.sqrt(tong); i++) {
                if(tong % i == 0) {
                    check = 0;
                }
            }
            if(check == 1) {
                System.out.println("Số nguyên dương x nhỏ nhất là: " + x);
                return;
            }
            x++;
        }
    }
}
