import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int[] table;
    private static int cnt;

    private static void KMP(String s, String pattern) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }

            if (s.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    sb.append(i - j + 1).append(' ');
                    cnt++;
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine(), P = br.readLine();
        int idx = 0;

        table = new int[P.length()];
        for (int i = 1; i < P.length(); i++) {
            while (idx > 0 && P.charAt(i) != P.charAt(idx)){
                idx = table[idx - 1];
            }
            if (P.charAt(i) == P.charAt(idx)) {
                table[i] = ++idx;
            }
        }

        KMP(T, P);

        System.out.println(cnt);
        System.out.println(sb);
    }

}