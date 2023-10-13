import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine(), s2 = br.readLine(), s3 = br.readLine();
        int[][][] lcs = new int[s1.length()+1][s2.length()+1][s3.length()+1];

        for(int i = 1; i <= s1.length(); i++)
            for (int j = 1; j <= s2.length(); j++)
                for (int k = 1; k <= s3.length(); k++)
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(k - 1))
                        lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
                    else
                        lcs[i][j][k] = Math.max(Math.max(lcs[i - 1][j][k], lcs[i][j - 1][k]), lcs[i][j][k - 1]);
        System.out.println(lcs[s1.length()][s2.length()][s3.length()]);
    }
}
