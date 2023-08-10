import java.io.*;

public class Main {
    private static int numOfK(int n, int k, int pow){
        if (n/(int)Math.pow(k, pow) == 0) return 0;
        return n/(int)Math.pow(k, pow) + numOfK(n, k, pow+1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(Math.min(numOfK(N, 2, 1), numOfK(N, 5, 1)));
    }
}