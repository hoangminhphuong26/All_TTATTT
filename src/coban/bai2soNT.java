
package coban;

/**
 *
 * @author Vu Lan Anh;
 */
import java.lang.Math;
import java.util.Scanner;
public class bai2soNT {
    public static void main(String[] args) {
        int n, a, b, p,t, i;
        
        Scanner sc= new Scanner(System.in);
        
        do{
            System.out.printf("Nhap N: ");
            n=sc.nextInt();
        }while (n<2|| n>10);
        a= (int) Math.pow(10,n-1); 
        b= (int) Math.pow(10,n)-1; 
       
        int [] arr= new int[b+2];
        //dung sang nguyen to
        for( i=a;i<=b; i++){
           arr[i]=1;    
        }  
            for( p=2; p<b;p++){
                 t=b/p;
                 for( i=2;i<=t;i++)
                       arr[p*i]=0;
            }
        
        System.out.printf("So nguyen to co %d chu so la:", n); 
        for( i=a;i<=b;i++){
            if(arr[i]==1)
            { System.out.printf(i +" ");}
        }   
    }   
}
