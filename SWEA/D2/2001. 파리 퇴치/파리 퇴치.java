import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), maxKill = 0;
        	int[][] sumField = new int[N + 1][N + 1];
        	
        	for (int i = 1; i <= N; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		for (int j = 1; j <= N; j++) {
        			int I = Math.max(i - M, 0), J = Math.max(j - M, 0);
        			
        			sumField[i][j] = sumField[i - 1][j] + sumField[i][j - 1] - sumField[i - 1][j - 1] + Integer.parseInt(st.nextToken());
        			maxKill = Math.max(maxKill, sumField[i][j] - sumField[I][j] - sumField[i][J] + sumField[I][J]);
        		}
        	}
        	sb.append('#').append(tc).append(' ').append(maxKill).append('\n');
        }
        System.out.println(sb);
    }
	
}