import java.io.*;
import java.util.*;

public class Main {

    private static int readInt() throws IOException{
        int c, n = 0;

        while ((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    private static int readTimeAsMs() throws IOException{
        final int[] weight = {60 * 60 * 1000, 60 * 1000, 1000, 1};
        int c, n = 0, w = 0, ms = 0;

        while((c = System.in.read()) > 32){
            if (Character.isDigit(c)) {
                n = (n << 3) + (n << 1) + (c & 15);
                continue;
            }
            ms += n * weight[w++];
            n = 0;
        }
        return ms + n;
    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int N = readInt(), maxSize = 0;
        int[][] buses = new int[N][2];

        for (int i = 0; i < N; i++){
            buses[i][0] = readTimeAsMs();
            buses[i][1] = readTimeAsMs();
        }

        Arrays.sort(buses, Comparator.comparingInt(bus -> bus[0]));
        for (int i = 0; i < N; i++){
            while (!pq.isEmpty() && pq.element()[1] <= buses[i][0]){
                pq.remove();
            }
            pq.add(buses[i]);
            maxSize = Math.max(maxSize, pq.size());
        }

        System.out.println(maxSize);
    }

}