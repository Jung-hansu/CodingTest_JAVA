import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

    a:  while (T-- > 0){
            String s = br.readLine();
            int cnt = 0;
            for (int i = 0; i < s.length(); i++){
                cnt += (s.charAt(i)=='(' ? 1 : -1);
                if (cnt < 0){
                    bw.write("NO\n");
                    continue a;
                }
            }
            bw.write(cnt == 0 ? "YES\n" : "NO\n");
        }
        bw.close();
    }
}
