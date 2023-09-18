import java.io.*;
import java.util.*;

public class Main {
    private static Map<String, String> parent;
    private static Map<String, Integer> setSize;
    private static int union(String f1, String f2){
        String x = find(f1), y = find(f2);
        if (x.compareTo(y)>0) {
            if (x.equals(y)) return setSize.get(y);
            parent.put(x, y);
            setSize.put(y, setSize.get(y)+setSize.remove(x));
            return setSize.get(y);
        }
        else {
            if (x.equals(y)) return setSize.get(x);
            parent.put(y, x);
            setSize.put(x, setSize.get(x)+setSize.remove(y));
            return setSize.get(x);
        }
    }
    private static String find(String f){
        if (f.equals(parent.get(f))) return f;
        parent.put(f, find(parent.get(f)));
        return parent.get(f);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            parent = new HashMap<>();
            setSize = new HashMap<>();
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken(), f2 = st.nextToken();

                if (!parent.containsKey(f1)){
                    parent.put(f1, f1);
                    setSize.put(f1, 1);
                }
                if (!parent.containsKey(f2)){
                    parent.put(f2, f2);
                    setSize.put(f2, 1);
                }
                bw.write(union(f1, f2) + "\n");
            }
        }
        bw.close();
    }
}
