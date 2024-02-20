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
        StringBuilder sb = new StringBuilder();
        L = readInt();
        C = readInt();
        chars = new char[C];
        codes = new char[L];

        for (int i = 0; i < C; i++){
            chars[i] = readChar();
        }

        Arrays.sort(chars);
        dfs(sb, 0, 0, 0, 0);

        System.out.print(sb);
    }

    private static int readInt() throws IOException{
        int c, n = 0;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    private static char readChar() throws IOException{
        int c;

        do
            c = System.in.read();
        while(c <= 32);
        return (char)c;
    }
}