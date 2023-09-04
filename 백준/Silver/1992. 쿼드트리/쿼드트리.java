import java.io.*;

public class Main {
    private static String[] img;
    private static StringBuilder sb = new StringBuilder();
    private static int isCompressible(int N, int i, int j){
        char c = img[i].charAt(j);
        for (int a = i; a < i+N; a++)
            for (int b = j; b < j+N; b++)
                if (img[a].charAt(b) != c)
                    return -1;
        return c-'0';
    }
    private static void recursive(int N, int i, int j){
        int tmp;
        if ((tmp = isCompressible(N, i, j)) >= 0) {
            sb.append(tmp);
            return;
        }
        sb.append('(');
        recursive(N/2, i, j);
        recursive(N/2, i, j+N/2);
        recursive(N/2, i+N/2, j);
        recursive(N/2, i+N/2, j+N/2);
        sb.append(')');
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        img = new String[N];
        for (int i = 0; i < N; i++) img[i] = br.readLine();
        recursive(N, 0, 0);
        System.out.println(sb);
    }
}
