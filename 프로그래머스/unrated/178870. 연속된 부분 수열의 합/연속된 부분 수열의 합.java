class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, Integer.MAX_VALUE};
        int sum = sequence[0], i = 0, j = 0;
        while (i < sequence.length){
            if (sum == k && j-i < answer[1]-answer[0])
                answer = new int[]{i, j};
            else if (sum < k && j+1 < sequence.length)
                sum += sequence[++j];
            else
                sum -= sequence[i++];
        }
        return answer;
    }
}