import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BitSet bs = new BitSet();
        int n = 1;

        for (int i = 0; i < 28; i++)
            bs.set(Integer.parseInt(br.readLine()));

        System.out.println(n = bs.nextClearBit(n));
        System.out.println(bs.nextClearBit(n+1));
    }
}
