import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (char c : br.readLine().toCharArray())
            bw.write(c >= 'a' && c <= 'z' ? c + 'A' - 'a' : c + 'a' - 'A');
        bw.flush();
    }
}