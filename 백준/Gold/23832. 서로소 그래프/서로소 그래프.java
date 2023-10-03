import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> getPrimeFactor(int n){
        List<Integer> ret = new ArrayList<>();

        for (int i = 2; n > 1; i++)
            if (n % i == 0){
                ret.add(i);
                while (n % i == 0)
                    n /= i;
            }
        return ret;
    }
    private static long eulerPhi(int n){
        List<Integer> pFactors = getPrimeFactor(n);
        int res = n;

        for (int p : pFactors)
            res = res / p * (p-1);
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long res = 0;

        for (int i = 2; i <= N; i++)
            res += eulerPhi(i);
        System.out.println(res);
    }
}
