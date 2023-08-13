import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int gcd, A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        int[] AB = new int[]{Math.max(A,B), Math.min(A,B)};

        for (int i = 0; AB[i%2] % (gcd = AB[(i+1)%2]) > 0; i++)
            AB[i%2] %= AB[(i+1)%2];
        System.out.println(gcd+"\n"+(A*B/gcd));
    }
}