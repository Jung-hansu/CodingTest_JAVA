import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ATM = new int[N];

        for (int i = 0; i < N; i++) ATM[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(ATM);
        for (int i = 0; i < N; i++) total += (N - i) * ATM[i];
        System.out.println(total);
    }
}
