import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            String s = br.readLine();
            bw.write(""+s.charAt(0)+s.charAt(s.length()-1)+"\n");
        }
        bw.close();
    }
}
