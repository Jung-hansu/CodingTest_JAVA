import java.io.*;
import java.util.*;

public class Main {
    private static int[][] paper;
    private static int[] colors = new int[2];
    private static int isOneTone(int i, int j, int size){
        int tone = paper[i][j];

        for (int I = 0; I < size; I++)
            for (int J = 0; J < size; J++)
                if (paper[i+I][j+J] != tone)
                    return -1;
        return tone;
    }
    private static void cutPaper(int i, int j, int N){
        int tone;
        if ((tone = isOneTone(i, j, N)) >= 0){
            colors[tone]++;
            return;
        }
        cutPaper(i, j, N/2);
        cutPaper(i, j + N/2, N/2);
        cutPaper(i + N/2, j, N/2);
        cutPaper(i + N/2, j + N/2, N/2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        cutPaper(0, 0, N);
        System.out.println(colors[0]+"\n"+colors[1]);
    }
}