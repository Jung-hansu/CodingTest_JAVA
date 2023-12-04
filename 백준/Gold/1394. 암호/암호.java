import java.io.*;
import java.util.*;

public class Main {
    private static final int P = 900528;
    private static int sigmaNSq(int N, int K){
        long res = 0;

        for (int i = 1; i <= K; i++)
            res = (res + pow(N, i)) % P;
        return (int)res;
    }
    private static int pow(int N, int K){
        long res = 1;

        for (int i = K; i > 0; i ^= Integer.highestOneBit(i)) {
            long tmp = N;
            for (int j = 1; j < Integer.highestOneBit(i); j <<= 1)
                tmp = tmp * tmp % P;
            res = (res * tmp) % P;
        }
        return (int)res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(), code = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 1;

        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);
        for (int i = 0; i < code.length(); i++)
            ans = (int)((long)ans + map.get(code.charAt(i)) * pow(s.length(), code.length() - i - 1) % P) % P;
        System.out.println((ans + sigmaNSq(s.length(), code.length() - 1)) % P);
    }
}
