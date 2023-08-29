import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());
            while (N-- > 0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("I")) {
                    int n = Integer.parseInt(st.nextToken());
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
                else if (!map.isEmpty()){
                    if (st.nextToken().equals("1")) {
                        map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                        if (map.lastEntry().getValue() == 0) map.pollLastEntry();}
                    else {
                        map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                        if (map.firstEntry().getValue() == 0) map.pollFirstEntry();}
                }
            }
            bw.write(map.isEmpty() ? "EMPTY\n" : (map.lastKey() + " " + map.firstKey() + "\n"));
        }
        bw.close();
    }
}