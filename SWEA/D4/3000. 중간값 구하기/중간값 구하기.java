import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            PriorityQueue<Integer> minHalf = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> maxHalf = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken());
            long sum = 0;

            minHalf.add(A);
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());

                minHalf.add(Math.min(X, Y));
                maxHalf.add(Math.max(X, Y));
                if (minHalf.element() > maxHalf.element()){
                    minHalf.add(maxHalf.remove());
                    maxHalf.add(minHalf.remove());
                }

                sum = (sum + minHalf.element()) % 20171109;
            }
            sb.append('#').append(tc).append(' ').append(sum).append('\n');
        }
        System.out.println(sb);
    }

}