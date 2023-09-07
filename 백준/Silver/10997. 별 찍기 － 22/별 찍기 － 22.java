import java.io.*;

public class Main {
    private static char[][] pattern;
    private static void printStar(int N){
        int si = pattern.length-2*N+1, sj = pattern[0].length/2;
        pattern[si][sj] = pattern[--si][sj] = pattern[--si][sj] = '*';

        for (int n = 2; n <= N; n++){
            pattern[si][++sj] = pattern[si][++sj] = '*';
            for (int j = 0; j < 4*(n-1); j++) pattern[++si][sj] = '*';
            for (int j = 0; j < 4*(n-1); j++) pattern[si][--sj] = '*';
            for (int j = 0; j < 4*(n-1)+2; j++) pattern[--si][sj] = '*';
            for (int j = 0; j < 4*(n-1); j++) pattern[si][++sj] = '*';
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        pattern = new char[4*N-1][4*N-3];
        if (N==1) System.out.println("*");
        else {
            printStar(N);
            for (int i = 0; i < pattern.length; i++) {
                for (int j = 0; j < (i==1? 1 : pattern[0].length); j++)
                    sb.append(pattern[i][j] == '*' ? '*' : ' ');
                sb.append(" \n");
            }
        }
        System.out.println(sb);
    }
}
