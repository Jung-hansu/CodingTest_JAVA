import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int n1, int n2){
       return n1%n2 == 0 ? n2 : gcd(n2, n1%n2);
    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()),
            gcd = gcd(Math.max(A, B), Math.min(A, B));

        System.out.println(gcd+"\n"+(A*B/gcd));
    }
}