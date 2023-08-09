import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int j, i = 0; i < queries.length; i++){
            int[] tmp = Arrays.copyOfRange(arr, queries[i][0], queries[i][1]+1);
            Arrays.sort(tmp);
            for (j = 0; j < tmp.length && tmp[j] <= queries[i][2]; j++);
            answer[i] = (j < tmp.length ? tmp[j] : -1);
        }
        return answer;
    }
}