import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int K = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            for (int i = 1; i <= N; i++) arr[i] = i;
            for (int i = 0; i < K; i++)
                for (int j = 1; j <= N; j++)
                    arr[j] += arr[j-1];
            bw.write(arr[N]+"\n");
        }
        bw.close();
    }
}