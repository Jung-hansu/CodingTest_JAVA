import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        if (N == 1){
            System.out.println(arr[0]);
            return;
        }

        Arrays.sort(arr);
        for (int i = 0; i < N && arr[i] <= 1; i++)
            if (i < N - 1 && arr[i] <= 0 && arr[i + 1] <= 0) ans += arr[i] * arr[++i];
            else ans += arr[i];
        for (int i = N - 1; i >= 0 && arr[i] > 1; i--)
            if (i > 0 && arr[i - 1] > 1) ans += arr[i] * arr[--i];
            else ans += arr[i];
        System.out.println(ans);
    }
}
