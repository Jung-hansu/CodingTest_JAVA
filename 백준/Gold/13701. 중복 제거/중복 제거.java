import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BitSet bset = new BitSet();
        
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (!bset.get(n)) bw.write(n+" ");
            bset.set(n);
        }
        bw.close();
    }
}
