import java.util.*;public class Main{public static void main(String[]args){Scanner s=new Scanner(System.in);int N=s.nextInt(),a=2*N-2,p;int[]r=new int[N+1];while(N-->0){p=s.nextInt();s.next();r[p]=s.nextInt();}for(int n=1;r[n]>0;n=r[n])a--;System.out.println(a);}}