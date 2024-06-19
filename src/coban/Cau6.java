/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;

import java.util.Scanner;

/**
 *
 * @author Vu lan anh;
 */
public class Cau6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap N: ");
        int n = scan.nextInt();
        int x, y, tongX, tongY, dem;
        dem = 0; y = 0;
        for(int i = 1; i < n-1; i++) {
            dem = 0;
            x = i;
            tongX = tongUoc(x);
            for(int j = i+1; j < n; j++) {
                y = j;
                tongY = tongUoc(y);
                if(x == tongY && y == tongX) {
                    dem = 1;
                    break;
                }
            }
            if(dem == 1){
                System.out.println("Cap so than thiet la: ("+x+","+y+")");
            }
        }
    }
    
    public static int tongUoc(int a) {
        int tong=0;
        for(int i = 1; i < a; i++) {
            if(a%i == 0) {
                tong+=i;
            }
        }
        return tong;
    }
}
