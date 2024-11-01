import java.io.*;
import java.util.*;

public class Main {
    
    private static int readInt() throws IOException{
        int c, n = 0;
    
        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();

        int clapCnt = 0, time = 0;
        for (int i = 0; i < N; i++) {
            int curDuck = readInt();

            if (time < curDuck){
                time = curDuck + K;
                clapCnt++;
            }
        }
        System.out.println(clapCnt);
    }

}