import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder[] pattern;
    private static void setPattern(int n, int i, boolean flag){
        if (n == 3){
            pattern[i].append(flag ? "***" : "   ");
            pattern[i+1].append(flag ? "* *" : "   ");
            pattern[i+2].append(flag ? "***" : "   ");
            return;
        }
        for (int k = 0; k < 3; k++) setPattern(n/3, i, flag);
        for (int k = 0; k < 3; k++) setPattern(n /3, i + n/3, flag && (k%2==0));
        for (int k = 0; k < 3; k++) setPattern(n/3, i + n/3 * 2, flag);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        pattern = new StringBuilder[N];
        for (int i = 0; i < N; i++) pattern[i] = new StringBuilder();
        setPattern(N, 0, true);
        for (StringBuilder s : pattern) System.out.println(s);
    }
}
