import java.io.*;

public class Main {
    private static String getLCS(int[][] lcs, String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int i = s1.length(), j = s2.length();

        while (lcs[i][j] > 0){
            if (lcs[i][j] == lcs[i - 1][j]) i--;
            else if (lcs[i][j] == lcs[i][j - 1]) j--;
            else{
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine(), s2 = br.readLine();
        int[][] lcs = new int[s1.length()+1][s2.length()+1];

        for(int i = 1; i <= s1.length(); i++)
            for (int j = 1; j <= s2.length(); j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
        System.out.println(lcs[s1.length()][s2.length()] + "\n" + getLCS(lcs, s1, s2));
    }
}
