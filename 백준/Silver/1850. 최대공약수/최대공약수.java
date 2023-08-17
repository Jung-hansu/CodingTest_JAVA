import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[2];
        int i;

        arr[0] = Long.parseLong(st.nextToken());
        arr[1] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);
        for (i = 0; arr[i%2] % arr[(i+1)%2] > 0; i++)
            arr[i%2] %= arr[(i+1)%2];
        System.out.println("1".repeat((int)arr[(i+1)%2]));
    }
}
