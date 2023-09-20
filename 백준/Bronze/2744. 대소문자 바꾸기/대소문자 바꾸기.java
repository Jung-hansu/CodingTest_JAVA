import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') bw.write(s.charAt(i)-'A'+'a');
            else bw.write(s.charAt(i)-'a'+'A');
        bw.newLine();
        bw.close();
    }
}
