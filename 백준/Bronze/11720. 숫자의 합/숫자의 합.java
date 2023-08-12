import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), sum = 0;
        String s = br.readLine();

        for (int i = 0; i < N; i++) sum += s.charAt(i)-'0';
        System.out.println(sum);
    }
}