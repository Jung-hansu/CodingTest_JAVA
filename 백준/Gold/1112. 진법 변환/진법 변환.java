import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static void convertDigit(int A, int B) throws IOException{
        if (A == 0) return;

        int q = A/B, r = A - q*B;
        if (r < 0) {
            q++;
            r -= B;
        }
        convertDigit(q, B);
        bw.write(String.valueOf(r));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        if (A == 0){
            System.out.println(0);
            return;
        }
        if (A < 0 && B > 0){
            bw.write('-');
            convertDigit(-A, B);
            bw.newLine();
            bw.close();
            return;
        }
        convertDigit(A, B);
        bw.newLine();
        bw.close();
    }
}
