import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n;

        while ((n = br.readLine()).charAt(0) != '0')
            bw.write(n.contentEquals(new StringBuilder(n).reverse())?"yes\n":"no\n");
        bw.flush();
    }
}