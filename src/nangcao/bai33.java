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
public class bai33 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap a(x): ");
        String a = scan.nextLine();
        System.out.println("Nhap g(x): ");
        String g = scan.nextLine();
        int[] muA = nhi(a);
        int[] muB = nhi(g);
        boolean check = true;
        if(muA.length < muB.length) {
            muA = nhi(g);
            muB = nhi(a);
            check = false;
        }
        if(a.equalsIgnoreCase("0")) {
            if(check) {
                System.out.println("1");
                return;
            }else{
                System.out.println("0");
                return;
            }
        }
        int[] x1 = new int[10];
        int[] x2 = new int[10];
        int[] y1 = new int[10];
        int[] y2 = new int[10];
        for(int i = 0; i < 10; i++) {
            x1[i] = x2[i] = y1[i] = y2[i] = 0;
        }
        x2[0] = y1[0] = 1;
        while(true) {
            int[] q = chia(muA, muB);
            int[] r = cong(muA,nhan(q, muB));
            int[] x = cong(x2, nhan(q, x1));
            int[] y = cong(y2, nhan(q, y1));
            muA = muB;
            muB = r;
            x2 = x1;
            x1 = x;
            y2 = y1;
            y1 = y;
            int dem = 0;
            for(int i : muB) {
                dem+=i;
            }
            if(dem == 0) {
                if(check) {
                    System.out.println("a^-1(x)="+hienthi(x2));
                }else {
                    System.out.println("a^-1(x)="+hienthi(y2));
                }
                return;
            }
        }
    }
    
    public static int[] cong(int[] a, int[] b) {
        int n = (a.length > b.length)?a.length:b.length;
        int[] cong = new int[n];
        int i, j;
        i = j = 0;
        while(i < a.length && j < b.length) {
            if(a[i] + b[i] == 2) {
                cong[i] = 0;
            }else if(a[i]+b[i] == 1){
                cong[i] = 1;
            }
            i++;
            j++;
        }
        while(i < a.length) {
            cong[i] = a[i];
            i++;
        }
        while(j < b.length) {
            cong[i] = b[i];
            j++;
        }
        return cong;
    }
    
    public static int[] nhan(int[] a, int[] b) {
        int n = a.length + b.length - 1;
        int c;
        int[] nhan = new int[n];
        for(int i = 0; i < n; i++) {
            nhan[i] = 0;
        }
        for(int i = a.length-1; i >= 0; i--) {
            for(int j = b.length-1; j >= 0; j--) {
                if(a[i] == 1 && b[j] == 1) {
                    c = i+j;
                    if(nhan[c] == 1){
                        nhan[c] = 0;
                    }else{
                        nhan[c] = 1;
                    }
                }
            }
        }
        return nhan;
    }
    
    public static int[] chia(int[] a, int[] b) {
        int n = Math.abs(a.length - b.length);
        int[] chia = new int[n+1+5];
        int[] x = new int[n+1+5];
        for(int i = 0; i <= n; i++) {
            x[i] = 0;
            chia[i] = 0;
        }
        int i = a.length - 1;
        int j = 0;
        for(int k = b.length-1; k >= 0; k--) {
            if(b[k] == 1) {
                j = k;
                break;
            }
        }
        
        while(i >= j) {
            if(a[i] == 1 && b[j] == 1) {
                n = i - j;
                x[n] = 1;
                a = cong(a, nhan(x, b));
                chia[n] = 1;
                for(int k = 0; k <= n; k++) {
                    x[k] = 0;
                }
            }else{
                i--;
            }
        }
        return chia;
    }
    
    public static String hienthi(int[] x) {
        String kq = "";
        for(int i = x.length-1; i >= 0; i--) {
            if(x[i] == 1) {
                if(i == 0) {
                    kq += "1+";
                }else if(i == 1) {
                    kq += "x+";
                }else{
                    kq +="x^"+i+"+";
                }
            }
        }
        kq = kq.substring(0, kq.length()-1);
        return kq;
    }
    
    public static int[] nhi(String a) {
        String[] A = a.split("\\+");
        int n;
        if(A[0].length() == 1 && A[0].equalsIgnoreCase("1")) {
            n = 1;
        }else if(A[0].length() == 1 && A[0].equalsIgnoreCase("x")) {
            n = 2;
        }else {
            n = Integer.valueOf(A[0].substring(2)) + 1;
        }
        int[] muA = new int[n];
        for(int i = 0 ; i < muA.length; i++) {
            muA[i] = 0;
        }
        for(String i : A) {
            if(i.length() == 1) {
                if(i.equalsIgnoreCase("1")) {
                    muA[0] = 1;
                }else if(i.equalsIgnoreCase("x")) {
                    muA[1] = 1;
                }
            }else{
                muA[Integer.valueOf(i.substring(2))] = 1;
            }
        }
        return muA;
    }
}
