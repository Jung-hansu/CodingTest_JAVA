import java.io.*;
import java.util.*;

public class Main {

    private static long gcd(long a, long b){
        long[] arr = new long[]{Math.max(a, b), Math.min(a, b)};

        for (int i = 0; arr[i ^ 1] > 0; i ^= 1){
            arr[i] %= arr[i ^ 1];
        }
        return Math.max(arr[0], arr[1]);
    }

    private static long lcm(long a, long b){
        return a * b / gcd(a, b);
    }

    private static Map<Long, Long> getPrimes(long n){
        Map<Long, Long> primes = new HashMap<>();

        while ((n & 1) == 0){
            primes.put(2L, primes.getOrDefault(2L, 0L) + 1);
            n >>= 1;
        }

        for (long i = 3; n > 1; i += 2){
            while (n % i == 0) {
                primes.put(i, primes.getOrDefault(i, 0L) + 1);
                n /= i;
            }
        }

        return primes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long x = lcm(a, b), res = 1;

        if (L % x > 0){
            System.out.println(-1);
            return;
        }
        Map<Long, Long> map1 = getPrimes(x);
        Map<Long, Long> map2 = getPrimes(L / x);

        for (long coprime : map2.keySet()){
            res *= (long)Math.pow(coprime, map1.getOrDefault(coprime, 0L) + map2.get(coprime));
        }
        System.out.println(res);
    }

}