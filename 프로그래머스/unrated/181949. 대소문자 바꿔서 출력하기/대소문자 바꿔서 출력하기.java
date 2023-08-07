import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        for (char c : s.toCharArray())
            bw.write(c >= 'a' && c <= 'z' ? c + 'A' - 'a' : c + 'a' - 'A');
        bw.flush();
    }
}