import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(br.readLine());

        while (N-- > 1){
            String s = br.readLine();
            for (int i = 0; i < sb.length(); i++)
                if (sb.charAt(i) != s.charAt(i))
                    sb.setCharAt(i, '?');
        }
        System.out.println(sb);
    }
}
