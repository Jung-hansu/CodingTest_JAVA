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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        for (int i = N; i <= M; i++)
            if (isPrime(i)) bw.write(i+"\n");
        bw.close();
    }
}