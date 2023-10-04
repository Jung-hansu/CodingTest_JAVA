import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];

        for (int i = 0; i < N; i++)
            alpha[br.readLine().charAt(0)-'a']++;
        for (int i = 0; i < alpha.length; i++)
            if (alpha[i] >= 5)
                sb.append((char)('a'+i));
        System.out.println(sb.isEmpty()?"PREDAJA":sb);
    }
}
