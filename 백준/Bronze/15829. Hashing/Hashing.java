import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        long hash = 0;
        String s = br.readLine();

        for (int i = 0; i < L; i++)
            hash = (hash + (s.charAt(i)-'a'+1)*(long)Math.pow(31, i) % 1234567891) % 1234567891;
        System.out.println(hash);
    }
}