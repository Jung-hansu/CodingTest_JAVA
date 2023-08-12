import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        for (char c = 'a'; c <= 'z'; c++)
            bw.write(s.indexOf(c)+" ");
        bw.flush();
    }
}