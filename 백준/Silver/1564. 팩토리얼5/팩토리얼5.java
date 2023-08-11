import java.io.*;

public class Main {
    private static long getFact5(long n){
        while (n % 10 == 0) n /= 10;
        return n % 1000000000000L;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine()), answer = 1;
        for (long i = N; i > 0; i--) answer = getFact5(answer * i);
        System.out.println("0".repeat(4-(int)Math.log10(answer%100000))+(answer%100000));
    }
}