import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine().toUpperCase();
        int[] alpha = new int[26];
        int max = -1, maxI = -1;

        for (int i = 0; i < s.length(); i++) alpha[s.charAt(i)-'A']++;
        for (int i = 0; i < alpha.length; i++)
            if (alpha[i] > max) max = alpha[maxI = i];
            else if (alpha[i] == max) maxI = -1;
        System.out.println(maxI >= 0 ? (char)('A'+maxI) : "?");
    }
}