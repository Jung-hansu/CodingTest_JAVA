import java.io.*;

public class Main {
    private static char[][] pattern;
    private static void printStar(int N, int i, int j){
        if (N==3){
            for (int k = j; k < j+5; k++) pattern[i][k] = '*';
            pattern[i-1][j+1] = pattern[i-1][j+3] = pattern[i-2][j+2] = '*';
            return;
        }
        printStar(N/2, i, j);
        printStar(N/2, i, j + N);
        printStar(N/2, i - N/2, j + N/2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        pattern = new char[N][2*N];
        printStar(N, N-1, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++)
                sb.append(pattern[i][j]=='*'?'*':' ');
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
