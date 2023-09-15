import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String s2 = br.readLine();

        for (int i = 0; i < 3; i++)
            System.out.println(a * (s2.charAt(2-i)-'0'));
        System.out.println(a * Integer.parseInt(s2));
    }
}
