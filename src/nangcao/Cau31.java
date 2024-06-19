/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package nangcao;
/**
 *
 * @author Vu Lan Anh;
 */
import java.util.Random;
import java.util.Scanner;

public class Cau31 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap phan so cua ma sinh vien: ");
        int masv = scan.nextInt();
        System.out.println("Nhap so bao danh: ");
        int a = scan.nextInt();
  
        int lon,nho,the,k;//lon là sngto lớn hơn
        the = masv;
        while(true) {
            if(MillerRabin(the, 5)) {
                lon = the;
                break;
            }
            the++;
        }
        
        the = masv;
        while(true) {
            if(MillerRabin(the, 5)) {
                nho = the;
                break;
            }
            the--;
        }
        if((lon-masv)<(masv-nho)) {
            k = lon;
        }else {
            k = nho;
        }
        System.out.println("so k="+k+"\nSo can tim la: "+binhPhuongCoLap(a, k, 123456));
    }
    
   
    public static boolean MillerRabin(long n, int t) {
        if(n < 2) {
            return false;
        }else if(n == 2 || n == 3) {
            return true;
        }
        int  s=0;
        long a,r;
        long m = n-1;
        while(m%2 == 0){
            m = m/2;
            s++;
        }
        r = m;
        for(int i = 1; i <= t; i++) {
            a = (new Random().nextLong(n-2))+2;
            long y = binhPhuongCoLap(a,r,n);
            if(y != 1 && y != n-1) {
                int j = 1;
                while(j <= s-1 && y != n-1) {
                    y = (y*y) % n;
                    if(y == 1) {
                        return false;
                    }
                    j++;
                }
                if(y != n-1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static long binhPhuongCoLap(long a, long r, long n) {
        long b = 1;
        if(r == 0){
            return b;
        }
        long A = a;
        int j = 0;
        long[] nhiPhan = new long[10000];
        while(r > 0){
            nhiPhan[j++] = r%2;
            r = r/2;
        }
        if(nhiPhan[0] == 1){
            b = a;
        }
        for(int i = 1; i < j;i++){
            A = (int) (Math.pow(A, 2)%n);
            if(nhiPhan[i] == 1) {
                b = ((A*b)%n);
            }
        }
        return b;
    }
}
