import java.io.*;

public class Main {
    private static boolean isPrime(int n, int k){
        int i;
        for (i = 3; i * i <= Math.min(n, k); i += 2)
            if (Math.min(n, k) % i == 0 || Math.max(n, k) % i == 0)
                return false;
        for (; i * i <= Math.max(n, k); i += 2)
            if (Math.max(n, k) % i == 0)
                return false;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine()), res = 0;

            if (N == 4 || N == 5) bw.write("1\n");
            else {
                for (int i = 3; i <= N / 2; i += 2)
                    if (isPrime(i, N - i))
                        res++;
                bw.write(res + "\n");
            }
        }
        bw.close();
    }
}
