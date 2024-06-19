/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coban;

/**
 *
 * @author Vu Lan Anh;
 */
import java.util.Random;
import java.util.Scanner;
public class bai12 {
    public static void main(String[] args) {
        int n, j, S;
        S=j=0;
        int tmp=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap n:");
        n=sc.nextInt();
        int [] b=new int[n+1];
       
        for (int i = 2; i <= n; i++) {
            if(fermat(i, 5)){
                b[j]=i;
                j++;
                //System.out.println(i+" ");
            }    
        }
        for (int i = 0; i <= j-4; i++) {
            S=b[i]+b[i+1]+b[i+2]+b[i+3];
            
            if(S<=n && fermat(S, 5)){
                System.out.printf("day so do la %d %d %d %d\n", b[i],b[i+1],b[i+2],b[i+3]);
                tmp=1;
            }    
        }
        if(tmp==0)  System.out.println("khong co");
    }
    
    public static boolean fermat(int n, int t) {
        int r, a;
        if(n < 2) {
            return false;
        }
        if(n == 2 || n == 3) {
            return true;
        }
        for(int i = 1; i <= t; i++) {
            //chọn ngẫu nhiên a trong khoảng 2<=a<=n-2
            a = (new Random().nextInt(n-2))+2;
            r = Binhphuongcolap(a, n-1, n);
            if(r != 1){
                return false;
            }
            a++;
        }
        return true;
    }
    
    public static int Binhphuongcolap(int a, int x, int n) {
        int b = 1;
        if(x == 0){
            return b;
        }
        int A = a;
        int j = 0;
        
        int[] nhiPhan = new int[10000];
        while(x > 0){
            nhiPhan[j++] = x%2;
            x = x/2;
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


