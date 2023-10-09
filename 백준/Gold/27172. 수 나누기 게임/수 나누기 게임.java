import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> index = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N], ans = new int[N];
        boolean[] check = new boolean[1000001];

        for (int i = 0; i < N; i++) {
            check[arr[i] = Integer.parseInt(st.nextToken())] = true;
            index.put(arr[i], i);
        }
        for (int i = 0; i < N; i++)
            for (int j = arr[i] * 2; j < 1000001; j += arr[i])
                if (check[j]){
                    ans[i]++;
                    ans[index.get(j)]--;
                }
        for (int n : ans) bw.write(n+" ");
        bw.close();
    }
}
