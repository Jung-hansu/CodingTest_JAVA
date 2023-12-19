import java.io.*;

public class Main {
    private static int mySigmaSq(int N){return N * (N-1) * (2*N-1) / 6;}
    private static int mySigma(int N){return N * (N-1) / 2;}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), sqrtN = (int)Math.sqrt(N), remainder = N - sqrtN*sqrtN;
        System.out.println(N > 0 ? mySigmaSq(sqrtN) + remainder / sqrtN * mySigma(sqrtN) + mySigma(remainder % sqrtN) : 0);
    }
}
