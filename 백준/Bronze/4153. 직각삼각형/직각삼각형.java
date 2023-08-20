import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] sides = new int[3];
            sides[0] = Integer.parseInt(st.nextToken());
            sides[1] = Integer.parseInt(st.nextToken());
            sides[2] = Integer.parseInt(st.nextToken());
            if (sides[0] == 0) break;
            Arrays.sort(sides);
            bw.write(sides[0]*sides[0] + sides[1]*sides[1] == sides[2]*sides[2] ? "right\n" : "wrong\n");
        }
        bw.close();
    }
}