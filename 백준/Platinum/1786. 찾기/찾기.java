import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer> res = new ArrayList<>();
    private static int[] table;

    private static void KMP(String s, String pattern) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }

            if (s.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    res.add(i - j + 1);
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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

        sb.append(res.size()).append('\n');
        for (int n : res) {
            sb.append(n).append(' ');
        }

        System.out.println(sb);
    }

}