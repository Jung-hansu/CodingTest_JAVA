import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> name = new HashMap<>();
        Map<Integer, String> no = new HashMap<>();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++){
            String pokemon = br.readLine();
            name.put(pokemon, i);
            no.put(i, pokemon);
        }
        while (M-- > 0) {
            String s = br.readLine();
            if (s.charAt(0) >= '0' && s.charAt(0) <= '9')
                bw.write(no.get(Integer.parseInt(s))+"\n");
            else
                bw.write(name.get(s)+"\n");
        }
        bw.close();
    }
}