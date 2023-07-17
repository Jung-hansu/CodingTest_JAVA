class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] di = {0, 1, 0, -1}, dj = {1, 0, -1, 0};
        int i = 0, j = 0, D = 0;
        
        for (int num = 1; num <= n*n; num++){
            answer[i][j] = num;
            if (i+di[D] >= n || j+dj[D] >= n || j+dj[D] < 0 || answer[i+di[D]][j+dj[D]] > 0)
                D = (D+1)%4;
            i += di[D];
            j += dj[D];
        }
        return answer;
    }
}