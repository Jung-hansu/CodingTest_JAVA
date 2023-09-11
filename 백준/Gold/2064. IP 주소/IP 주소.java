import java.io.*;
import java.util.*;

public class Main {
    private static void printIP(long ip){
        System.out.println((ip>>24)+"."+((ip>>16)&255)+"."+((ip>>8)&255)+"."+(ip&255));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] IP = new long[N];

        for (int i = 0; i < N; i++){
            String[] s = br.readLine().split("\\.");
            for (int j = 0; j < 4; j++)
                IP[i] = (IP[i] << 8) + Long.parseLong(s[j]);
        }
        Arrays.sort(IP);
        long hb = Long.highestOneBit(IP[N-1]^IP[0]);
        if (hb == 0){
            printIP(IP[0]);
            printIP((1L<<32)-1);
        }
        else {
            printIP(IP[0] & -(hb << 1));
            printIP(((1L << 32) - 1) & -(hb << 1));
        }
    }
}
