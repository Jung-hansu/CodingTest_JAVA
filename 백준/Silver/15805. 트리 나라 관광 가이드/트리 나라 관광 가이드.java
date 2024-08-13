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
        StringBuilder sb = new StringBuilder();
        int N = readInt(), prev = readInt();
        int[] parent = new int[N + 1 >> 1];

        parent[prev] = -1;
        for (int i = 1; i < N; i++){
            int cur = readInt();
            
            if (cur != parent[prev]){
                parent[cur] = prev;
            }
            prev = cur;
        }

        sb.append(N + 1 >> 1).append('\n');
        for (int n : parent){
            sb.append(n).append(' ');
        }
        System.out.println(sb);
    }

}