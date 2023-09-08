import java.io.*;

public class Main {
    private static char[][] pattern;
    private static void printStar(int N){
        for (int j = 0; j < N; j++)
            pattern[2*N-2][4*N-4-j] = pattern[2*N-2][j] = pattern[0][4*N-4-j] = pattern[0][j] = '*';
        for (int i = 1; i < N; i++)
            pattern[i][i] = pattern[i][i+N-1] = pattern[i][4*N-4-i] = pattern[i][3*N-3-i] =
                pattern[2*N-2-i][i] = pattern[2*N-2-i][i+N-1] = pattern[2*N-2-i][4*N-4-i] = pattern[2*N-2-i][3*N-3-i] = '*';
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        pattern = new char[2*N-1][];
        for (int i = 0; i < N; i++){
            pattern[i] = new char[4*N-3-i];
            pattern[2*N-2-i] = new char[4*N-3-i];
        }
        printStar(N);
        for (char[] p : pattern) {
            for (char c : p)
                sb.append(c == '*' ? '*' : ' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
