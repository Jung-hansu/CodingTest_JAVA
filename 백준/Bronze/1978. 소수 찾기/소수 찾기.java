import java.io.*;
import java.util.*;

public class Main {
    private static boolean isPrime(int n){
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return n != 1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (N-- > 0)
            if (isPrime(Integer.parseInt(st.nextToken())))
                answer++;
        System.out.println(answer);
    }
}