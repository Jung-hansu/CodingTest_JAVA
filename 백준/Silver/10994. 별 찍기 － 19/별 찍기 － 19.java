import java.io.*;

public class Main {
    private static char[][] pattern;
    private static void printStar(int n, int i, int j){
        if (n==1){
            pattern[i][j] = '*';
            return;
        }
        for (int J = j+1; J < j + 4*(n-1); J++) pattern[i][J] = '*';
        for (int J = j+1; J < j + 4*(n-1); J++) pattern[pattern.length-i-1][J] = '*';
        for (int I = i; I < i + 4*(n-1) + 1; I++) pattern[I][j] = '*';
        for (int I = i; I < i + 4*(n-1) + 1; I++) pattern[I][pattern[0].length-j-1] = '*';
        printStar(n-1, i + 2, j + 2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        pattern = new char[4*(N-1)+1][4*(N-1)+1];
        printStar(N, 0, 0);
        for (char[] p : pattern) {
            for (char c : p) sb.append(c == '*' ? '*' : ' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
