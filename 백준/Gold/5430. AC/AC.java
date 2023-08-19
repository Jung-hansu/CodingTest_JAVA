import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));
            try {
                for (int i = 0; i < func.length(); i++)
                    if (func.charAt(i) == 'R') flag = !flag;
                    else list.remove(flag ? list.size() - 1 : 0);
                if (flag) Collections.reverse(list);
                bw.write(list.toString().replaceAll(" ", "") + "\n");
            }
            catch (Exception e){ bw.write("error\n"); }
        }
        bw.close();
    }
}
