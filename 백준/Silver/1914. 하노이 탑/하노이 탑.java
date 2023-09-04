import java.io.*;
import java.math.BigInteger;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static long ans = 0;
    private static void hanoi(int N, int from, int via, int to){
        if (N == 1) {
            ans++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(N-1, from, to, via);
        hanoi(1, from, via, to);
        hanoi(N-1, via, from, to);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            System.out.println(ans+"\n"+sb);
        }
        else System.out.println(new BigInteger("1").shiftLeft(N).subtract(BigInteger.ONE));
    }
}
