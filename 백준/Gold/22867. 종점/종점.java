import java.io.*;
import java.util.*;

public class Main {



    private static int convertToMS(String timeFormat){
        
        String[] time = timeFormat.split("[:.]");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        int s = Integer.parseInt(time[2]);
        int ms = Integer.parseInt(time[3]);
        return h * 60 * 60 * 1000 + m * 60 * 1000 + s * 1000 + ms;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int N = Integer.parseInt(br.readLine()), maxSize = 0;
        int[][] buses = new int[N][2];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            buses[i][0] = convertToMS(st.nextToken());
            buses[i][1] = convertToMS(st.nextToken());
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