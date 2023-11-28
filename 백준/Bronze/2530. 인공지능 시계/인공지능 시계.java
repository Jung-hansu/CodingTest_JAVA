import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()),
            C = Integer.parseInt(st.nextToken()), D = Integer.parseInt(br.readLine());

        A += (B += (C += D) / 60) / 60;
        A %= 24;
        B %= 60;
        C %= 60;
        System.out.println(A+" "+B+" "+C);
    }
}
