import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] alphabet = new int[26];
        
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i)-'a']++;
        for (int a : alphabet)
            sb.append(a).append(" ");
        System.out.println(sb);
    }
}
