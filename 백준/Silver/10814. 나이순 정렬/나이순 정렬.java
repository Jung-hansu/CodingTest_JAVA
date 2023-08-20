import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new String[]{st.nextToken(), st.nextToken()};
        }
        Arrays.sort(arr, Comparator.comparing(o->Integer.parseInt(o[0])));
        for (String[] a : arr) bw.write(a[0]+" "+a[1]+"\n");
        bw.close();
    }
}