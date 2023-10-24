import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> contP = new LinkedList<>();
        BitSet primes = new BitSet();
        int N = Integer.parseInt(br.readLine()), sum = 0, res = 0;

        for (int i = 2; i <= N; i++)
            if (!primes.get(i)) {
                contP.add(i);
                sum += i;
                while (sum > N) sum -= contP.remove();
                if (sum == N) res++;
                for (int j = i * 2; j <= N; j += i) primes.set(j);
            }
        System.out.println(res);
    }
}
