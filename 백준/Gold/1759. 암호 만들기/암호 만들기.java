import java.io.*;
import java.util.*;

public class Main {

    private static int L, C;
    private static char[] chars;
    private static char[] codes;

    private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static void dfs(StringBuilder sb, int idx, int depth, int vowel, int consonant){
        if (idx == L){
            if (vowel > 0 && consonant > 1){
                for (char c : codes) {
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }
        if (depth == C){
            return;
        }

        codes[idx] = chars[depth];
        boolean flag = isVowel(codes[idx]);
        dfs(sb, idx + 1, depth + 1, vowel + (flag ? 1 : 0), consonant + (flag ? 0 : 1));
        dfs(sb, idx, depth + 1, vowel, consonant);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C];
        codes = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++){
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);
        dfs(sb, 0, 0, 0, 0);

        System.out.println(sb);
    }

}