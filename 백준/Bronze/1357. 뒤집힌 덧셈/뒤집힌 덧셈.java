import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A = new BigInteger(new StringBuilder(st.nextToken()).reverse().toString()),
                   B = new BigInteger(new StringBuilder(st.nextToken()).reverse().toString());
        System.out.println(Integer.parseInt(new StringBuilder(A.add(B).toString()).reverse().toString()));
    }
}