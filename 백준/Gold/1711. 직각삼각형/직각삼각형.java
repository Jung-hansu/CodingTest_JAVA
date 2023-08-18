import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans = 0;
        long[][] dots = new long[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots[i] = new long[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        for (int i = 0; i < N-2; i++)
            for (int j = i+1; j < N-1; j++)
                for (int k = j+1; k < N; k++){
                    long a = (dots[i][0]-dots[j][0])*(dots[i][0]-dots[j][0])+(dots[i][1]-dots[j][1])*(dots[i][1]-dots[j][1]),
                         b = (dots[i][0]-dots[k][0])*(dots[i][0]-dots[k][0])+(dots[i][1]-dots[k][1])*(dots[i][1]-dots[k][1]),
                         c = (dots[j][0]-dots[k][0])*(dots[j][0]-dots[k][0])+(dots[j][1]-dots[k][1])*(dots[j][1]-dots[k][1]);
                    if (a == b + c || b == a + c || c == a + b) ans++;
                }
        System.out.println(ans);
    }
}
