import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new TreeMap<>();
        int total = 0;
        String s;

        while((s = br.readLine()) != null){
            map.put(s, map.getOrDefault(s, 0) + 1);
            total++;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            sb.append(entry.getKey())
              .append(' ')
              .append(String.format("%.4f", 100.0 * entry.getValue() / total))
              .append('\n');
        }
        System.out.print(sb);
    }

}