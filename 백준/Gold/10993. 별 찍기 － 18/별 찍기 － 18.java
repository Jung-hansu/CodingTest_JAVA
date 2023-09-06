import java.io.*;

public class Main {
    private static char[][] pattern;
    private static void printStar(int n, int i, int j){
        if (n == 0) return;
        for (int a = j; a < j+(1<<n+1)-3; a++) pattern[i][a] = '*';
        if (n%2 == 0)
            for (int b = 1; b < (1<<n)-1; b++)
                pattern[i+b][j+b] = pattern[i+b][j+(1<<n+1)-4-b] = '*';
        else
            for (int b = 1; b < (1<<n)-1; b++)
                pattern[i-b][j+b] = pattern[i-b][j+(1<<n+1)-4-b] = '*';
        printStar(n-1, i + ((1<<n-1)-1) * (n%2==0?1:-1), j+(1<<n-1)); //이거 수정하기
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        pattern = new char[(1<<N)-1][];
        if (N%2 == 0)
            for (int i = 0; i < pattern.length; i++)
                pattern[i] = new char[(1<<(N+1))-2-i];
        else
            for (int i = 0; i < pattern.length; i++)
                pattern[i] = new char[(1<<(N+1))-2-pattern.length+i];
        printStar(N, N%2==0?0:pattern.length-1, 0);
        for (char[] p : pattern) {
            for (char c : p) sb.append(c=='*'?'*':' ');
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
