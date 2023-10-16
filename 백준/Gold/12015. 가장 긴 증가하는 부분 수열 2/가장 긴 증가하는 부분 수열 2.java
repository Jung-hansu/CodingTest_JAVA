import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), top = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N], lis = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        lis[0] = arr[0];
        for (int n : arr)
            if (n > lis[top]) lis[++top] = n;
            else if (n < lis[top]) {
                int pos = Arrays.binarySearch(lis, 0, top + 1, n);
                lis[pos < 0 ? - pos - 1 : pos] = n;
            }
        System.out.println(top + 1);
    }
}
