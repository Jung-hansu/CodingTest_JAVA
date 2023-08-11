import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        System.out.println((long)Math.pow(S/K, K-S%K) * (long)Math.pow(S/K+1, S%K));
    }
}